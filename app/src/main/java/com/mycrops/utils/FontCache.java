package com.mycrops.utils;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;

public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();
    private static final String ASSETS_FOLDER = "fonts/";

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), ASSETS_FOLDER + name);
            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}