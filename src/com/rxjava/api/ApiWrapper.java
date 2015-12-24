package com.rxjava.api;

import com.rxjava.model.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

/**
 * Created by MiJack on 2015/12/24.
 */
public class ApiWrapper {
    Api api;

    public AsyncJob<List<Cat>> queryCats(String query) {
        return new AsyncJob<List<Cat>>() {
            @Override
            public void start(Callback<List<Cat>> catsCallback) {
                api.queryCats(query, new Api.CatsQueryCallback() {
                    @Override
                    public void onCatListReceived(List<Cat> cats) {
                        catsCallback.onResult(cats);
                    }

                    @Override
                    public void onQueryFailed(Exception e) {
                        catsCallback.onError(e);
                    }
                });
            }
        };
    }

    public AsyncJob<Uri> store(Cat cat) {
        return new AsyncJob<Uri>() {
            @Override
            public void start(Callback<Uri> uriCallback) {
                api.store(cat, new Api.StoreCallback() {
                    @Override
                    public void onCatStored(Uri uri) {
                        uriCallback.onResult(uri);
                    }

                    @Override
                    public void onStoreFailed(Exception e) {
                        uriCallback.onError(e);
                    }
                });
            }
        };
    }
}