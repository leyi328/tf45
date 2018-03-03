package com.hzyc.yy.demo_04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;//棋盘
    private int[] data = { R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1, R.drawable.image1,R.drawable.image1,R.drawable.image1,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        //具体怎么放东西
        //使用适配器
        //gridView 布局使用是适配器 调用getView方法把得到控件放入到 网格布局中
        gridView.setAdapter(new MyAdapter());
        //添加事件
        //每一个view支持的事件类型都是不一样
      /*  gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });*/

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //组件跳转
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                //跳转
                startActivity(intent);
            }
        });
    }

    //1.有数据啊（棋子）  自己虚拟 创造  (数据创造好了) data

    //2.有适配器

    //写成内部类
    class  MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        //1.时匹器  第一个方法getCount（） 里面返回的总数是多少
        //getView方法就会调用多少遍
        //2. 1.得到数据   2.选择合适的控件  3.把数据放入到控件中 4.返回这个控件
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //选择图片控件
            ImageView imageView;
            if(convertView == null){
                //适配getView方法第一次执行
                imageView = new ImageView(MainActivity.this);
                imageView.setPadding(8,8,8,8);
            }else {
                //适配getView方法 >第一次执行
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(data[position]);
            return imageView;
        }
    }
}
