package com.BaseClass;

import android.util.Log;

/**
 * Created by user on 15/3/17.
 */
public class utils {
    private static final boolean LOG_ON=true;



    public static void printLog(String tag,String message)
    {
        if(LOG_ON)
            Log.d(tag ,message);
    }
}
