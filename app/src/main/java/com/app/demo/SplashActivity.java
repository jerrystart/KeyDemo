package com.app.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.app.demo.utils.ToastUtils;
import com.example.keydemo.R;

public class SplashActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.toast("one");
        ToastUtils.toast("one");
    }
}
