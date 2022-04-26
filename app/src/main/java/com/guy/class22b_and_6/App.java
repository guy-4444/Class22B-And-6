package com.guy.class22b_and_6;

import android.app.Application;

import com.guy.class22b_and_6.utils.MSPV3;
import com.guy.class22b_and_6.utils.MySignal;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MSPV3.initHelper(this);
        MySignal.initHelper(this);

    }
}
