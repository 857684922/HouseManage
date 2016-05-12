package com.xun.housemanage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.xun.housemanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10.
 */
public class RootActivity extends Activity {
    private GridView gridView;
    private SimpleAdapter sim_adapter;

    private Intent intent;

    private String[] texts = {"宿舍查询", "添加宿舍", "删除宿舍"};
    private int[] icons = {R.drawable.first, R.drawable.second, R.drawable.third};
    private ArrayList<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);
        gridView = (GridView) findViewById(R.id.root_gv);
        list = new ArrayList();

        for (int i = 0; i < texts.length; i++) {
            Map<String, Object> map = new HashMap();
            map.put("image", icons[i]);
            map.put("text", texts[i]);
            list.add(map);
        }
        sim_adapter = new SimpleAdapter(RootActivity.this, list, R.layout.grid_item,
                new String[]{"image", "text"}, new int[]{R.id.gv_item_iv, R.id.gv_item_tv});
        gridView.setAdapter(sim_adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent=new Intent(RootActivity.this,QueryActivity.class);
                        startActivity(intent);
                        System.out.println("0000000000000000000000");
                        break;
                    case 1:
                        intent = new Intent(RootActivity.this, InsertActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(RootActivity.this,DeleteActivity.class);
                        startActivity(intent);
                        System.out.println("222222222222222222");
                        break;
                }
            }
        });
    }
}
