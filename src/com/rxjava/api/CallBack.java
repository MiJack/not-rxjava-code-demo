package com.rxjava.api;

/**
 * Created by MiJack on 2015/12/24.
 */
public interface Callback<T> {
    void onResult(T result);

    void onError(Exception e);
}
