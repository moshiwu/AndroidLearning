package com.msw.mydemo16;

/**
 * Created by moqiaowen on 2017/12/21.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
