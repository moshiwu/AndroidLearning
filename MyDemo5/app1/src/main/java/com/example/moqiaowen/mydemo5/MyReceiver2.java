package com.example.moqiaowen.mydemo5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver2 extends BroadcastReceiver {

    public static String ACTION = "com.example.moqiaowen.mydemo5.intent.action.MyReceiver";

    public MyReceiver2() {
        System.out.println("MyReceiver2 init");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("MyReceiver2 receive message");


        Boolean isOrdered = intent.getBooleanExtra("isOrdered", false);

        if (isOrdered) {
            System.out.println("MyReceiver2 取消后续广播");
            abortBroadcast();
        }
    }
}
