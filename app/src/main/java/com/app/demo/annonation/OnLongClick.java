package com.app.demo.annonation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(targetType = View.class,
        type = View.OnLongClickListener.class,
        setter = "setOnLongClickListener")
public @interface OnLongClick {
    int[] value();
}
