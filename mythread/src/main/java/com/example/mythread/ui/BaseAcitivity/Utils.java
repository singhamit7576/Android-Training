package com.example.mythread.ui.BaseAcitivity;


import android.util.Log;



/**
 * Created by user on 3/4/17.
 */
public class Utils {


    private static final boolean LOG_ON=true;



    public static void printLog(String tag,String message)
    {
        if(LOG_ON)
            Log.d(tag ,message);
    }

}
