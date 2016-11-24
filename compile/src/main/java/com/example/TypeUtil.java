package com.example;

import com.squareup.javapoet.ClassName;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class TypeUtil {
    public static final ClassName ANDROID_VIEW = ClassName.get("android.view", "View");
    public static final ClassName ANDROID_ON_CLICK_LISTENER = ClassName.get("android.view", "View", "OnClickListener");
    public static final ClassName INJET = ClassName.get("com.example.inject.inject", "Inject");
    public static final ClassName PROVIDER = ClassName.get("com.example.inject.provider","Provider");
}
