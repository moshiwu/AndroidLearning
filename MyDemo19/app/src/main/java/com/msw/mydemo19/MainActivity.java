package com.msw.mydemo19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.msw.mydemo19.cityModel.City;
import com.msw.mydemo19.cityModel.Province;
import com.msw.mydemo19.weatherModel.HeWeather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.LitePal;

import java.io.Console;
import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LitePal.initialize(this);


//        new Thread(() -> {
//            OkHttpClient client = new OkHttpClient();
//
//
//            Request request = new Request.Builder().url("http://guolin.tech/api/weather?cityid=CN101280101&key=bc0418b57b2d4918819d3974ac1285d9").build();
//
//            try {
//                Response response = client.newCall(request).execute();
//
////                Log.d(TAG, "onCreate: " + response.body().string());
//
//                Gson gson = new Gson();
//
//                String resultString = response.body().string();
//
//                JSONObject jsonObject = new JSONObject(resultString);
//
////                Log.d(TAG, "onCreate: " + jsonObject.getString("HeWeather"));
//                HeWeather[] weathers = gson.fromJson(jsonObject.getString("HeWeather"), HeWeather[].class);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();


        final Gson gson = new Gson();


        new Thread(() -> {
            HttpUtils.sendRequest("http://guolin.tech/api/china", (call, response, e) -> {
                if (e != null) {
                    Log.d(TAG, "get province list fail");
                } else {

                    String result = response.body().string();
                    Province[] provinces = gson.fromJson(result, Province[].class);
//                    Log.d(TAG, "count : " + provinces.length);
                    for (Province p : provinces) {
                        Log.d(TAG, "province : " + p.getProvinceName() + " id : " + p.getId());

                        p.save();

                        HttpUtils.sendRequest("http://guolin.tech/api/china/" + p.getId(), (call1, response1, e1) -> {
                            if (e1 != null) {
                                Log.d(TAG, "onFailure: get city fail");
                            } else {
                                City[] cities = gson.fromJson(response.body().string(), City[].class);
                                for (City city : cities) {
                                    city.setProvinceCode(p.getId());
                                    Log.d(TAG, "city -- id : " + city.getId() + " name : " + city.getCityName() + " province : " + city.getProvinceCode());
                                    city.save();
                                }
                            }
                        });
                    }
                }
            });

        }).start();
    }

    private static final String TAG = "MainActivity";
}
