package com.app.demo.home;

import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.demo.base.BaseActivity;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-17 22:37
 */
public class DMMainActivity extends BaseActivity {
    FragmentTabHost mTabHost;
    private String tabStr[] = {"功能", "作品", "商品", "我的"};
    private int tabInt[] = {R.drawable.act_tabs_select_home, R.drawable.act_tab_select_works,
            R.drawable.act_tab_select_shop, R.drawable.act_tab_select_mine};

    @Override
    protected void onSetConTentView() {
        setContentView(R.layout.dm_main_activity);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("home").setIndicator(getTabView(0)),
                DMHomeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("works").setIndicator(getTabView(1)),
                DMWorksFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("shop").setIndicator(getTabView(2)),
                DMShopFrgament.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("mine").setIndicator(getTabView(3)),
                DMMineFragment.class, null);
    }


    private View getTabView(int i) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tabs, null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_img);
        TextView txt = (TextView) view.findViewById(R.id.tab_txt);
        img.setImageResource(tabInt[i]);
        txt.setText(tabStr[i]);
        return view;
    }
}
