package com.example.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.BaseActivity.BaseActivity;

/**
 * create Activity which
 * extends my abstract class.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_clickeditem;
    private Button btn_click;


    /*ACticity Created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();
        this.OnListener();
    }

    /**
     * Set Referneces Of
     * TextView and Edit Text.
     */
    protected void setReference(){

        tv_clickeditem                =    (TextView) findViewById(R.id.tv_clickeditem);
        btn_click              =    (Button)findViewById(R.id.btn_click);
        this.setupToolBar();

    }


    /**
     * Set up tollbar with
     * Action bar
     */
    private void setupToolBar() {
        Toolbar toolbar    =    (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    /*Button Perfrom Action
         when User clicks */
    @Override
    protected void OnListener() {
        btn_click.setOnClickListener(this);
        this.display_icons();

    }


    /**Method for Displaying The
     * App icon and
     * for go on home */
    private void display_icons() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//back to home
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);//for Logo
        getSupportActionBar().setDisplayUseLogoEnabled(true);

    }



    /**
     * we inflate our
     * menu.xml in onCreateOptionsMenu.
     * @param  menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionmenu, menu);
        return true;
    }



    /**
     * In this,when you click
     * Back Arrow,close the
     * Application
     */
    @Override
    public boolean onSupportNavigateUp(){
        Toast.makeText(MainActivity.this, "Go to back ", Toast.LENGTH_SHORT).show();
        finish();
        return true;
    }



    /**
     * In this Method,
     * if You click on any Item
     * then that will shown in Text View.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

            case R.id.share_item:

                Toast.makeText(MainActivity.this, "share Button Is clicked", Toast.LENGTH_SHORT).show();
                this.share();
                return true;

            case R.id.search:
                Toast.makeText(MainActivity.this, "Search Button Is clicked", Toast.LENGTH_SHORT).show();
                tv_clickeditem.setText("search is clicked");
                return true;

            case R.id.reset:
                Toast.makeText(MainActivity.this, "Refresh Button Is clicked", Toast.LENGTH_SHORT).show();
                tv_clickeditem.setText("Refersh is clicked");
                return true;

            case R.id.exit:
                finish();
                return true;
        }
        return(super.onOptionsItemSelected(item));
    }


    /**
     * this method,
     * for  Sharing
     */
    private void share() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    /**
     * This method,called
     * when user Clicked button and
     * Go to next Actitvity.
     */
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,Activity_two.class));

    }
}
