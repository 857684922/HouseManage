package com.xun.housemanage.event;

import android.content.Context;
import android.widget.Toast;

import com.xun.housemanage.sql.UserDao;

/**
 * Created by Administrator on 2016/5/10.
 */
public class Login {
    private String username;
    private String password;
    private Context context;

    public Login(Context context, String username, String password) {
        this.username = username;
        this.password = password;
        this.context = context;
    }

    public boolean check() {
        //判断用户名是否存在
        if (new UserDao(context).queryUsername(username)) {
            //判断密码是否匹配
            if (new UserDao(context).queryPassword(username, password)) {
                return true;
            } else {
                Toast.makeText(context, "用户名密码错误", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(context, "用户名不存在", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
