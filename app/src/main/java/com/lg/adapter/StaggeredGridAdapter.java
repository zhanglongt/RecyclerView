package com.lg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import com.lg.dao.OnItemClickLitener;
import com.lg.recyclerviewdemo.MainActivity;
import com.lg.recyclerviewdemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2016/6/4.
 */
public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridHolder> {
    private View view;
    private List<Integer> heights;
    private LayoutInflater mInflater;
    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public StaggeredGridAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        heights = new ArrayList<Integer>();
        for (int i = 0; i < MainActivity.mDatas.size(); i++) {
            heights.add((int) (200 + Math.random() * 300));
        }
    }

    @Override
    public StaggeredGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //利用反射将item的布局加载出来
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_sg_item, null);
        //new一个我们的ViewHolder，findViewById操作都在LinearHolder的构造方法中进行了
        return new StaggeredGridHolder(view);
    }

    @Override
    public void onBindViewHolder(final StaggeredGridHolder holder, int position) {
        LayoutParams layoutParams = holder.sg_item.getLayoutParams();
        layoutParams.height = heights.get(position);
        holder.sg_item.setText(MainActivity.mDatas.get(position));
        holder.sg_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                mOnItemClickLitener.onItemClick(holder.itemView, pos);
                Log.i("ii","as:"+pos+"; ll:"+holder.sg_item.getText());
            }
        });
        holder.sg_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.mDatas.size();
    }
}

class StaggeredGridHolder extends RecyclerView.ViewHolder{
    TextView sg_item;

    public StaggeredGridHolder(final View itemView) {
        super(itemView);
        sg_item = (TextView) itemView.findViewById(R.id.sg_item);
    }
}

