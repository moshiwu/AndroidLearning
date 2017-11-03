package com.example.moqiaowen.mydemo8.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.moqiaowen.mydemo8.Fruit;
import com.example.moqiaowen.mydemo8.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by moqiaowen on 2017/11/3.
 */

public class GridRecyclerViewActivity extends RecyclerViewActivity {
    public static void start(Context context) {
        context.startActivity(new Intent(context, GridRecyclerViewActivity.class));
    }


    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {

        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);

        return layoutManager;
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.fruit_item_grid;
    }
}
