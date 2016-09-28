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

    public void putFloat(final String key, final float value) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public String getString(final String key) {
        return sharedPreferences.getString(key, "");
    }

    public float getFloat(final String key) {
        return sharedPreferences.getFloat(key, 0f);
    }

    public int getInt(final String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public long getLong(final String key) {
        return sharedPreferences.getLong(key, 0L);
    }


}
