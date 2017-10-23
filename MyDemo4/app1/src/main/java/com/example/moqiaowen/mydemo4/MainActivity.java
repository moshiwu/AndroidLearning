package com.example.moqiaowen.mydemo4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("on create");
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, MyService.class);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        System.out.println("on click : " + v.getId());
        switch (v.getId()) {
            case R.id.button1:
                startService(intent);  // 所有Context的子类都有处理Service的方法
                break;
            case R.id.button2:
                stopService(intent);
                break;
            case R.id.button3:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                unbindService(this);
                break;
        }
    }



    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        System.out.println("on service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("on service disconnect");
    }
}
