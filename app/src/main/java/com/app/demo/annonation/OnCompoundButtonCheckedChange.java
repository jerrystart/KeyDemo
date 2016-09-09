package com.app.demo.annonation;

import android.widget.CompoundButton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(targetType = CompoundButton.class,
        type = CompoundButton.OnCheckedChangeListener.class,
        setter = "setOnCheckedChangeListener")
public @interface OnCompoundButtonCheckedChange {
    int[] value();
}
