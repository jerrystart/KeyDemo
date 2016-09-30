package com.app.demo.utils;

import android.content.Context;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-18 13:15
 */
public class CrashReportHelper {
    public static final String TAG = CrashReportHelper.class.getName();
    private static CrashReportHelper crashReportHelper;
    private static Context mcontext;

    private CrashReportHelper() {

    }

    public static CrashReportHelper getInstance(Context context) {
        mcontext = context;
        if (crashReportHelper == null) {
            crashReportHelper = new CrashReportHelper();
        }
        return crashReportHelper;
    }

    private static class CrashHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {


        }
    }

}
