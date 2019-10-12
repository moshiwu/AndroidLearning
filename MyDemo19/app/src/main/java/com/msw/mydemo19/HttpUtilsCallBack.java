package com.msw.mydemo19;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by moqiaowen on 2018/1/9.
 */

public interface HttpUtilsCallBack {
    void onResponse(Call call, Response response, Exception e) throws IOException;
}