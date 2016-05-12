package com.xun.housemanage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.xun.housemanage.R;

/**
 * Created by Administrator on 2016/5/11.
 */
public class InfoActivity extends Activity {
    private TextView tv_house, tv_stu1_name, tv_stu1_id, tv_stu1_grade,
            tv_stu2_name, tv_stu2_id, tv_stu2_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_view);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String house = bundle.getString("house");
        String stu1_name = bundle.getString("stu1_name");
        String stu1_id = bundle.getString("stu1_id");
        String stu1_grade = bundle.getString("stu1_grade");
        String stu2_name = bundle.getString("stu2_name");
        String stu2_id = bundle.getString("stu2_id");
        String stu2_grade = bundle.getString("stu2_grade");

        tv_house = (TextView) findViewById(R.id.info_tv_house);
        tv_stu1_name = (TextView) findViewById(R.id.info_tv_stu1_name);
        tv_stu1_id = (TextView) findViewById(R.id.info_tv_stu1_id);
        tv_stu1_grade = (TextView) findViewById(R.id.info_tv_stu1_grade);
        tv_stu2_name = (TextView) findViewById(R.id.info_tv_stu2_name);
        tv_stu2_id = (TextView) findViewById(R.id.info_tv_stu2_id);
        tv_stu2_grade = (TextView) findViewById(R.id.info_tv_stu2_grade);

        tv_house.setText(house);
        tv_stu1_name.setText(stu1_name);
        tv_stu1_id.setText(stu1_id);
        tv_stu1_grade.setText(stu1_grade);
        tv_stu2_name.setText(stu2_name);
        tv_stu2_id.setText(stu2_id);
        tv_stu2_grade.setText(stu2_grade);

    }
}
