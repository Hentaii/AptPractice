package com.example.inject.provider;

import android.content.Context;
import android.view.View;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public interface Provider {
    Context getContext(Object object);

    View findView(Object object, int id);
}
