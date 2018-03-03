package com.hzyc.yy.demo_011;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //数据存储
    //做界面 任何元素
    //数据没法存储
    private Button save,read;
    private EditText username,password;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        save = (Button) findViewById(R.id.save);
        read = (Button) findViewById(R.id.read);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        //xml存储 == table一样的  有行有列的  数据压缩 （table 压缩到xml这里）
        //数据传输性  描述性  可扩展的标记语言
/*

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();

                //创建XML文件（存储在app应用的内部的）
                //创建data.xml文件
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                //得到文件的编辑权限
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("psd",psd);
                boolean bol =  editor.commit();

                //editor
                //editor.remove()删除
                //覆盖修改
                //存储在虚拟机中  （默认拥有root权限） data/data/app应用包名/shared_prefer
                Toast.makeText(MainActivity.this, "保存"+bol, Toast.LENGTH_SHORT).show();
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第二次在运行获取文件
                SharedPreferences sharedPreferences = getSharedPreferences("data",0);
                //只查询不更新 不需要editor
                String name = sharedPreferences.getString("name","nothingName");
                String psd = sharedPreferences.getString("psd","nothingPsd");

                Toast.makeText(MainActivity.this, "名称="+name+"@@密码="+psd, Toast.LENGTH_SHORT).show();
            }
        });
*/

        //I/O 文件存储  txt  手机的内存中/sdcard中
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream out = null;//字节流  字符流
                boolean bol = false;
                try {
                    //由Java的输出流作为条件创建一个data.txt文档
                    String name = username.getText().toString().trim();
                    String psd = password.getText().toString().trim();

                    out = openFileOutput("data.txt",0);
                    String value = name+"@@"+psd;
                    out.write(value.getBytes());  bol = true;


                    out.close();
                    Toast.makeText(MainActivity.this, "保存"+bol, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //获取文件中的数据  inputStraem
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FileInputStream input = null;
                //写的时候难点  （读取出来的是字符串 = byte   byte转换成字符串）
                //获取手机内存中的文件
                try {
                    input = openFileInput("data.txt");
                    byte [] data = new byte[1024];

                    //FileOutputStream
                    //ByteArrayOutputStream 写入了所有的数据可以把这些数据变成字符串
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    int len = 0;
                    while((len = input.read(data)) != -1){
                        out.write(data,0,len);
                    }
                    //转换成字符串
                    String str = out.toString();
                    String [] str1 = str.split("@@");

                    Toast.makeText(MainActivity.this, str1[0], Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, str1[1], Toast.LENGTH_SHORT).show();
                    input.close();
                    out.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
