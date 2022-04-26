package com.guy.class22b_and_6.utils;

import static android.content.Context.VIBRATOR_SERVICE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MySignal {


    private static MySignal me;

    private Context appContext;

    private MySignal(Context context) {
        this.appContext = context;
    }

    public static void initHelper(Context context) {
        if (me == null) {
            me = new MySignal(context.getApplicationContext());
        }
    }

    public static MySignal getMe() {
        return me;
    }




    public void toast(String message) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show();

    }

    public void vibrate() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) appContext.getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(40, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            ((Vibrator) appContext.getSystemService(VIBRATOR_SERVICE)).vibrate(40);
        }
    }

}
