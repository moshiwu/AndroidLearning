package com.example.moqiaowen.mydemo7;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }

        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                LinearLayoutActivity.start(this);
                break;
            case R.id.button2:
                RelativeLayoutActivity.start(this);
                break;
            case R.id.button3:
                FrameLayoutActivity.start(this);
                break;
            case R.id.button4:
                PercentFrameLayoutActivity.start(this);
                break;
        }
    }
}
