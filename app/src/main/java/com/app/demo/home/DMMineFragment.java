package com.app.demo.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.demo.base.BaseFragment;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-20 14:09
 */
public class DMMineFragment extends BaseFragment {


    @Override
    protected View onsetView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dm_mine_fragment, container, false);
    }
}
