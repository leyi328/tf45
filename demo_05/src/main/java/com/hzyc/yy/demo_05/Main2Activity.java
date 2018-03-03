package com.hzyc.yy.demo_05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    //学很多都是效果 （写代码实现）
    //android写代码并不费劲（三次开发   一次开发（研发  Java（开发团队））  学习Java（二次开发 基于Java的源代码进行开发）  三次开发（谷歌Java封住处理 android使用））
    //移动端开发（移动端程序比较简单 （web程序） 功能复杂度上来说 移动<web  功能完整  移动<<<<<web）
    //移动端设备（电脑游戏 手游（电脑游戏的简化版））  手机（内存小 没有硬盘） （屏幕小） （散热 电池寿命））
    //电脑  第一等电脑（服务器） 第二等电脑（PC  家用台式机哦） 第三等（pc 笔记本）
    //10年前 太大了 （缩小的趋势）  2年前 （硬件放大） 机箱 中塔式
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Main2Activity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<Map<String,Object>> getList(){
        //虚拟数据
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=20; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("name","商品" +i);
            map.put("price",12.2+i);
            map.put("bz","小米手机");
            map.put("rating",i%5);
            list.add(map);
        }
        return list;
    }

    class MyAdapter extends BaseAdapter {

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
                view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.image_text,null);
            }else{
                view = convertView;
            }
            //取出xml中的控件
            // 直接这么写在这个activity默认的xml中找控件findViewById()
            ImageView photo = (ImageView) view.findViewById(R.id.photo);
            TextView name = (TextView) view.findViewById(R.id.name);
            TextView price = (TextView) view.findViewById(R.id.price);
            TextView bz = (TextView) view.findViewById(R.id.bz);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

            photo.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            name.setText(getList().get(position).get("name").toString());
            price.setText(getList().get(position).get("price").toString());
            bz.setText(getList().get(position).get("bz").toString());
            ratingBar.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));

            return view;
        }
    }
}
