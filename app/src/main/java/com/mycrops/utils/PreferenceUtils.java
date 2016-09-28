package com.mycrops.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {

    private Context context;
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFERENCE_NAME = "my_crops.xml";

    public PreferenceUtils(final Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void putString(final String key, final String value) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public void putInt(final String key, final int value) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putLong(final String key, final long value) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

}
