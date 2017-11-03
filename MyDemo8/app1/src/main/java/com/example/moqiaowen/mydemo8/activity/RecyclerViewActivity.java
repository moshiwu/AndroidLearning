package com.example.moqiaowen.mydemo8.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.view.View;

import com.example.moqiaowen.mydemo8.Fruit;
import com.example.moqiaowen.mydemo8.IMyRecyclerViewItemOnClickListener;
import com.example.moqiaowen.mydemo8.R;
import com.example.moqiaowen.mydemo8.ReclcyerViewFruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    protected List<Fruit> fruitList;

    public static void start(Context context) {
        context.startActivity(new Intent(context, RecyclerViewActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Log.d(TAG, "onCreate: RecyclerViewActivity");

        fruitList = initFruits();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view_1);

        recyclerView.setLayoutManager(getLayoutManager());

        ReclcyerViewFruitAdapter adapter = new ReclcyerViewFruitAdapter(fruitList, getItemLayoutId(), new IMyRecyclerViewItemOnClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d(TAG, "onItemClick: " + position);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    protected LayoutManager getLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        return layoutManager;
    }

    protected int getItemLayoutId() {
        return R.layout.fruit_item_vertical;
    }


    protected List<Fruit> initFruits() {
        List<Fruit> temp = new ArrayList<>();
        for (int i = 0; i < 999; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            temp.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            temp.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            temp.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            temp.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            temp.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            temp.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            temp.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            temp.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            temp.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            temp.add(mango);
        }

        return temp;
    }
}
