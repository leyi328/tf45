package com.hzyc.yy.demo_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class KongJianActivity extends AppCompatActivity {

   /* private Switch aSwitch;
    //下拉框
    private Spinner spinner;
    //是baseAdapter子类
    private ArrayAdapter<String> aa;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dateone);
       /* aSwitch = (Switch) findViewById(R.id.switch1);
        spinner = (Spinner) findViewById(R.id.spinner);

        aa = new ArrayAdapter<String>(KongJianActivity.this,R.layout.support_simple_spinner_dropdown_item,new String[]{"长春市","吉林市","四平市"});
        //放适配器的
        spinner.setAdapter(aa);
        //适合什么事件  百度  文档
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object object = spinner.getSelectedItem();
                Toast.makeText(KongJianActivity.this, ""+object.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(KongJianActivity.this, ""+isChecked, Toast.LENGTH_SHORT).show();

                if(isChecked){

                }
            }
        });*/
    }
}
