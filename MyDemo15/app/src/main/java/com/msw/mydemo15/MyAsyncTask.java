package com.msw.mydemo15;

import android.os.AsyncTask;

/**
 * Created by moqiaowen on 2017/12/21.
 */

public class MyAsyncTask extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
