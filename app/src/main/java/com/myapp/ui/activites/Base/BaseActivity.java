package com.myapp.ui.activites.Base;

import android.support.v7.app.AppCompatActivity;


/**
 * create abstract class
 * which extends AppCompactActivity
 * which contains some abstract method.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected abstract void setReference();
    protected abstract void OnListener();
}
