package com.app.demo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.actionBar.DMActionBarHelper;
import com.app.demo.annonation.InjectUtils;
import com.app.demo.utils.LogUtils;
import com.example.keydemo.R;

import de.greenrobot.event.EventBus;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-08-11 16:39
 */
public abstract class BaseFragment extends Fragment {
    private DMActionBarHelper dmActionBarHelper;
    private BaseActivity baseActivity;
    private CharSequence activityTitle;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Fragment must be attach baseActivity");
        }
        baseActivity = (BaseActivity) activity;
        activityTitle = baseActivity.getTitle();
        dmActionBarHelper = DMActionBarHelper.createInstace(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleArgs();
        LogUtils.toast(getActivity(), getClass().getName());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dm_fragment, container, false);
        view.setBackgroundResource(getBackgroundResourceId());
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_container);
        View contentView = onsetView(inflater, frameLayout);
        if (contentView != null) {
            frameLayout.addView(contentView);
        }
        InjectUtils.inject(this, contentView);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dmActionBarHelper.onCreate(savedInstanceState);
        dmActionBarHelper.onSetView();
        displayActionbar(false);
        onCreateActionBar(dmActionBarHelper.getActionBar());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupView();
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {

        }
    }

    protected void onCreateActionBar(DMActionBar dmActionBar) {

    }


    protected void displayActionbar(boolean hasActionBar) {
        if (hasActionBar) {
            dmActionBarHelper.showActionBar();
        } else {
            dmActionBarHelper.hideActionBar();
        }
    }

    protected void setTitle(String title) {
        if (dmActionBarHelper != null && dmActionBarHelper.getActionBar() != null) {
            dmActionBarHelper.getActionBar().setTitle(title);
        }
    }

    protected abstract View onsetView(LayoutInflater inflater, ViewGroup container);

    protected void handleArgs() {

    }

    protected void setupView() {

    }

    protected int getBackgroundResourceId() {
        return R.color.main_bg;
    }

    @Override

    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
