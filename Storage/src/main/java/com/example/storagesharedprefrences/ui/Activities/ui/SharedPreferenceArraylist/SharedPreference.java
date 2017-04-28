package com.example.storagesharedprefrences.ui.Activities.ui.SharedPreferenceArraylist;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.storagesharedprefrences.ui.Activities.ui.listSharedPrefrences.UserData;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {

    Activity activity;
    private  SharedPreferences preferences;
    private SharedPreferences.Editor editor;;



    public SharedPreference(Activity activity) {
        this.activity = activity;
    }

    public void store(String key, ArrayList favorites) {

        preferences = activity.getPreferences(Context.MODE_PRIVATE);
        editor = preferences.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);
        editor.putString(key, jsonFavorites);
        editor.commit();
    }

    public ArrayList load(String Key) {
        List list;
        preferences = activity.getPreferences(Context.MODE_PRIVATE);
        if (preferences.contains(Key)) {
            String data     =    preferences.getString(Key, null);
            Gson gson       =    new Gson();
            UserData[] userDatas  = gson.fromJson(data, UserData[].class);
            list        =  Arrays.asList(userDatas);
            list        =  new ArrayList(list);
        } else
            return null;
        return (ArrayList) list;
    }






}
