package com.app.demo.application;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import com.app.demo.utils.LogUtils;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-08-11 16:41
 */
public class DemoApplication extends Application {
    public static DemoApplication demo_application;

    public DemoApplication() {
        demo_application = this;
    }

    public static DemoApplication instance() {
        return demo_application;
    }

    @Override
    public void onCreate() {
        Log.e("DemoApplication>>>", "onCreate");
        //应用创建的时候调用
        super.onCreate();
        if ((getApplicationInfo().flags & 2) != 0) {

            // ApplicationInfo.FLAG_DEBUGGABLE
            LogUtils.LEVEL = Integer.MIN_VALUE;
        } else {
            LogUtils.LEVEL = Integer.MAX_VALUE;
        }
    }

    @Override
    public void onTerminate() {
        Log.e("DemoApplication>>>", "onTerminate");
        //应用终止的时候调用 但是不一定会被执行
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        Log.e("DemoApplication>>>", "onLowMemory");
        //低内存的时候调用
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Log.e("DemoApplication>>>", "onTrimMemory");
        //程序在内存清理的时候调用
        super.onTrimMemory(level);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("DemoApplication>>>", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    public void activityOncreat(Activity activity) {
        LogUtils.d("activityOncreat>>>");
    }

    public void activityOnstart(Activity activity) {
        LogUtils.d("activityOnstart>>>");
    }

    public void activityOnresum(Activity activity) {
        LogUtils.d("activityOnresum>>>");
    }

    public void activityOnpause(Activity activity) {
        LogUtils.d("activityOnpause>>>");
    }

    public void activityOnstop(Activity activity) {
        LogUtils.d("activityOnstop>>>");
    }

    public void activityOndestory(Activity activity) {
        LogUtils.d("activityOndestory>>>");
    }


}
