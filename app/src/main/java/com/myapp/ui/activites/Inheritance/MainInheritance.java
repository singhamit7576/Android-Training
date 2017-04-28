package com.myapp.ui.activites.Inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.myapp.R;

/**
 * Create MainActivity
 * which extends HDFC
 */

public class MainInheritance extends HDFC{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inheritance);
        this.test();
    }
    /**
     * HDfc methnod
     */
    private void test() {
            this.rateOfInterest();
        }

    }

