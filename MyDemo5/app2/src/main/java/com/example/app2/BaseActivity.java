package com.example.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by moqiaowen on 2017/11/8.
 */


public class BaseActivity extends AppCompatActivity {

    public static String ACTION_FORCED_OFFLINE = "com.example.app2.FORCE_OFFLINE";

    private ForceOffLineReceiver receiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_FORCED_OFFLINE);

        receiver = new ForceOffLineReceiver();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class ForceOffLineReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(final Context context, final Intent intent) {


            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Warning");
            builder.setMessage("You are forced to be offline, Please try to login again.");

            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();

                    Intent intent = new Intent(context, LoginActivity.class);
                    context.startActivity(intent);
                }
            });

            builder.show();
        }
    }
}
