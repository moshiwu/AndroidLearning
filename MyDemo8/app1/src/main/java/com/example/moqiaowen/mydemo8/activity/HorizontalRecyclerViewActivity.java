package com.example.moqiaowen.mydemo8.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;

import com.example.moqiaowen.mydemo8.R;

/**
 * Created by moqiaowen on 2017/11/2.
 */

public class HorizontalRecyclerViewActivity extends RecyclerViewActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, HorizontalRecyclerViewActivity.class));
    }

    @Override
    protected LayoutManager getLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        return layoutManager;
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.fruit_item_horizontal;
    }
}
