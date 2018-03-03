package com.hzyc.yy.demo_02;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bitmap bitmap 图片的类型  位图
                //imageView.setImageBitmap(Bitmap);
                imageView.setImageResource(R.drawable.img2);
                
                //调试程序 （输出一些信息）
                //显示点信息 不是适合调试
               /* for(int i = 1; i<=10; i++) {
                    Toast.makeText(MainActivity.this, "输出文字"+i, Toast.LENGTH_SHORT).show();//排序输出
                }*/
                //日志猫  logcat
                //在logcat组件里显示
                //i info（普通信息）  d（debug 调试信息）  w（warn 警告信息） 不影响程序运行的
                //e（error 错误信息） 为什么重要？（程序不能运行）
                //tomcat 启动信息 控制台（打印信息的时候有级别的  信息的重要程度）
                //系统 蓝屏的时候（进入  1.进入安全模式  2.正常启动）
                for(int i = 1; i<=10; i++) {
                    Log.i("调试信息", "输出文字" + i);
                }
            }
        });
    }
}
