package com.example.appservice.ui.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by user on 27/3/17.
 */
public class utils {
    private static final boolean LOG_ON=true;



    public static void printLog(String tag,String message)
    {
        if(LOG_ON)
            Log.d(tag ,message);
    }
    public static void show(Context context, String string)
    {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
