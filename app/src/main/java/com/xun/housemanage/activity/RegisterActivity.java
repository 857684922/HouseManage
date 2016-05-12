package com.xun.housemanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xun.housemanage.R;
import com.xun.housemanage.sql.UserDao;

/**
 * Created by Administrator on 2016/5/10.
 */
public class RegisterActivity extends Activity {
    private EditText et_username;
    private EditText et_password;
    private EditText et_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        et_username = (EditText) findViewById(R.id.register_et_username);
        et_password = (EditText) findViewById(R.id.register_et_password);
        et_confirm = (EditText) findViewById(R.id.register_et_confirm);
    }

    public void submit(View view) {
        UserDao dao = new UserDao(RegisterActivity.this);
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String confirm = et_confirm.getText().toString().trim();
        if (!dao.queryUsername(username)) {
            if (password.equals(confirm)) {
                dao.insert(username, password);
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                finish();
            } else {
                Toast.makeText(RegisterActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
        }
    }
}
