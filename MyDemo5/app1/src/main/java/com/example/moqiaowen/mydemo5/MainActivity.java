package com.example.moqiaowen.mydemo5;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyReceiver4 receiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        System.out.println("click " + button.getText().toString());


        //方式一：指定类名的（显示广播）
//        Intent intent = new Intent(this, MyReceiver1.class);

//        Intent intent = new Intent();
//        intent.setClassName("com.example.moqiaowen.mydemo5", "com.example.moqiaowen.mydemo5.MyReceiver1");

        //方式二：指定intent-filter（隐式广播，在android 8.0无效）
        //http://blog.csdn.net/chenshengfa/article/details/71407704
        Intent intent = new Intent();
        intent.setAction(MyReceiver1.ACTION);


        switch (v.getId()) {

            case R.id.button1:
                intent.putExtra("isOrdered", false);
                sendBroadcast(intent);
                break;

            case R.id.button2:
                intent.putExtra("isOrdered", true);
                sendOrderedBroadcast(intent, null);
                break;

            case R.id.button3:
                if (receiver == null) {
                    receiver = new MyReceiver4();

                    //动态注册需要用到IntentFilter
                    IntentFilter intentFilter = new IntentFilter(MyReceiver4.ACTION);
                    registerReceiver(receiver, intentFilter);
                }
                break;

            case R.id.button4:
                if (receiver != null) {
                    unregisterReceiver(receiver);
                    receiver = null;
                }
                break;

        }
    }
}
