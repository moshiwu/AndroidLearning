package com.msw.mydemo14;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Dictionary;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static {
        // Init okhttp.
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        TrustManager[] trustAllCerts = {new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;

            }

            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
                // Not implemented
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
                // Not implemented
            }
        }};

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            builder.sslSocketFactory(sc.getSocketFactory());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        HTTP_CLIENT = builder.build();
    }

    public static final OkHttpClient HTTP_CLIENT;

    private static final String TAG = "MainActivity";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.imageView);
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

            case R.id.button4:

                try {
                    String path = "https://cdn.sc.ruishanio.net/avatar/0y4dgyzDtfVuiwai0BDzeQaE4fX.jpg";
                    Request request = new Request.Builder()
                            .url(path)
                            .build();

                    Call call = HTTP_CLIENT.newCall(request);

                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d(TAG, "request failure: " + e.toString());

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            //得到从网上获取资源，转换成我们想要的类型

                            final byte[] picture_bytes = response.body().bytes();


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(TAG, "onResponse: " + picture_bytes.length);

                                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(picture_bytes, 0, picture_bytes.length);
                                    //通过imageview，设置图片
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
