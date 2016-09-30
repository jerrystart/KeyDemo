package com.app.demo.home;

import android.widget.Button;

import com.app.demo.actionBar.DMActionBar;
import com.app.demo.annonation.InjectView;
import com.app.demo.base.BaseActivity;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-12 17:18
 */
public class DebugActivity extends BaseActivity {
    @InjectView(R.id.btn_get_info)
    Button btnGetInfo;

    @Override
    protected void onSetConTentView() {
        setContentView(R.layout.debug_activity);
    }

    @Override
    protected void setupView() {
        super.setupView();

    }

    @Override
    protected void onCreateActionBar(DMActionBar dmActionBar) {
        super.onCreateActionBar(dmActionBar);
        setTitle("Debug");
    }
}
