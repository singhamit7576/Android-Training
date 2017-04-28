package com.myapp.ui.activites.Inheritance;

import android.util.Log;
import android.widget.Toast;


/**
 * This class extends Bank
 */
public class HDFC extends Bank{

    @Override
    public void rateOfInterest() {

        Toast.makeText(HDFC.this, "RATE OF INTEREST ", Toast.LENGTH_SHORT).show();

        Log.e("TAG" , "RATE OF INTEREST skill");
    }
}
