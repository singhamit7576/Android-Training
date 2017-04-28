package com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity;

import android.content.Context;
import android.content.SharedPreferences;


public class User {

    public static final String PREFS = "KEY";

    public static final String PREFS_KEY = "PREFS_String";
    SharedPreferences preferences;

    public User() {

        super();

    }

    public void save(Context context, String name) {

        SharedPreferences.Editor editor;
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.putString(PREFS_KEY, name);
        editor.commit();

    }

    public String getValue(Context context) {
        String text;
        preferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        text = preferences.getString(PREFS_KEY, null);
        return text;

    }






}
