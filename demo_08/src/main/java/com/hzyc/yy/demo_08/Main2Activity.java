package com.hzyc.yy.demo_08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    //
    private EditText getValue;
    private Button returnOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getValue = (EditText) findViewById(R.id.getValue);
        returnOne = (Button) findViewById(R.id.returnOne);

        //接值 （接一遍）
        final Intent intent = getIntent();
      /*  String value = intent.getStringExtra("name");
        getValue.setText(value);*/
        Bundle bundle = intent.getExtras();
        //String name = bundle.getString("name");
        String name = bundle.getString("name","nothing");
        if("nothing".equals(name)){

        }
      /*  if("".equals(null)){

        }
        if(null.equals("")){

        }*/
        int age = bundle.getInt("age");
        String sex = bundle.getString("sex");

        getValue.setText(name+"@@"+age+"@@"+sex);


        returnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String backValue = getValue.getText().toString();
                //反向意图
                Intent intent1 = new Intent(Main2Activity.this,MainActivity.class);
                intent1.putExtra("back",backValue);
                //404 not found 500 代码错误、
                //100-505之间 （200所有返回码 正常状态）
                //activity不退栈 还显示
                setResult(200,intent1);//-----2
                Main2Activity.this.finish();//关闭

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
