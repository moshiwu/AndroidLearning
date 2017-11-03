package com.example.moqiaowen.mydemo8;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by moqiaowen on 2017/11/2.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final String TAG = "ViewHolder";

    public ImageView fruitImageView;
    public TextView fruitNameView;

    private IMyRecyclerViewItemOnClickListener mListener;

    public RecyclerViewHolder(View itemView, IMyRecyclerViewItemOnClickListener onClickHandler) {
        super(itemView);

        fruitImageView = (ImageView) itemView.findViewById(R.id.fruit_image);
        fruitNameView = (TextView) itemView.findViewById(R.id.fruit_name);
        mListener = onClickHandler;

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            Log.d(TAG, "onClick: " + getAdapterPosition() + " " + getLayoutPosition());
            mListener.onItemClick(v, getAdapterPosition());
        }
    }
}
