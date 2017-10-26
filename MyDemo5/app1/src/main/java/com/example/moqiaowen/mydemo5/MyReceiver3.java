package com.example.moqiaowen.mydemo5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver3 extends BroadcastReceiver {

    public static String ACTION = "com.example.moqiaowen.mydemo5.intent.action.MyReceiver";

    public MyReceiver3() {
        System.out.println("MyReceiver3 init");
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("MyReceiver3 receive message");


        Boolean isOrdered = intent.getBooleanExtra("isOrdered", false);

        if (isOrdered) {
            System.out.println("MyReceiver3 取消后续广播");
            abortBroadcast();
        }
    }
}
