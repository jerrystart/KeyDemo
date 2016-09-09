package com.app.demo.actionBar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-09 10:39
 */
public class DMActionBar extends FrameLayout {
    public DMActionBar(Context context) {
        this(context, null, 0);
    }

    public DMActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DMActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
