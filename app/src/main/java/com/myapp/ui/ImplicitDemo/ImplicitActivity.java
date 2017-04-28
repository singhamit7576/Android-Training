package com.myapp.ui.ImplicitDemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.widget.Button;
import android.view.View;
import android.widget.Switch;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements List_Fragmentt.Communication  Interface
 */
public class ImplicitActivity extends BaseActivity implements View.OnClickListener {


    private Button btn_click;
    String TAG      =   this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        utils.printLog(TAG,"Inside Create");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"Outside Create");

    }

    @Override
    public void onClick(View v) {
        Intent myIntent       =       new Intent    (Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(myIntent);
    }

    @Override
    protected void setReference() {

        btn_click       =   (Button)    findViewById(R.id.btn_click);
    }

    @Override
    protected void OnListener() {
        btn_click.setOnClickListener(this);

    }
}
