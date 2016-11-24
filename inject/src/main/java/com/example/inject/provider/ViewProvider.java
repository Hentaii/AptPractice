package com.example.inject.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class ViewProvider implements Provider {
    @Override
    public Context getContext(Object object) {
        return ((View) object).getContext();
    }

    @Override
    public View findView(Object object, int id) {
        return ((View) object).findViewById(id);
    }
}
