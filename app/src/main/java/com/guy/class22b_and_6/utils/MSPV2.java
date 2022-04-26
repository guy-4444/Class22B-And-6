package com.guy.class22b_and_6.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MSPV2 {


    private final String SP_FILE_NAME = "MY_SP_FILE";
    private SharedPreferences prefs = null;

    public MSPV2(Context context) {
        prefs = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void putIntToSP(String key, int value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntFromSP(String key, int def) {
        return prefs.getInt(key, def);
    }

    public void putStringToSP(String key, String value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringFromSP(String key, String def) {
        return prefs.getString(key, def);
    }

}
