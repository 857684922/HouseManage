package com.xun.housemanage.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/5/10.
 */
public class HouseHelper extends SQLiteOpenHelper {


    public HouseHelper(Context context) {
        super(context, "house.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table house(_id integer primary key autoincrement,house varcahar(20),"
                + "stu1_name varcahar(20),stu1_id varcahar(20),stu1_grade varcahar(20)," +
                "stu2_name varcahar(20),stu2_id varcahar(20),stu2_grade varcahar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}