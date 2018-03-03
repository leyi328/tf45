package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);

        //gridView.setAdapter();
        //1.数据
        //2.写适配器 （得到数据 选择合适的控件   数据放到控件里  显示到gridView中）
        gridView.setAdapter(new MyAdapter());
    }

    //1.数据
    public List<Map<String,Object>> getList(){
        //虚拟数据
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=20; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",R.drawable.image1);
            map.put("name","应用" +i);
            list.add(map);
        }
        return list;
    }

    //studio 解决问题的通用快捷键  alt+回车
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return getList().size();
        }
        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //选择控件了
            //获取一个设计好的布局（适配器 效果咱们就可以控制了）
            //获取这个布局中的控件（位置已经设计好了）
            //list里面的数据装的控件中
            //View 代表所有控件的根类（表示所有的显示效果 （布局XML））
            //grid.xml == view
            View view; //xml文件
            //LayoutInflater 布局填充器 （获取指定的布局）
            //LayoutInflater.from(MainActivity.this).inflate()通过activity类获取一个外部的布局文件
            if(convertView == null){
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.grid,null);
            }else{
                view = convertView;
            }
            //取出xml中的控件
            // 直接这么写在这个activity默认的xml中找控件findViewById()
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.textView);

            imageView.setImageResource(Integer.parseInt(getList().get(position).get("image").toString()));
            textView.setText(getList().get(position).get("name").toString());

            return view;
        }
    }
}
