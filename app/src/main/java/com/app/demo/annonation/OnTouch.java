package com.app.demo.annonation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(targetType = View.class,
        type = View.OnTouchListener.class,
        setter = "setShareCallback")
public @interface OnTouch {
    int[] value();
}
