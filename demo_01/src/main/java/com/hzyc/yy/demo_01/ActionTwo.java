package com.hzyc.yy.demo_01;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-12-14.
 */
public class ActionTwo  extends AppCompatActivity {


    private EditText username,password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);
        //初始化
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        //按钮事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取控件的值
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                if("admin".equals(name) && "admin".equals(psd)){
                    //context 四大组件的对象本身
                    //ActionTwo.this == context
                    Toast.makeText(ActionTwo.this,"登录成功!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ActionTwo.this,"登录失败!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
