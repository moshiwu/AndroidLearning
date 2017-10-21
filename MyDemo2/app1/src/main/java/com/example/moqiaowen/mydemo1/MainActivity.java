package com.example.moqiaowen.mydemo1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click 1");

                startActivity(new Intent(MainActivity.this, AnotherActivity.class));
            }
        });

        findViewById(R.id.btn_main_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click 2");

                startActivity(new Intent(AnotherActivity.ACTION));
            }
        });

        findViewById(R.id.btn_main_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click 3");

                //输入其他App预设的字符串，即可打开特定页面，如果有冲突，会提示选择框
                startActivity(new Intent("com.example.app2.intent.action.MAIN"));
            }
        });

        findViewById(R.id.btn_main_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("click 4");

                //输入预设的字符串和schema来开启其他app的页面，减少冲突机会
                startActivity(new Intent("com.example.app2.intent.action.MAIN", Uri.parse("app_main2://")));
            }
        });


    }

}
