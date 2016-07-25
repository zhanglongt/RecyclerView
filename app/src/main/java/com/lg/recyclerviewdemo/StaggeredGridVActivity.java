package com.lg.recyclerviewdemo;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;
import com.lg.adapter.StaggeredGridAdapter;
import com.lg.dao.OnItemClickLitener;
import java.util.Collections;

public class StaggeredGridVActivity extends AppCompatActivity {
    private RecyclerView stag_v_recycler;
    StaggeredGridAdapter staggeredGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_v);
        stag_v_recycler = (RecyclerView) findViewById(R.id.stag_v_recycler);
        staggeredGridAdapter = new StaggeredGridAdapter(this);
        stag_v_recycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        stag_v_recycler.setAdapter(staggeredGridAdapter);
        staggeredGridAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                staggeredGridAdapter.notifyItemRemoved(position);
            }

            @Override
            public void onItemLongClick(View view, final int position) {
//                android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(StaggeredGridVActivity.this);
//                builder.setTitle("Delete?")
//                        .setNegativeButton("no", null)
//                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                staggeredGridAdapter.notifyItemRemoved(position);
//                                Toast.makeText(StaggeredGridVActivity.this,MainActivity.mDatas.get(position),Toast.LENGTH_SHORT).show();
//                            }
//                        }).show();
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(stag_v_recycler);
    }

    ItemTouchHelper.Callback callback = new ItemTouchHelper.Callback() {

        /**这个方法是用来设置我们拖动的方向以及侧滑的方向的*/
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            //设置拖拽方向为上下左右
            final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
            //设置侧滑方向为从左到右和从右到左都可以
            final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            //将方向参数设置进去
            return makeMovementFlags(dragFlags, swipeFlags);
        }

        /**
         * @param recyclerView
         * @param viewHolder 拖动的ViewHolder
         * @param target 目标位置的ViewHolder
         * @return
         */
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
            int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
            if (fromPosition < toPosition) {
                //分别把中间所有的item的位置重新交换
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(MainActivity.mDatas, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(MainActivity.mDatas, i, i - 1);
                }
            }
            staggeredGridAdapter.notifyItemMoved(fromPosition, toPosition);
            //返回true表示执行拖动
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            staggeredGridAdapter.notifyItemRemoved(position);
        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                //滑动时改变Item的透明度
                final float alpha = 1 - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                viewHolder.itemView.setAlpha(alpha);
                viewHolder.itemView.setTranslationX(dX);
            }
        }

    };
}
