package com.itoutiao.news.toutiaonews.base;

import android.app.Application;

/**
 * Created by 0bug-yun on 2016/8/12.
 */
public class ITTApplication extends Application {
    private static ITTApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static ITTApplication getInstance() {
         return mInstance;
    }
}
