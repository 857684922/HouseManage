package com.xun.housemanage.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/5/10.
 */
public class UserDao {
    private UserHelper helper;

    // 在构造方法里面完成helper的初始化
    public UserDao(Context context) {
        helper = new UserHelper(context);
    }

    //增
    public void insert(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("insert into user(username,password)values(?,?)", new Object[]{
                username, password});
        db.close();
    }

    //改
    public void update(String username, String password) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("update user set password=? where username =?", new String[]{
                password, username});
        db.close();


    }

    //查询账号是否存在
    public boolean queryUsername(String username) {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from user where username=?",
                new String[]{username});
        boolean result = cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }

    //查询密码是否匹配
    public boolean queryPassword(String username, String password) {
        SQLiteDatabase db = helper.getReadableDatabase();
        boolean result;
        Cursor cursor = db.rawQuery("select * from user where username=?",
                new String[]{username});
        cursor.moveToNext();
        String sqlPassword = cursor.getString(cursor.getColumnIndex("password"));
        if (sqlPassword.equals(password)) {
            result = true;
        } else {
            result = false;
        }
        cursor.close();
        db.close();
        return result;
    }
}
