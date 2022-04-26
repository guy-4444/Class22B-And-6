package com.guy.class22b_and_6.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.guy.class22b_and_6.objects.Artist;
import com.guy.class22b_and_6.objects.Tattoo;
import com.guy.class22b_and_6.utils.MSPV1;
import com.guy.class22b_and_6.utils.MSPV2;
import com.guy.class22b_and_6.utils.MSPV3;
import com.guy.class22b_and_6.R;
import com.guy.class22b_and_6.utils.MySignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout main_EDT_name;
    private MaterialTextView main_LBL_data;

    public static final String SP_KEY_NAME = "SP_KEY_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        // V1
        String name1 = MSPV1.getStringFromSP(this, SP_KEY_NAME, "NA");

        // V2
        MSPV2 mspv2 = new MSPV2(this);
        String name2 = mspv2.getStringFromSP(SP_KEY_NAME, "NA");

        // V3
        String name3 = MSPV3.getMe().getStringFromSP(SP_KEY_NAME, "NA");


        String json = MSPV3.getMe().getStringFromSP("T", "");
        Tattoo tattoo = null;
        try {
            tattoo = new Gson().fromJson(json, Tattoo.class);
        } catch (Exception ex) { }



        ArrayList<Tattoo> tattoos = new ArrayList<>();
        tattoos.add(new Tattoo());
        tattoos.add(new Tattoo());
        tattoos.add(new Tattoo());


        String j = new Gson().toJson(tattoos);

        TypeToken token = new TypeToken<ArrayList<Tattoo>>() {};
        ArrayList<Tattoo> ts = new Gson().fromJson(j, token.getType());



        if (tattoo == null) {
            tattoo = new Tattoo();
        }


        main_LBL_data.setText(tattoo.getName());

        startTattoo();


        MySignal.getMe().vibrate();

        new MaterialAlertDialogBuilder(this.getApplicationContext())
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("button", null)
                .show();
    }

    private void startTattoo() {
        HashMap<String, Integer> needles = new HashMap<>();
        needles.put("AAA", 2);
        needles.put("BBB", 1);
        needles.put("CCC", 4);
        needles.put("DDD", 3);
        Tattoo tattoo = new Tattoo()
                .setName("Sakura Tree")
                .setPrice(1600.90)
                .setPainLevel(3)
                .setOriginalDesign(false)
                .setSize(Tattoo.SIZE.LARGE)
                .setColors(new ArrayList<>(Arrays.asList("#FF0000", "#FF4FAE")))
                .setNeedles(needles)
                .setArtist(new Artist()
                        .setName("Rom")
                        .setExperience(2)
                        .setMale(true)
                );


        String json = new Gson().toJson(tattoo);
        MSPV3.getMe().putStringToSP("T", json);
    }


    private void findViews() {
        main_EDT_name = findViewById(R.id.main_EDT_name);
        main_LBL_data = findViewById(R.id.main_LBL_data);
    }
}
































