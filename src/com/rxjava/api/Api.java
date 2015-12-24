package com.rxjava.api;

import com.rxjava.model.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

/**
 * Created by MiJack on 2015/12/24.
 */
public interface Api {
    List<Cat> queryCats(String query);

    Uri store(Cat cat);
}
