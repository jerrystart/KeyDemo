package com.app.demo.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.app.demo.application.DemoApplication;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-08-29 23:03
 */
public class ToastUtils {

    public static void toast(String msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    public static void toast(String msg, int time) {
        if (TextUtils.isEmpty(msg)) {
            msg = "Toast is empty";
        }
        Toast.makeText(DemoApplication.instance(), msg, time).show();
    }
}
