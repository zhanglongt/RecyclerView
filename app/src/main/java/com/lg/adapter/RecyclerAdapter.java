package com.lg.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lg.recyclerviewdemo.MainActivity;
import com.lg.recyclerviewdemo.R;

/**
 * Created by android on 2016/6/4.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<LinearHolder> {
    private View view;

    @Override
    public LinearHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //利用反射将item的布局加载出来
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, null);
        //new一个我们的ViewHolder，findViewById操作都在LinearHolder的构造方法中进行了
        return new LinearHolder(view);
    }

    @Override
    public void onBindViewHolder(LinearHolder holder, int position) {
        holder.recycler_item.setText(MainActivity.mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return MainActivity.mDatas.size();
    }
}

class LinearHolder extends RecyclerView.ViewHolder {
    TextView recycler_item;
    public LinearHolder(View itemView) {
        super(itemView);
        recycler_item = (TextView) itemView.findViewById(R.id.recycler_item_tv);
    }
}
