package com.example.dialog.BaseActivity;

import android.support.v7.app.AppCompatActivity;

/**
 * create abstract class
 * which extends AppCompactAcitvity
 * which contains some abstract method.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected   abstract void setReference();
    protected  abstract void onListener();
}
