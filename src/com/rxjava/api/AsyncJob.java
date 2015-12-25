package com.rxjava.api;

/**
 * Created by MiJack on 2015/12/24.
 */
public abstract class AsyncJob<T> {
    public abstract void start(Callback<T> callback);

    public <R> AsyncJob<R> map(Func<T, R> func) {
        final AsyncJob<T> source = this;
        return new AsyncJob<R>() {
            @Override
            public void start(Callback<R> callback) {
                source.start(new Callback<T>() {
                    @Override
                    public void onResult(T result) {
                        R mapped = func.call(result);
                        callback.onResult(mapped);
                    }

                    @Override
                    public void onError(Exception e) {
                        callback.onError(e);
                    }
                });
            }
        };
    }
}