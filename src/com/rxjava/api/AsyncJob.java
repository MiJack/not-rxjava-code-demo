package com.rxjava.api;

/**
 * Created by MiJack on 2015/12/24.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);
}