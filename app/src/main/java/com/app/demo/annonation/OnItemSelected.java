package com.app.demo.annonation;

import android.widget.AdapterView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(targetType = AdapterView.class,
        type = AdapterView.OnItemSelectedListener.class,
        setter = "OnItemSelectedListener")
public @interface OnItemSelected {
    int[] value();
}
