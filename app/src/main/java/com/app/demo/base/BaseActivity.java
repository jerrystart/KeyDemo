package com.app.demo.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.actionBar.DMActionBarHelper;
import com.app.demo.actionBar.DMActionBarType;
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
    private final DMActionBarHelper dmActionBarHelper = DMActionBarHelper.createInstace(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DemoApplication.instance().activityOncreat(this);
        dmActionBarHelper.onCreate(savedInstanceState);
        onSetConTentView();
        dmActionBarHelper.onSetView();
        setTitle("");
        updateActionBar();
        InjectUtils.inject(this);
        LogUtils.toast(this, getClass().getName());
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

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (dmActionBarHelper.getActionBar() != null) {
            dmActionBarHelper.getActionBar().setTitle(title.toString());
        }
    }

    private void updateActionBar() {
        if (dmActionBarHelper.getActionBar() != null) {
            onCreateActionBar(dmActionBarHelper.getActionBar());
        }
    }

    public DMActionBarType getActionBarType() {
        return DMActionBarType.NONE;
    }

    public DMActionBarHelper getDMActionbar() {
        return dmActionBarHelper;
    }

    protected void onCreateActionBar(DMActionBar dmActionBar) {

    }

    public void startActivity(Class cla) {
        startActivity(cla, null);

    }

    protected void startActivity(Class cla, Bundle bundle) {
        Intent intent = new Intent(this, cla);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    //deep link
    private int getIntParam(String name, int defaultValue) {
        Intent i = getIntent();
        try {
            Uri uri = i.getData();
            if (uri != null) {
                String val = uri.getQueryParameter(name);
                return Integer.parseInt(val);
            }
        } catch (Exception e) {
        }

        return i.getIntExtra(name, defaultValue);
    }

    protected int getIntParam(String name) {
        return getIntParam(name, 0);
    }


    private long getLongParam(String name, long defaultValue) {
        Intent i = getIntent();
        try {
            Uri uri = i.getData();
            if (uri != null) {
                String val = uri.getQueryParameter(name);
                return Long.parseLong(val);
            }
        } catch (Exception e) {
        }

        return i.getLongExtra(name, defaultValue);
    }

    protected long getLongParam(String name) {
        return getLongParam(name, 0);
    }

    private String getStringParam(String name, String defaultValue) {
        Intent i = getIntent();
        try {
            Uri uri = i.getData();
            if (uri != null) {
                String val = uri.getQueryParameter(name);
                if (val != null)
                    return val;
            }
        } catch (Exception e) {
        }
        if (i.getExtras() != null && i.getExtras().containsKey(name)) {
            return i.getStringExtra(name);
        }
        return defaultValue;
    }

    protected String getStringParam(String name) {
        return getStringParam(name, null);
    }

    private boolean getBooleanParam(String name, boolean defaultValue) {
        Intent i = getIntent();
        try {
            Uri uri = i.getData();
            if (uri != null) {
                String val = uri.getQueryParameter(name);
                if (val != null)
                    return "true".equalsIgnoreCase(val) || "1".equals(val);
            }
        } catch (Exception e) {
        }
        return getIntent().getBooleanExtra(name, defaultValue);
    }

    protected boolean getBooleanParam(String name) {
        return getBooleanParam(name, false);
    }

    private double getDoubleParam(String name, double defaultValue) {
        Intent i = getIntent();
        try {
            Uri uri = i.getData();
            if (uri != null) {
                String val = uri.getQueryParameter(name);
                return Double.parseDouble(val);
            }
        } catch (Exception e) {
        }

        return i.getDoubleExtra(name, defaultValue);
    }

    protected double getDoubleParam(String name) {
        return getDoubleParam(name, 0);
    }

    private <T> T getSerializableParam(String name, T defaultValue, Class<T> cls) {
        Intent i = getIntent();
        if (i.getExtras() != null && i.getExtras().containsKey(name)) {
            return (T) i.getSerializableExtra(name);
        }
        if (defaultValue == null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    protected <T> T getSerializableParam(String name, Class<T> cls) {
        return getSerializableParam(name, null, cls);
    }

    protected void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            Toast.makeText(this, "msg is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    protected boolean isDoubleClickExit() {
        return false;
    }

    private long lastClickTime = 0l;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == event.getKeyCode() && KeyEvent.ACTION_UP == event.getAction()) {
            do {
                if (!isDoubleClickExit()) {
                    break;
                }
                long time = System.currentTimeMillis();
                if (time - lastClickTime <= 2000) {
                    finish();
                } else {
                    lastClickTime = time;
                    showToast("再按一次退出程序");
                    return true;
                }

            } while (false);
        }
        return super.dispatchKeyEvent(event);
    }
}
