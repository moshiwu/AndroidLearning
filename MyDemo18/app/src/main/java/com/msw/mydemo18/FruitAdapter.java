package com.msw.mydemo18;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by moqiaowen on 2018/1/4.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {


    private Context mContext;
    private List<Fruit> mList;

    public FruitAdapter(List<Fruit> fruitList) {

        mList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mContext == null) {
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);

        final ViewHolder holder = new ViewHolder(view);

        holder.cardView.setOnClickListener(v -> {
            int position = holder.getAdapterPosition();
            Fruit fruit = mList.get(position);

            Intent intent = new Intent(mContext, FruitActivity.class);
            intent.putExtra("obj", fruit);
            mContext.startActivity(intent);
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mList.get(position);
        holder.textView.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.fruit_image);
            textView = itemView.findViewById(R.id.fruit_name);
        }
    }
}
