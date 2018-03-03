package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity /*implements View.OnClickListener*/{

    //三种事件使用模式
    //方法（View v） 当前触发这个方法的控件
    //1.使用内部类 事件给控件  setOnClickListener(); 监听器选择不同监听器 触发不同的事件
    //2.公共事件  （好多个控件公用一个事件方法） 节省代码量
    //3.公共事件（参考 了解） 实现接口 ClickListener （实现类  实现里面的抽象方法）

    private Button print;
    private CheckBox lq,zq,yy,js;
    private String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        print = (Button) findViewById(R.id.print);
        lq = (CheckBox) findViewById(R.id.lq);
        zq = (CheckBox) findViewById(R.id.zq);
        yy = (CheckBox) findViewById(R.id.yy);
        js = (CheckBox) findViewById(R.id.js);

     /*   //事件方法3
        lq.setOnClickListener(this);
        zq.setOnClickListener(this);*/

        /*lq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lq.isChecked()){

                    str += "篮球"; //内部类不使用局部变量的 == 触发局部变量变成局部常量
                }
            }
        });

        zq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zq.isChecked()){
                    str += "足球";
                }
            }
        });

        yy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        js.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        /*print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    //View 控件的根类
    //xml
    public void check(View view){

        //点是谁啊？？
        int id = view.getId();
        Log.i("标识",""+id);
        Log.i("标识",""+R.id.lq);

        switch (id){
            case R.id.lq:
                Toast.makeText(Main2Activity.this, "篮球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zq:
                Toast.makeText(Main2Activity.this, "足球", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yy:
                Toast.makeText(Main2Activity.this, "游泳", Toast.LENGTH_SHORT).show();
                break;
            case R.id.js:
                Toast.makeText(Main2Activity.this, "健身", Toast.LENGTH_SHORT).show();
                break;
        }
    }

  /*  @Override
    public void onClick(View v) {

    }*/
}
