package com.example.moqiaowen.mydemo8.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moqiaowen.mydemo8.Fruit;
import com.example.moqiaowen.mydemo8.FruitAdapter;
import com.example.moqiaowen.mydemo8.R;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {


    private List<Fruit> fruitList;

    public static void start(Context context) {
        context.startActivity(new Intent(context, CustomListViewActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);


        fruitList = initFruits();
        FruitAdapter adapter = new FruitAdapter(this, R.layout.fruit_item_vertical, fruitList);

        ListView listView = (ListView) findViewById(R.id.list_view_2);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);

                Toast.makeText(CustomListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private List<Fruit> initFruits() {
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
