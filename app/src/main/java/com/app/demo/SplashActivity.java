package com.app.demo;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.annonation.InjectView;
import com.app.demo.base.BaseActivity;
import com.app.demo.home.DMMainActivity;
import com.app.demo.utils.AndroidUtils;
import com.example.keydemo.R;

public class SplashActivity extends BaseActivity {
    @InjectView(R.id.splash_img)
    private ImageView splashImg;
    @InjectView(R.id.app_info)
    private TextView appInfo;

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                startActivity(DMMainActivity.class);
                finish();
            }
        }
    };

    @Override
    protected void onSetConTentView() {
        setContentView(R.layout.splash_activity);
    }

    @Override
    protected void onCreateActionBar(DMActionBar dmActionBar) {
        super.onCreateActionBar(dmActionBar);
        setTitle("Splash");
    }


    @Override
    protected void setupView() {
        super.setupView();
        AlphaAnimation animation = new AlphaAnimation(0.5f, 1.0f);
        animation.setDuration(1200);
        splashImg.startAnimation(animation);
        handler.sendEmptyMessageDelayed(1, 1000);
        appInfo.setText(AndroidUtils.getAppName(this, "") + "\n" + AndroidUtils.getSDKVersion());
    }

    @Override
    protected boolean isDoubleClickExit() {
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
