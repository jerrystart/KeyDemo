package com.app.demo.actionBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;

import com.app.demo.base.BaseActivity;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-11 18:32
 */
public class DMActionBarHelperWithActivity extends DMActionBarHelper {

    public DMActionBarHelperWithActivity(BaseActivity baseActivity) {
        mBaseActivity = baseActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mBaseActivity.getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
        mBaseActivity.setContentView(new ViewStub(mBaseActivity));
        mBaseActivity.getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.dm_actionbar);
        mDMActionBar = (DMActionBar) mBaseActivity.findViewById(R.id.demo_actionbar);
    }

    @Override
    public void onSetView() {
        if (mDMActionBar == null) {
            mDMActionBar = (DMActionBar) LayoutInflater.from(mBaseActivity).inflate(R.layout.dm_actionbar, null, false);
        }
        mDMActionBar.setLeftViewListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBaseActivity.onBackPressed();
            }
        });
        mBaseActivity.setTitle(mBaseActivity.getTitle());
    }

    @Override
    public void showActionBar() {
        showActionBarInActivity();
    }

    @Override
    public void hideActionBar() {
        hideActionBarInActivity();
    }
}
