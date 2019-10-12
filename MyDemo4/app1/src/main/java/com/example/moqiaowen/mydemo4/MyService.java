package com.example.moqiaowen.mydemo4;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {
    private Boolean running = false;
    private String message = null;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {


        return new IMyAidlInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
                System.out.println("123321");
            }

            @Override
            public void sendMessage(String value) throws RemoteException {
                System.out.println("有人发了条信息：" + value);
            }

            @Override
            public void sharePhoto(String url) throws RemoteException {
                System.out.println("有人发了张图片：" + url);
            }
        };
    }


    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService create");


        //如果想要服务在前台运行，其实只需要创建一个通知，用startForeground启动就行
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("前台服务的标题")
                .setContentText("这是一个前台服务")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);


    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        System.out.println("MyService start");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);

        System.out.println("MyService start command");

        new Thread() {
            @Override
            public void run() {
                super.run();

                running = true;

                while (running) {

                    if (message == null) {
                        System.out.println("hello world : " + this.toString());
                    } else {
                        System.out.println("有人发了消息：" + message);
                    }
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();

        return result;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        running = false;

        System.out.println("MyService destory");
    }
}
