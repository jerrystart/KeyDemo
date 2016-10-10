package com.app.demo.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.app.demo.net.RequestCallback;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-30 15:31
 */
public class HttpRequest {
    public void request(Context context, IOEntity ioEntity, RequestCallback requestCallback) {
        if (ioEntity == null) {
            ToastUtils.toast("请传入请求参数");
            return;
        }
        if (NetWorksUtil.networkCanUse(context)) {
            requestCallback.netWork();
            return;
        }
        new RequestTask().execute(ioEntity, requestCallback);
    }

    private class RequestTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            IOEntity ioEntity = (IOEntity) params[0];
            RequestCallback requestCallback = (RequestCallback) params[1];
            
            return null;
        }
    }
}
