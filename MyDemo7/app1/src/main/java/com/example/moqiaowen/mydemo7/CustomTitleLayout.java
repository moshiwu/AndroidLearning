package com.example.moqiaowen.mydemo7;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by moqiaowen on 2017/11/1.
 */

public class CustomTitleLayout extends LinearLayout {
    private static final String TAG = "CustomTitleLayout";

    public CustomTitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_title_layout, this);


        findViewById(R.id.titleLayout_button_1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick button back");
            }
        });


        findViewById(R.id.titleLayout_button_2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick button edit");
            }
        });
    }
}
