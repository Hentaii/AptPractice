package com.example.inject.inject;

import com.example.inject.provider.Provider;

/**
 * Created by GanChenQ on 2016/11/24.
 */

public interface Inject<T> {
    void inject(T host, Object object, Provider provider);
}
