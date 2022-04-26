package com.guy.class22b_and_6.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPV1 {

    private static final String SP_FILE_NAME = "MY_SP_FILE";

    public static void putIntToSP(Context context, String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getIntFromSP(Context context, String key, int def) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getInt(key, def);
    }

    public static void putStringToSP(Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringFromSP(Context context, String key, String def) {
        SharedPreferences prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getString(key, def);
    }

}
