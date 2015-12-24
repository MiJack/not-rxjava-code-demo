package com.rxjava.api;

import com.rxjava.model.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

/**
 * Created by MiJack on 2015/12/24.
 */
public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);

        void onQueryFailed(Exception e);
    }

    interface StoreCallback {
        void onCatStored(Uri uri);

        void onStoreFailed(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);

    void store(Cat cat, StoreCallback storeCallback);
}