package com.hzyc.yy.demo_012;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button createDataBase,updateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDataBase = (Button) findViewById(R.id.createDataBase);
        updateData = (Button) findViewById(R.id.updateData);

        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate mc = new MyDbCreate(MainActivity.this);
                //激活库 获取操作对象
                SQLiteDatabase sqLiteDatabase = mc.getReadableDatabase();


                //dml 增删改
            /*    sqLiteDatabase.execSQL("静态语句");
                sqLiteDatabase.execSQL("预处理sql语句 ?",new Object[]{"a"});*/

                //查询
              /*  Cursor cursor = sqLiteDatabase.rawQuery("静态语句",new String[]{});

                while(cursor.moveToNext()){
                    int  id = cursor.getInt(cursor.getColumnIndex("name"));
                }*/
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbCreate mc = new MyDbCreate(MainActivity.this);
                //激活库 获取操作对象
                SQLiteDatabase sqLiteDatabase = mc.getReadableDatabase();

                //sqlite （非SQL模式 orm模式 （不需要写SQL语句的也可以操作数据库））

                //一行数据
              /*  ContentValues contentValues = new ContentValues();
                contentValues.put("name","李四");
                contentValues.put("age",24);

                //i是我们添加成功之后 那行数据的ID
                //返回一个ID  用long  int 1 2  3  4  5  6
                long  i = sqLiteDatabase.insert("person",null,contentValues);
                Log.i("数据库信息","@@@@"+i);*/

              /*  ContentValues contentValues = new ContentValues();
                contentValues.put("name","王五");
                contentValues.put("age",30);
                long i = sqLiteDatabase.update("person",contentValues,"where id = ?",new String[]{"1"});*/
              /*  long i =  sqLiteDatabase.delete("person","where id = ?",new String[]{"1"});*/


                //Cursor cursor  = sqLiteDatabase.query(true,"person",new String[]{"name","age"}," name = ?",new String []{"张三"},"name",null,"id desc","0,3");
                Cursor cursor  = sqLiteDatabase.query("person",new String[]{"name","age"},null,null,null,null,null,null);
                while(cursor.moveToNext()){
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    int age = cursor.getInt(cursor.getColumnIndex("age"));
                    Log.i("数据库信息",name + "@@@@"+ age);
                }
            }
        });
    }
}
