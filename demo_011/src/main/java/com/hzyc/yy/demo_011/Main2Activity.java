package com.hzyc.yy.demo_011;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button createDataBase,upDataBase,editor,call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        createDataBase = (Button) findViewById(R.id.createDataBase);
        upDataBase = (Button) findViewById(R.id.upDataBase);
        editor = (Button) findViewById(R.id.editor);
        call = (Button) findViewById(R.id.call);

        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);//数据库建库工具类对象
                //激活数据库（会调用onCreate方法 只调用一次  一个版号的范围内 只能激活一次）
                //data/data/应用包/database/ db拿出来之后无法正常查看 （数据库文件）
                //GUI sqlite 图形化界面（GUI）

                //激活数据库  如果20480空间全部装满了  允许你继续能查询数据库 （不能更新）
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                //sql模式  sql语句
                //sqLiteDatabase.execSQL("insert into person (name) values ('张三')");
                //sqLiteDatabase.execSQL("insert into person (name) values (?)",new Object[]{"李四"});

                //如果20480空间全部装满了  就不能在使用数据库了
                //SQLiteDatabase sqLiteDatabase = myDbCreate.getWritableDatabase();
            }
        });

        upDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //更新数据库 修改版本号 变了 数据库更新了
                //触发一次onUpgrade
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                sqLiteDatabase.execSQL("update person set age = 23 where id = 1");
                sqLiteDatabase.execSQL("update person set age = 23 where id = 2");
            }
        });


        editor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate myDbCreate = new MyDbCreate(Main2Activity.this);
                SQLiteDatabase sqLiteDatabase = myDbCreate.getReadableDatabase();

                //增删改
                //select不好使的
                //sqLiteDatabase.execSQL("insert delete update   ? = 12");
               /* sqLiteDatabase.execSQL("insert into person (name,age) values ('王五',20)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('小明',21)");
                sqLiteDatabase.execSQL("insert into person (name,age) values ('小强',22)");*/

                //查询
                //cursor 取出一列的值  向下滚动一行一行滚动
                Cursor cursor = sqLiteDatabase.rawQuery("select * from person",null);
                //Cursor cursor = sqLiteDatabase.rawQuery("select * from person where name = ?",new String[]{"张三"});
                //cursor 转换成list表  map装行  map.put("列名","列值")
                //cursor.g


                while(cursor.moveToNext()){
                   /* String name = cursor.getString(1);
                    String age = cursor.getString(2);*/
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    String age = cursor.getString(cursor.getColumnIndex("age"));
                    Log.i("数据库信息",name+"@@"+age);
                }
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
                if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
