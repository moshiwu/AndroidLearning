package com.msw.mydemo14;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Dictionary;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.button1:
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
                break;

            case R.id.button2:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpClient client = new OkHttpClient();

                            URL url = new URL("https://ledong.fashioncomm.com/sport/api/login?account=msw1000@qq.com&password=111111"); //这个是不标准的GET请求

                            Request request = new Request.Builder().url(url).build();

                            //使用execute来开始请求，需要线程
                            Response response = client.newCall(request).execute();

                            Log.d(TAG, "run: " + response.body().string());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            case R.id.button3:

                try {
                    OkHttpClient client = new OkHttpClient();

                    URL url = new URL("https://ledong.fashioncomm.com/sport/api/device_bind");

                    FormBody requestBody = new FormBody.Builder()
                            .add("userId", "468681")
                            .add("watchId", "FCL28T17061206000727")
                            .add("watchType", "L28")
                            .add("isDefault", "1")
                            .add("watchTime", "2017-12-13")
                            .add("forceBind", "1")
                            .build();

                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();

                    //使用回调形式来开始请求
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d(TAG, "request failure: " + e.toString());

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String resultString = response.body().string();  //response.body().string()只能调用一次，因为OkHttp不会保存Response（也有可能是因为一次请求一次下载，下载完了需要重新请求）
                            Log.d(TAG, "request success: " + resultString);

                            Gson gson = new Gson();
                            BaseResponse baseResponse = gson.fromJson(resultString, BaseResponse.class);
                            Log.d(TAG, "onResponse: " + baseResponse.getData().toString());
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}
