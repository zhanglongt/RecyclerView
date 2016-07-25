package com.lg.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.lg.adapter.RecyclerAdapter;
import com.lg.divider.DividerLinearItemDecoration;

public class LinearActivity extends AppCompatActivity {
    private RecyclerView linear_recycler;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        linear_recycler = (RecyclerView) findViewById(R.id.linear_recycler);
        recyclerAdapter = new RecyclerAdapter();
        //设置布局管理器
        linear_recycler.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        linear_recycler.setAdapter(recyclerAdapter);
        //添加分割线
        linear_recycler.addItemDecoration(new DividerLinearItemDecoration(this, DividerLinearItemDecoration.VERTICAL_LIST));
    }
}
