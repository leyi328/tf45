package com.hzyc.yy.demo_08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //如果使用组件  给其他的类传值 （只能使用构造方法 activity  传值给  adapter）
    //如果组件之间传值  （不能使用构造方法的  使用的是intent）
    private EditText toValue;
    private Button toTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toValue = (EditText) findViewById(R.id.toValue);
        toTwo = (Button) findViewById(R.id.toTwo);

        toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = toValue.getText().toString().trim();
                //1.直接使用意图 设计的时候（map  .put("key"，value)）
                //请求转发
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
               /* intent.putExtra("name",value);
                startActivity(intent);*/

                //2.javaBean (model 模型（开发的时候使用模型来开发 使用模型来传值）)
                //v 视图  C 控制   访问数据库操作也的类
                //公共的bean对象

                Bundle bundle = new Bundle();
                bundle.putString("name",value);
                bundle.putInt("age",23);
                bundle.putString("sex","男");
                intent.putExtras(bundle);
                //startActivity(intent);//不期待的结果的
                startActivityForResult(intent,0);//如果结果回来了会激活另外一个函数  ---1
                overridePendingTransition(R.anim.tip_right,R.anim.tip_left);
            }
        });

        SharedPreferences spf = getSharedPreferences("data",0);
        String name = spf.getString("name","nothing");
        if(!"nothing".equals(name)){
            toValue.setText(name);
        }
    }

    //------3
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == 200){
            Toast.makeText(MainActivity.this, ""+data.getStringExtra("back"), Toast.LENGTH_SHORT).show();
        }

    }

    //保护现场
    //开始杀死应用保护模式（保护上了 数据永不丢失  数据存储）
    //1.xml  2.io文档  3.数据库sqlite 4.web存储（数据传输入到web端  windows 存储到mysql中oracle）

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //判断 保护的值存在不存在
        String value = toValue.getText().toString().trim();
        if("".equals(value)){
            Toast.makeText(MainActivity.this, "不需要保护", Toast.LENGTH_SHORT).show();
        }else{
            //xml 存储在手机中（sdcard）
            //会在手机内存中检索有没有data文件没有新建 有获取
            SharedPreferences spf = getSharedPreferences("data",0);
            //存储  编辑
            SharedPreferences.Editor editor = spf.edit();
            editor.putString("name",value);
            boolean bol = editor.commit();
            Toast.makeText(MainActivity.this, "保护成功"+true, Toast.LENGTH_SHORT).show();
            //存储到哪了？ ROOT权限
        }
    }
}
