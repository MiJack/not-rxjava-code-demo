package com.rxjava.model;

/**
 * Created by MiJack on 2015/12/24.
 */
public class Cat implements Comparable<Cat> {
    String imageUrl;
    int cuteness;

    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cuteness, another.cuteness);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCuteness() {
        return cuteness;
    }

    public void setCuteness(int cuteness) {
        this.cuteness = cuteness;
    }
}