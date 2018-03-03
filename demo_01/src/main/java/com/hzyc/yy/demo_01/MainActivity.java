package com.hzyc.yy.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载对应的静态界面

        /*textView = (TextView) findViewById(R.id.textView);//得到xml中的控件

        //android所有的控件 根类都是view
        //View表示所有的控件

        //得到帮助 大小写需要匹配
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


       // R.id.textView
        //R.drawable.image1 //图片的地址
    }
}
