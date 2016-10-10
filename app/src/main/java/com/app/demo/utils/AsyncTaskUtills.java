package com.app.demo.utils;

import android.os.AsyncTask;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-30 13:49
 */
public class AsyncTaskUtills extends AsyncTask {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ToastUtils.toast("onPreExecute");
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        ToastUtils.toast(o + "onPostExecute");
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return HttpUtills.postMethod(params[0].toString());
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        ToastUtils.toast("onProgressUpdate");
    }

}
