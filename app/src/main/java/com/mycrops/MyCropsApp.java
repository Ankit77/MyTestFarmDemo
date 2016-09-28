package com.mycrops;


import android.app.Application;

import com.mycrops.utils.PreferenceUtils;

public class MyCropsApp extends Application {

    private static MyCropsApp instance;
    private PreferenceUtils preferenceUtils;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferenceUtils = new PreferenceUtils(this);
    }

    public static MyCropsApp getInstance() {
        return instance;
    }

}
