package com.example.moqiaowen.mydemo8.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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

public class StaggeredGridRecyclerViewActivity extends RecyclerViewActivity {
    public static void start(Context context) {
        context.startActivity(new Intent(context, StaggeredGridRecyclerViewActivity.class));
    }


    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        return layoutManager;
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.fruit_item_staggered_grid;
    }


    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected List<Fruit> initFruits() {
        List<Fruit> list = super.initFruits();


        for (int i = 0; i < list.size(); i++) {

            Fruit fruit = list.get(i);
            int randomCount = new Random().nextInt(20) + 1;


            List<String> unitList = new ArrayList<String>();

            for (int j = 0; j < randomCount; j++) {
                unitList.add(fruit.getName());
            }


            String result = StringUtils.join(unitList, "+");
            fruit.setName(result);

        }

        return list;
    }
}
