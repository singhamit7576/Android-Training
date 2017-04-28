package com.example.actionbar;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * Make ACtivity two which
 * extend AppComapct class
 */
public class Activity_two extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_two);
        this.toolbarSetup();
        this.actionBarSetup();
    }


    /**Method for Displaying The
     * App icon and
     * for go on home */
    private void actionBarSetup() {

        ActionBar actionBar      =   getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);//for Logo
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }



    /**
     * setup The Toolbar
     */
    private void toolbarSetup() {
        android.support.v7.widget.Toolbar toolbarr    =    (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarr);
        setSupportActionBar(toolbarr);

    }


    /**
     * In this Method,
     * if You click on any Item
     * then that will shown in Text View.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
