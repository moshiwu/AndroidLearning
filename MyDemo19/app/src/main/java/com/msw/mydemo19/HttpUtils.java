package com.msw.mydemo19;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by moqiaowen on 2018/1/9.
 */


public class HttpUtils {

    public static void sendRequest(String url, HttpUtilsCallBack callback) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                try {
                    callback.onResponse(call, null, e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(call, response, null);
            }
        });
    }
}
