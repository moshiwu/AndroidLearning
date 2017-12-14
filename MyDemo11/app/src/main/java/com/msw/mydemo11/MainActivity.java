package com.msw.mydemo11;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = null;
        switch (v.getId()) {

            // 最普通的通知
            case R.id.button1:

                Intent intent = new Intent(this, NotificationResultActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is title")
                        .setContentText("This is text")
                        .setWhen(System.currentTimeMillis() + 3000)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setContentIntent(pendingIntent)  //设置点击后响应的操作
                        .setAutoCancel(true) //点击后是否自动删除通知
                        .setLights(Color.GREEN, 1000, 1000)  //闪光灯，绿色、闪1秒、停1秒
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg"))) //通知的声音
                        .setVibrate(new long[]{0, 1000, 1000, 1000}) //通知的震动，停0秒、震1秒、停1秒、再震1秒
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)  //如果上面3个都只要默认值，则传DEFAULT_ALL即可
                        .setPriority(NotificationCompat.PRIORITY_MAX)  //设置优先级，如果设置成MAX的话，会立即弹出通知
                        .build();
                break;

            case R.id.button2:

                String longText = "这是一段很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的文字";


                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is title 2")
//                        .setContentText(longText)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(longText))
                        .setWhen(System.currentTimeMillis() + 3000)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();

                break;

            case R.id.button3:

                notification = new NotificationCompat.Builder(this)
                        .setContentTitle("This is title 3")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.pic1)))
                        .setWhen(System.currentTimeMillis() + 3000)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .build();

                break;

        }

        manager.notify(1, notification);
        Log.d(TAG, "onCreate: " + notification.toString());
    }


}
