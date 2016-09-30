package com.app.demo.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.demo.annonation.InjectView;
import com.app.demo.annonation.OnClick;
import com.app.demo.base.BaseFragment;
import com.app.demo.utils.AsyncTaskUtills;
import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-20 14:09
 */
public class DMHomeFragment extends BaseFragment implements OnClickListener {
    @InjectView(R.id.asynctask)
    TextView asynctask;

    @Override
    protected View onsetView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dm_home_fragment, container, false);
    }

    @Override
    protected void setupView() {
        super.setupView();
        getData();
    }

    public void getData() {

    }

    @OnClick({R.id.asynctask})
    @Override
    public void onClick(View v) {
        AsyncTaskUtills asyncTaskUtills = new AsyncTaskUtills();
        asyncTaskUtills.execute("https://api.douban.com/v2/movie");
    }
}
