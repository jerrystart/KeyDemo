package com.app.demo.actionBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.keydemo.R;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-09 10:39
 */
public class DMActionBar extends FrameLayout {
    private TextView titleView;
    private TextView subTitleView;
    private FrameLayout customTitle;
    private LinearLayout leftCustomLayout;
    private ImageButton backBtn;
    private LinearLayout rightCustomLayout;
    private TextView customBtn;

    public DMActionBar(Context context) {
        this(context, null, 0);
    }

    public DMActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DMActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        titleView = (TextView) findViewById(R.id.title);
        subTitleView = (TextView) findViewById(R.id.sub_title);
        customTitle = (FrameLayout) findViewById(R.id.custom_title);
        leftCustomLayout = (LinearLayout) findViewById(R.id.left_custom_layout);
        backBtn = (ImageButton) findViewById(R.id.back_btn);
        rightCustomLayout = (LinearLayout) findViewById(R.id.right_custom_layout);
        customBtn = (TextView) findViewById(R.id.custom_btn);
        setTitle("");
        setSubTitle("");
    }

    public void setTitle(String title) {
        titleView.setVisibility(TextUtils.isEmpty(title) ? GONE : VISIBLE);
        titleView.setText(title);
    }

    public void setTitleDisplay(boolean display) {
        titleView.setVisibility(display ? VISIBLE : GONE);
    }

    public void setTitleListener(OnClickListener listener) {
        if (listener != null) {
            titleView.setOnClickListener(listener);
            titleView.setClickable(listener != null);
        }
    }

    public void setSubTitle(String subtitle) {
        subTitleView.setVisibility(TextUtils.isEmpty(subtitle) ? GONE : VISIBLE);
        subTitleView.setText(subtitle);
    }

    public void setSubTitleDisplay(boolean display) {
        subTitleView.setVisibility(display ? VISIBLE : GONE);
    }

    public void setSubTitleListener(OnClickListener listener) {
        if (listener != null) {
            subTitleView.setOnClickListener(listener);
            subTitleView.setClickable(listener != null);
        }
    }

    public void setLeftViewListener(OnClickListener listener) {
        if (listener != null) {
            backBtn.setOnClickListener(listener);
        }
    }

    public void removeAllAction() {

    }
}
