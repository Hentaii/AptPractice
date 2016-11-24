package com.example.inject.provider;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class FragmentProvider implements Provider {
    @Override
    public Context getContext(Object object) {
        return ((Fragment) object).getContext();
    }

    @Override
    public View findView(Object object, int id) {
        return ((Fragment) object).getView().findViewById(id);
    }
}
