package com.hzyc.yy.demo_07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button toTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //生命周期 灵感人的生命周期
        //生命周期（生----死   婴儿  幼儿  儿童  少年  青年 20 30  中年 40 - 50   60 老年 靠药）
        //控制  完整或不完整
        //身体发肤 父母   不孝
        //吃的不好
        //重度 脂肪肝  肝脏负责排毒  脾
        //吃的太好 糖尿病  并发症

        Log.i("生命周期", "onCreate()");
        setContentView(R.layout.activity_main);
        toTwo = (Button) findViewById(R.id.toTwo);

        toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //触发意图
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期", "onStop()");
    }

    //正常结束才会执行
    //强行结束不会执行
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期", "onRestart()");
    }
}
