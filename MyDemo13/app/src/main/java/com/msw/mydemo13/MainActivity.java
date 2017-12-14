package com.msw.mydemo13;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    protected MediaPlayer player = new MediaPlayer(); //如果要播放简单视频的话，使用VideoView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 9527);
        } else {
            initMediaPlayer();
        }

    }

    protected void initMediaPlayer() {
        try {

            Log.d(TAG, "initMediaPlayer: " + Environment.getDataDirectory());
            Log.d(TAG, "initMediaPlayer: " + Environment.getRootDirectory());
            Log.d(TAG, "initMediaPlayer: " + Environment.getDownloadCacheDirectory());
            Log.d(TAG, "initMediaPlayer: " + Environment.getExternalStorageDirectory());
            Log.d(TAG, "initMediaPlayer: " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "test_music.flac");
            Log.d(TAG, "initMediaPlayer: " + file.getPath());
            player.setDataSource(file.getPath());
            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 9527 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            initMediaPlayer();
        } else {
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                if (!player.isPlaying()) {
                    player.start();
                }
                break;
            case R.id.button2:
                if (player.isPlaying()) {
                    player.pause();
                }
                break;
            case R.id.button3:
                if (!player.isPlaying()) {
                    player.start();
                }

                break;
            case R.id.button4:

                if (player.isPlaying()) {
                    player.reset();
                    initMediaPlayer();
                }

                break;
            case R.id.button5:
                break;
        }
    }
}
