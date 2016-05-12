package com.xun.housemanage.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.xun.housemanage.Student;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/10.
 */
public class HouseDao {
    private HouseHelper helper;

    public HouseDao(Context context) {
        helper = new HouseHelper(context);
    }

    public void insert(String house, Student stu1, Student stu2) {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("insert into house(house ,stu1_name,stu1_id,stu1_grade,stu2_name,stu2_id,stu2_grade)" +
                "values(?,?,?,?,?,?,?)", new Object[]{
                house, stu1.getName(), stu1.getId(), stu1.getGrade(), stu2.getName(), stu2.getId(), stu2.getGrade()});
        db.close();


    }

    public ArrayList queryAll() {
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList list = new ArrayList();
        Cursor cursor = db.rawQuery("select * from house", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("house"));
            list.add(id);
        }
        db.close();
        return list;
    }

    public Cursor query(String house) {
        Cursor cursor;
        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT  * FROM house where house like '%" + house + "%'", null);
        return cursor;
    }

    public void delete(String house) {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from house where house=?", new String[]{house});
        db.close();
    }
}
