package com.rxjava.api;

import com.rxjava.model.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.Collections;
import java.util.List;

/**
 * Created by MiJack on 2015/12/24.
 */
public class CatsHelper {

    ApiWrapper apiWrapper;

    public AsyncJob<Uri> saveTheCutestCat(String query) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> cutestCatCallback) {
                apiWrapper.queryCats(query)
                        .start(new Callback<List<Cat>>() {
                            @Override
                            public void onResult(List<Cat> cats) {
                                Cat cutest = findCutest(cats);
                                apiWrapper.store(cutest)
                                        .start(new Callback<Uri>() {
                                            @Override
                                            public void onResult(Uri result) {
                                                cutestCatCallback.onResult(result);
                                            }

                                            @Override
                                            public void onError(Exception e) {
                                                cutestCatCallback.onError(e);
                                            }
                                        });
                            }

                            @Override
                            public void onError(Exception e) {
                                cutestCatCallback.onError(e);
                            }
                        });
            }
        };
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}