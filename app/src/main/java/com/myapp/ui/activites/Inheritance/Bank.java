package com.myapp.ui.activites.Inheritance;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


/**
 * Abstract class which extends
 * Activity.
 */
abstract  public class Bank extends Activity{

    protected void deposit(){

        Log.e("TAG" , "Deposit");
    }

    abstract protected void rateOfInterest();
}
