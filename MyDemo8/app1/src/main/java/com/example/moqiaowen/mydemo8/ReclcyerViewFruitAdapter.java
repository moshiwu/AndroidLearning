package com.example.moqiaowen.mydemo8;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by moqiaowen on 2017/11/2.
 */

public class ReclcyerViewFruitAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {


    private List<Fruit> mFruitList;
    private IMyRecyclerViewItemOnClickListener mClickHandler;
    private int mLayoutId;

    public ReclcyerViewFruitAdapter(List<Fruit> fruitList, int layoutId, IMyRecyclerViewItemOnClickListener clickHandler) {
        mFruitList = fruitList;
        mClickHandler = clickHandler;
        mLayoutId = layoutId;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view, mClickHandler);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);

        holder.fruitImageView.setImageResource(fruit.getImageId());
        holder.fruitNameView.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


}
