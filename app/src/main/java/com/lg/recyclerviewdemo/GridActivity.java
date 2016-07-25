package com.lg.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lg.adapter.RecyclerAdapter;
import com.lg.divider.DividerGridItemDecoration;

public class GridActivity extends AppCompatActivity {
    private RecyclerView grid_recycler;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        grid_recycler = (RecyclerView) findViewById(R.id.grid_recycler);
        recyclerAdapter=new RecyclerAdapter();
        grid_recycler.setLayoutManager(new GridLayoutManager(this,2));
        grid_recycler.setAdapter(recyclerAdapter);
        grid_recycler.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
