package com.app.demo.annonation;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(targetType = AdapterView.class,
        type = OnItemClickListener.class,
        setter = "setOnItemClickListener")
public @interface OnItemClick {
    int[] value();
}
