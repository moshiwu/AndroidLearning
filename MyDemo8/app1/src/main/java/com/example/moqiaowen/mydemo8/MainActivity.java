package com.example.moqiaowen.mydemo8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.moqiaowen.mydemo8.activity.CustomListViewActivity;
import com.example.moqiaowen.mydemo8.activity.GridRecyclerViewActivity;
import com.example.moqiaowen.mydemo8.activity.HorizontalRecyclerViewActivity;
import com.example.moqiaowen.mydemo8.activity.RecyclerViewActivity;
import com.example.moqiaowen.mydemo8.activity.SimpleListViewActivity;
import com.example.moqiaowen.mydemo8.activity.StaggeredGridRecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                SimpleListViewActivity.start(this);
                break;
            case R.id.button2:
                CustomListViewActivity.start(this);
                break;
            case R.id.button3:
                RecyclerViewActivity.start(this);
                break;
            case R.id.button4:
                HorizontalRecyclerViewActivity.start(this);
                break;
            case R.id.button5:
                StaggeredGridRecyclerViewActivity.start(this);
                break;
            case R.id.button6:
                GridRecyclerViewActivity.start(this);
                break;
        }
    }
}
