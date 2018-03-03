package com.hzyc.yy.demo_09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ActionMode actionMode;


    //实现内部类
    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.one,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            int id = item.getItemId();
            switch (id){
                case R.id.save:
                    Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.update:
                    Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.delete:
                    Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
            }

            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            //释放了
            actionMode = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(Main2Activity.this,R.layout.support_simple_spinner_dropdown_item,
                                                    new String[]{"数据1","数据2","数据3","数据4","数据5","数据6"});
        listView.setAdapter(arrayAdapter);
        //注册 actionModel
        //手动注册到长点击事件上
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(actionMode != null){
                    return false;
                }

                actionMode = Main2Activity.this.startActionMode(callback);//注册
                return true;
            }
        });

        //注册菜单
        //这种菜单通过 控件触发的
        //防止误操作（菜单默认注册到控件 长点击时间）
        //listView.setOnItemLongClickListener();
        //registerForContextMenu(listView);
    }

    //实现创建上下文菜单的方法
  /*  @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.one,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    //选择菜单的方法
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.save:
                Toast.makeText(Main2Activity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update:
                Toast.makeText(Main2Activity.this, "更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(Main2Activity.this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }*/
}
