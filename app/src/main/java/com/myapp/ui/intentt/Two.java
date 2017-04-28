package com.myapp.ui.intentt;

import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.EditText;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methds.
 */
public class Two extends BaseActivity{

    private EditText txt;
    private int value;
    private Bundle bundle;
    private String data;
    private final int secondsDelayed = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        this.setReference();
        this.OnListener();
    }

    /**
     * get data from Intent.
     * set That into Edit Text.
     */
    private void set() {
        bundle       =  getIntent().getExtras();
        data         =  bundle.getString("MESSAGE");
        value        =   Integer.parseInt(data);                                       //convert into integer value.
        value        =  value * value;
        txt.setText(String.valueOf(value));
    }

    /**
     * //create intent to send data onto Fisrt Activity.
     */
    private void  show() {
        Intent mIntent   =   new Intent();
        mIntent.putExtra("MESSAGE", String.valueOf(value));
        setResult(RESULT_OK, mIntent);

    }

    /**
     * run thread to
     * hold the screen for Two seconds
     */
    private void timer(){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, secondsDelayed * 2000);
    }


    /**
     * set refreence. of edit text.
     */
    @Override
    protected void setReference() {
        txt         =   (EditText) findViewById(R.id.txt);
        this.set();
    }

    @Override
    protected void OnListener() {
        this.timer();
        this.show();

    }
}
