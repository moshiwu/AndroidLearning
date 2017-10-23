package com.example.moqiaowen.mydemo4.app2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.moqiaowen.mydemo4.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Intent serviceIntent = null;
    private IMyAidlInterface binder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //安卓5.0开始，需要调用外部的Service必须使用显式的Intent，具体来说就是指明包名、类名
        serviceIntent = new Intent();
        serviceIntent.setComponent(new ComponentName("com.example.moqiaowen.mydemo4", "com.example.moqiaowen.mydemo4.MyService"));

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                startService(serviceIntent);
                break;
            case R.id.button2:
                stopService(serviceIntent);
                break;
            case R.id.button3:
                bindService(serviceIntent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.button4:
                unbindService(this);
                break;
            case R.id.button5:

                if (binder != null) {
                    EditText et = (EditText) findViewById(R.id.editText);
                    try {
                        binder.sendMessage(et.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }


    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

//        不能用这种方式来强转成IMyAidlInterface
//        因为service实际上是另一个app中的对象，跟这个app的IMyAidlInterface并不是同一个类（虽然包名、类名、定义都一样）
//        binder = (IMyAidlInterface) service;

        binder = IMyAidlInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
