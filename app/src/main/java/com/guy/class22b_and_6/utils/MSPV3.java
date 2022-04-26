package com.guy.class22b_and_6.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class MSPV3 {


    private final String SP_FILE_NAME = "MY_SP_FILE";
    private SharedPreferences prefs = null;

    private static MSPV3 me;


    private MSPV3(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static void initHelper(Context context) {
        if (me == null) {
            me = new MSPV3(context);
        }
    }

    public static MSPV3 getMe() {
        return me;
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





    public <T> void putArray(String KEY, ArrayList<T> array) {
        String json = new Gson().toJson(array);
        prefs.edit().putString(KEY, json).apply();
    }

    public <T> ArrayList<T> getArray(String KEY, TypeToken typeToken) {
        // type token == new TypeToken<ArrayList<YOUR_CLASS>>() {}
        try {
            ArrayList<T> arr = new Gson().fromJson(prefs.getString(KEY, ""), typeToken.getType());
            if (arr == null) {
                return new ArrayList<>();
            }
            return arr;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public <S, T> void putMap(String KEY, HashMap<S, T> map) {
        String json = new Gson().toJson(map);
        prefs.edit().putString(KEY, json).apply();
    }

    public <S, T> HashMap<S, T> getMap(String KEY, TypeToken typeToken) {
        // getMap(MySharedPreferencesV4.KEYS.SP_PLAYLISTS, new TypeToken<HashMap<String, Playlist>>() {});
        // TypeToken token = new TypeToken<ArrayList<YOUR_CLASS>>() {}
        try {
            HashMap<S, T> map = new Gson().fromJson(prefs.getString(KEY, ""), typeToken.getType());
            if (map == null) {
                return new HashMap<>();
            }
            return map;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new HashMap<>();
    }
}
