package com.app.demo.actionBar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.app.demo.base.BaseActivity;
import com.app.demo.base.BaseFragment;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-11 18:28
 */
public abstract class DMActionBarHelper {
    protected BaseActivity mBaseActivity;
    protected BaseFragment mBaseFragment;
    protected DMActionBar mDMActionBar;

    public static DMActionBarHelper createInstace(BaseActivity baseActivity) {
        return new DMActionBarHelperWithActivity(baseActivity);
    }

    public static DMActionBarHelper createInstace(BaseFragment baseFragment) {
        return new DMActionBarHelpWithFragment(baseFragment);
    }

    public final DMActionBar getActionBar() {
        return mDMActionBar;
    }

    protected final void showActionBarInActivity() {
        try {
            // retrieve value for
            // com.android.internal.R.id.title_container(=0x1020149)
            int titleContainerId = (Integer) Class.forName("com.android.internal.R$id").getField("title_container")
                    .get(null);

            // remove all views from titleContainer
            ((ViewGroup) mBaseActivity.getWindow().findViewById(titleContainerId)).setVisibility(View.VISIBLE);
            mDMActionBar.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final void hideActionBarInActivity() {
        try {
            // retrieve value for
            // com.android.internal.R.id.title_container(=0x1020149)
            int titleContainerId = (Integer) Class.forName("com.android.internal.R$id").getField("title_container")
                    .get(null);

            // remove all views from titleContainer
            ((ViewGroup) mBaseActivity.getWindow().findViewById(titleContainerId)).setVisibility(View.GONE);
            mDMActionBar.setVisibility(View.GONE);
        } catch (Exception ex) {
            // whatever you want to do here..
        }
    }

    public abstract void onCreate(Bundle savedInstanceState);

    public abstract void onSetView();

    public abstract void showActionBar();

    public abstract void hideActionBar();
}
