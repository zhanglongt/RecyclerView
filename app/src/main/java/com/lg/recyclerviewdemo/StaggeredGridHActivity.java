package com.lg.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.lg.adapter.RecyclerAdapter;
import com.lg.divider.DividerGridItemDecoration;

public class StaggeredGridHActivity extends AppCompatActivity {
    private RecyclerView stag_grid_recycler;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_h);
        stag_grid_recycler = (RecyclerView) findViewById(R.id.stag_grid_recycler);
        recyclerAdapter=new RecyclerAdapter();
        stag_grid_recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
        stag_grid_recycler.setAdapter(recyclerAdapter);
        stag_grid_recycler.addItemDecoration(new DividerGridItemDecoration(this));
    }
}
