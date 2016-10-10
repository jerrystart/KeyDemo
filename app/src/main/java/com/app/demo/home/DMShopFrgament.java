package com.app.demo.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.base.BaseFragment;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-20 14:10
 */
public class DMShopFrgament extends BaseFragment {


    @Override
    protected View onsetView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dm_shop_fragment, container, false);
    }

    @Override
    protected void onCreateActionBar(DMActionBar dmActionBar) {
        super.onCreateActionBar(dmActionBar);
        displayActionbar(true);
        dmActionBar.setLeftDisplay(false);
        setTitle("shop");

    }
}
