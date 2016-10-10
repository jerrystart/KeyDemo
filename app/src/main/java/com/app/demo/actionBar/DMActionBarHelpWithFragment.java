package com.app.demo.actionBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;

import com.app.demo.base.BaseActivity;
import com.app.demo.base.BaseFragment;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-11 18:37
 */
public class DMActionBarHelpWithFragment extends DMActionBarHelper {
    public DMActionBarHelpWithFragment(BaseFragment baseFragment) {
        mBaseActivity = (BaseActivity) baseFragment.getActivity();
        mBaseFragment = baseFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (DMActionBarType.SHOW == mBaseActivity.getActionBarType()) {
            //activity bar
            mDMActionBar = (DMActionBar) mBaseActivity.findViewById(R.id.demo_actionbar);
        } else if (DMActionBarType.DMCONTENT == mBaseActivity.getActionBarType()) {

        } else {
            //fragment bar
            ViewStub stub = (ViewStub) mBaseFragment.getView().findViewById(R.id.dm_actionbar_stub);
            if (stub != null) {
                stub.inflate();
                mDMActionBar = (DMActionBar) mBaseFragment.getView().findViewById(R.id.demo_actionbar);
            }
        }
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
