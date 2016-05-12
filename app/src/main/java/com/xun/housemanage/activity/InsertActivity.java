package com.xun.housemanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xun.housemanage.R;
import com.xun.housemanage.Student;
import com.xun.housemanage.sql.HouseDao;

/**
 * Created by Administrator on 2016/5/10.
 */
public class InsertActivity extends Activity {
    private EditText et_house, et_stu1_name, et_stu1_id, et_stu1_grade,
            et_stu2_name, et_stu2_grade, et_stu2_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        et_house = (EditText) findViewById(R.id.insert_et_house);
        et_stu1_name = (EditText) findViewById(R.id.insert_et_stu1_name);
        et_stu1_id = (EditText) findViewById(R.id.insert_et_stu1_id);
        et_stu1_grade = (EditText) findViewById(R.id.insert_et_stu1_grade);
        et_stu2_name = (EditText) findViewById(R.id.insert_et_stu2_name);
        et_stu2_id = (EditText) findViewById(R.id.insert_et_stu2_id);
        et_stu2_grade = (EditText) findViewById(R.id.insert_et_stu2_grade);
    }

    public void insertSubmit(View view) {
        String house = et_house.getText().toString().trim();
        String stu1_name = et_stu1_name.getText().toString().trim();
        String stu1_id = et_stu1_id.getText().toString().trim();
        String stu1_grade = et_stu1_grade.getText().toString().trim();
        String stu2_name = et_stu2_name.getText().toString().trim();
        String stu2_id = et_stu2_id.getText().toString().trim();
        String stu2_grade = et_stu2_grade.getText().toString().trim();

        Student stu1 = new Student(stu1_name, stu1_id, stu1_grade);
        Student stu2 = new Student(stu2_name, stu2_id, stu2_grade);

        //将数据写入数据库
        new HouseDao(this).insert(house, stu1, stu2);
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        finish();

    }
}
