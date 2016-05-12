package com.xun.housemanage.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.xun.housemanage.R;
import com.xun.housemanage.sql.HouseDao;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/10.
 */
public class QueryActivity extends Activity {
    private AutoCompleteTextView autoComplete;
    private ListView listView;
    private SimpleCursorAdapter cur_adapter;

    private ArrayList list;
    private ArrayAdapter arr_adapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_view);

        autoComplete = (AutoCompleteTextView) findViewById(R.id.query_autocomplete);
        listView = (ListView) findViewById(R.id.query_list);

        list = new ArrayList<>();
        list = new HouseDao(this).queryAll();
        arr_adapter = new ArrayAdapter(this, R.layout.auto_item, list);
        autoComplete.setAdapter(arr_adapter);

    }

    public void search(View view) {
        String[] from = {"house", "stu1_name", "stu2_name"};
        int[] to = {R.id.list_tv_house, R.id.list_tv_stu1, R.id.list_tv_stu2};
        String autoText = autoComplete.getText().toString().trim();
        cursor = new HouseDao(QueryActivity.this).query(autoText);

        if (cursor.getCount() == 0) {
            Toast.makeText(QueryActivity.this, "该宿舍不存在", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println(cursor.getCount() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            cur_adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, from, to, 0);
        }
        listView.setAdapter(cur_adapter);

        listView.setOnItemClickListener(new listItemClickListener());
    }

    class listItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int i = 0;
            cursor.moveToFirst();
            while (i < position) {
                cursor.moveToNext();
                i++;
            }
            String house = cursor.getString(cursor.getColumnIndex("house"));
            String stu1_name = cursor.getString(cursor.getColumnIndex("stu1_name"));
            String stu1_id = cursor.getString(cursor.getColumnIndex("stu1_id"));
            String stu1_grade = cursor.getString(cursor.getColumnIndex("stu1_grade"));
            String stu2_name = cursor.getString(cursor.getColumnIndex("stu2_name"));
            String stu2_id = cursor.getString(cursor.getColumnIndex("stu2_id"));
            String stu2_grade = cursor.getString(cursor.getColumnIndex("stu2_grade"));
            Bundle bundle = new Bundle();
            bundle.putString("house", house);
            bundle.putString("stu1_name", stu1_name);
            bundle.putString("stu1_grade", stu1_grade);
            bundle.putString("stu2_name", stu2_name);
            bundle.putString("stu1_id", stu1_id);
            bundle.putString("stu2_id", stu2_id);
            bundle.putString("stu2_grade", stu2_grade);
            Intent intent = new Intent(QueryActivity.this, InfoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
