package com.app.demo.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.app.demo.annonation.InjectUtils;
import com.app.demo.application.DemoApplication;
import com.app.demo.utils.LogUtils;

import de.greenrobot.event.EventBus;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-08-11 16:39
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoApplication.instance().activityOncreat(this);
        onSetConTentView();
        InjectUtils.inject(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupView();
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {

        }

        LogUtils.e("BaseActivity>>>>onPostCreate");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("BaseActivity>>>>onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        DemoApplication.instance().activityOnstart(this);
        LogUtils.e("BaseActivity>>>>onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        DemoApplication.instance().activityOnresum(this);
        LogUtils.e("BaseActivity>>>>onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        LogUtils.e("BaseActivity>>>>onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        DemoApplication.instance().activityOnpause(this);
        LogUtils.e("BaseActivity>>>>onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        DemoApplication.instance().activityOnstop(this);
        LogUtils.e("BaseActivity>>>>onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DemoApplication.instance().activityOndestory(this);
        EventBus.getDefault().unregister(this);
        LogUtils.e("BaseActivity>>>>onDestroy");
    }

    protected abstract void onSetConTentView();

    protected void setupView() {

    }

}
