package com.hzyc.yy.demo_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //这个方法如果实现了 右上角有菜单  不实现没有
    //在这个方法中找到我们自己菜单放到右上角
  /*  @Override
   */ public boolean onCreateOptionsMenu(Menu menu) {
        //获取菜单填充器
        MenuInflater menuInflater = getMenuInflater();
        //把自定义菜单放到右上角
        menuInflater.inflate(R.menu.one,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //实现菜单选择的方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //可以在选择菜单的时候自动触发
        //item (区分点的是谁)
        int id = item.getItemId();
        switch (id){
            case R.id.save:
                Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(MainActivity.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
