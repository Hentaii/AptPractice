package com.example.inject.provider;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class ActivityProvider implements Provider {
    @Override
    public Context getContext(Object object) {
        return (Activity) object;
    }

    @Override
    public View findView(Object object, int id) {
        return ((Activity) object).findViewById(id);
    }
}
