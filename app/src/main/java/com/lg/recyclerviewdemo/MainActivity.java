package com.lg.recyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatas = new ArrayList<String>();
        for (int i = 1; i <= 65; i++) {
            mDatas.add("item"+i);
        }
    }

    public void Linear(View view) {
        startActivity(new Intent(this, LinearActivity.class));
    }

    public void Grid(View view) {
        startActivity(new Intent(this, GridActivity.class));
    }

    public void StaggeredGridH(View view) {
        startActivity(new Intent(this, StaggeredGridHActivity.class));
    }
    public void StaggeredGridV(View view) {
        startActivity(new Intent(this, StaggeredGridVActivity.class));
    }
}
