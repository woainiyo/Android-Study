package com.example.wsc_test2;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView lv;
    TextView tv;
    int ctx_position = 0;//设置ContextMenu触发位置的变量为全局变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);
        for (int i = 0; i < 20; i++) {
            String s = String.format("Item%02d", i);
            list.add(s);
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lv = findViewById(R.id.listView);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);//对ListView视图注册ContextMenu
        tv = findViewById(R.id.tv_result);
        registerForContextMenu(tv);//xTextView视图注册ContextMenu
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == lv) {
            getMenuInflater().inflate(R.menu.ctx_menu, menu);
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo =
                    (AdapterView.AdapterContextMenuInfo) menuInfo;
            ctx_position = adapterContextMenuInfo.position;
        } else if (v == tv) {
            getMenuInflater().inflate(R.menu.ctx_tv_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = ctx_position;
        switch (item.getItemId()) {
            case R.id.ctx_insert:
                String s = String.format("Random:%d", new Random().nextInt(1000));
                list.add(position, s);
                adapter.notifyDataSetChanged();
                break;
            case R.id.ctx_delete:
                list.remove(position);
                adapter.notifyDataSetChanged();
            case R.id.ctx_tv_12:
                tv.setTextSize(12.0f);//设置文本字体大小
                break;
            case R.id.ctx_tv_16:
                tv.setTextSize(16.0f);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
