package com.example.moqiaowen.mydemo7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class RelativeLayoutActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, RelativeLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
    }

}
