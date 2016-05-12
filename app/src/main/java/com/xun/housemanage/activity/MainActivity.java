package com.xun.housemanage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.xun.housemanage.R;
import com.xun.housemanage.event.Login;

public class MainActivity extends Activity {
    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        et_username = (EditText) findViewById(R.id.main_et_username);
        et_password = (EditText) findViewById(R.id.main_et_password);
    }

    //登录验证
    public void login(View view) {
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        boolean result = new Login(MainActivity.this, username, password).check();
        if (result) {
            Intent intent = new Intent(this, RootActivity.class);
            startActivity(intent);
        }
    }

    //注册跳转
    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}
