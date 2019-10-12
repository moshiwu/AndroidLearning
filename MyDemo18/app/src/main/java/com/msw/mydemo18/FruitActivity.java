package com.msw.mydemo18;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {

    private static final String TAG = "FruitActivity";
    private TextView textView;
    private ImageView imageView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);


        Intent intent = getIntent();
        Fruit fruit = (Fruit) intent.getSerializableExtra("obj");

        Log.d(TAG, "onCreate: " + fruit.getName());
        Log.d(TAG, "onCreate: " + fruit.getImageId());


        textView = (TextView) findViewById(R.id.fruit_content_text);
        imageView = (ImageView) findViewById(R.id.fruit_activity_image_view);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //设置标题
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.whiteColor, null));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.whiteColor, null));

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(fruit.getImageId()).into(imageView);
        textView.setText(this.generateFruitContent(fruit.getName()));
    }


    private String generateFruitContent(String fruitName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);


    }
}
