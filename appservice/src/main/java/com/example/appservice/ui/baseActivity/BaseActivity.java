package com.example.appservice.ui.baseActivity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 27/3/17.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected abstract void setReference();
    protected abstract void onListener();
}

