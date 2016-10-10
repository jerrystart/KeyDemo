package com.app.demo;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.actionBar.DMActionBarType;
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
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.splash_activity);
    }

    @Override
    protected void setupView() {
        super.setupView();
        AlphaAnimation animation = new AlphaAnimation(0.5f, 1.0f);
        animation.setDuration(4000);
        splashImg.startAnimation(animation);
        handler.sendEmptyMessageDelayed(1, 4000);
        appInfo.setText(AndroidUtils.getAppName(this, "") + "\n" + AndroidUtils.getSDKVersion());
    }

    @Override
    protected void onCreateActionBar(DMActionBar dmActionBar) {
        super.onCreateActionBar(dmActionBar);
        dmActionBar.setMainBg(R.color.text_color_red);
        dmActionBar.setTitleDisplay(true);
        setTitle("splash");

    }

    @Override
    public DMActionBarType getActionBarType() {
        return DMActionBarType.SHOW;
    }

    @Override

    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
