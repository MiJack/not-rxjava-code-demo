package com.rxjava.api;

/**
 * Created by MiJack on 2015/12/25.
 */
public interface Func<T, R> {
    R call(T t);
}