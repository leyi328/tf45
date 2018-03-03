package com.hzyc.yy.demo_010;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-12-28.
 */
//APP 有10个页面都需要这个图文混排的效果
    //传递参数（传递参数特别简单（android == rcp 一旦启动运行 生命周期是一个整体））
    //只要参数与运行的页面或者一些类（之间直接使用构造方法就可以传递参数）
    //BaseAdapter 所有适配器类的根类
public class MyAdapter extends BaseAdapter {

    private List<Map<String,Object>> list;
    private Context context;

    public MyAdapter(List<Map<String,Object>> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            //view = LayoutInflater.from(context).inflate(R,null);
            view = convertView;
        }else{
            view = convertView;
        }
        //取出xml中的控件
        // 直接这么写在这个activity默认的xml中找控件findViewById()
       /* ImageView photo = (ImageView) view.findViewById(R.id.photo);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView price = (TextView) view.findViewById(R.id.price);
        TextView bz = (TextView) view.findViewById(R.id.bz);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);*/

      /*  photo.setImageResource(Integer.parseInt(list.get(position).get("photo").toString()));
        name.setText(list.get(position).get("name").toString());
        price.setText(list.get(position).get("price").toString());
        bz.setText(list.get(position).get("bz").toString());
        ratingBar.setRating(Float.parseFloat(list.get(position).get("rating").toString()));*/

        return view;
    }
}
