package com.example.inject.inject;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.view.View;

import com.example.inject.provider.ActivityProvider;
import com.example.inject.provider.FragmentProvider;
import com.example.inject.provider.Provider;
import com.example.inject.provider.ViewProvider;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public class ViewInject {
    public static final ActivityProvider mActivityProvider = new ActivityProvider();
    public static final ViewProvider mViewProvider = new ViewProvider();
    public static final FragmentProvider mFragmentProvider = new FragmentProvider();
    public static final ArrayMap<String, Inject> mInjectMap = new ArrayMap<>();

    public static void inject(Activity activity) {
        inject(activity, activity, mActivityProvider);
    }

    public static void inject(View view) {
        inject(view, view);
    }

    public static void inject(Object host, View view) {
        inject(host, view, mViewProvider);
    }

    public static void inject(Fragment fragment) {
        inject(fragment, fragment, mFragmentProvider);
    }

    private static void inject(Object host, Object object, Provider provider) {
        String className = host.getClass().getName();
        try {
            Inject inject = mInjectMap.get(className);
            if (inject == null) {
                Class<?> aClass = Class.forName(className + "$$ViewInject");
                inject = (Inject) aClass.newInstance();
                mInjectMap.put(className, inject);
            }
            inject.inject(host, object, provider);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
