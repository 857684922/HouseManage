package com.xun.housemanage.activity;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xun.housemanage.R;
import com.xun.housemanage.sql.HouseDao;

/**
 * Created by Administrator on 2016/5/11.
 */
public class DeleteActivity extends Activity {
    private EditText et_house;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);
        et_house = (EditText) findViewById(R.id.delete_et_house);
    }

    public void delete(View view) {
        String house = et_house.getText().toString().trim();
        HouseDao dao = new HouseDao(this);
        Cursor cursor = dao.query(house);
        if (cursor.getCount() != 0) {
            dao.delete(house);
            Toast.makeText(DeleteActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DeleteActivity.this, "该宿舍不存在", Toast.LENGTH_SHORT).show();
        }
    }
}
