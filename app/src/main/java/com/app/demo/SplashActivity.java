package com.app.demo;

import android.widget.ImageView;

import com.app.demo.annonation.InjectView;
import com.app.demo.base.BaseActivity;
import com.example.keydemo.R;

public class SplashActivity extends BaseActivity {
    @InjectView(R.id.splash_img)
    private ImageView splashImg;

    @Override
    protected void onSetConTentView() {
        setContentView(R.layout.splash_activity);
    }

    @Override
    protected void setupView() {
        super.setupView();
        setTitle("splash");
    }
}
