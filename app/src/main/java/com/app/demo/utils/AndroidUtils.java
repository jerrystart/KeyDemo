package com.app.demo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-18 16:20
 */
public class AndroidUtils {
    private static final String TAG = AndroidUtils.class.getName();

    private AndroidUtils() {

    }

    public static String getAppName(Context context, String packageName) {
        String appName;
        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            appName = context.getString(packageInfo.applicationInfo.labelRes);

        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.d("filed to get version number");
            appName = "";
        }
        return appName;
    }

    public static int getSDKVersion() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (Exception e) {
            return 3;
        }
    }

    public static boolean isEmulator() {
        return Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk");
    }

    /**
     * 版本号比较
     *
     * @param a
     * @param b
     * @return if a = b return 0; a > b return 1;a < b return -1
     */
    public static int compareVersionName(String a, String b) {
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b)) {
            return 0;
        }
        if (a.equals(b)) {
            return 0;
        }
        int[] target = versionNames(a);
        int[] current = versionNames(b);
        int length = Math.min(target.length, current.length);
        for (int i = 0; i < length; i++) {
            if (current[i] == target[i]) {
                continue;
            }
            return target[i] > current[i] ? 1 : -1;
        }
        if (target.length == current.length) {
            return 0;
        }
        boolean isTargetLonger = target.length > current.length;
        int[] tmp = isTargetLonger ? target : current;
        for (int i = length; i < tmp.length; i++) {
            if (tmp[length] > 0) {
                return isTargetLonger ? 1 : -1;
            }
        }
        return 0;

    }

    public static int[] versionNames(String versionName) {
        if (TextUtils.isEmpty(versionName)) {
            return new int[0];
        }
        String[] names = versionName.split("\\.");
        int[] intName = new int[names.length];
        for (int i = 0; i < intName.length; i++) {
            intName[i] = Integer.valueOf(names[i].trim());
        }
        return intName;
    }
}
