package com.myapp.ui.mainActivityAll;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapp.R;
import com.myapp.ui.CustomView.Commonactivity;
import com.myapp.ui.CustomView.DynamicView;
import com.myapp.ui.Drawable.NInePatch;
import com.myapp.ui.Drawable.SunAnimation;
import com.myapp.ui.Freagmentt.MainActivityyy;
import com.myapp.ui.Widgets.Linearlayout;
import com.myapp.ui.Widgets.Logfile;
import com.myapp.ui.Widgets.Radio_Button;
import com.myapp.ui.Widgets.Relativelayout;
import com.myapp.ui.Widgets.Scrollview;
import com.myapp.ui.Widgets.Tablelayout;
import com.myapp.ui.Widgets.Webvieww;
import com.myapp.ui.Widgets.framlayout;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.activites.Inheritance.MainInheritance;
import com.myapp.ui.activites.NetwrokOperation.Activity_Exception;
import com.myapp.ui.marshalling.Serialization.Serail_Main;
import com.myapp.ui.utils.utils;

/**
 * create MAin Activity which extends my Abstract class which have
 *  some abstract methods and and all the acitivty handle
 *  from this activity.
 */
public class Mainlayout extends BaseActivity implements View.OnClickListener {

    private     Button  btn_Linear,btn_relative,btn_Table,btn_Frame,btn_Scroll;
    private     Button  btn_Custom,btn_dynamic,btn_fragment,btn_exception;
    private     Button  btn_animation,btn_Ninepatch,btn_inherit;
    private     Button  btn_Webview,btn_Radio,btn_logfile,btn_serailization;

    private String TAG  =   this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlayout);

        utils.printLog(TAG,"Inside Create");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"OutsideCreate");

    }

    /**
     * set Refrences of buttons
     */
    @Override
    protected void setReference() {
        utils.printLog(TAG,"Inside Reference");

        btn_Linear          =   (Button) findViewById(R.id.btn_Linear);
        btn_relative        =   (Button) findViewById(R.id.btn_relative);
        btn_Table           =   (Button) findViewById(R.id.btn_Table);
        btn_Frame           =   (Button) findViewById(R.id.btn_Frame);
        btn_Scroll          =   (Button) findViewById(R.id.btn_Scroll);
        btn_Custom          =   (Button) findViewById(R.id.btn_Custom);
        btn_dynamic         =   (Button) findViewById(R.id.btn_dynamic);
        btn_animation       =   (Button) findViewById(R.id.btn_animation);
        btn_Webview         =   (Button) findViewById(R.id.btn_Webview);
        btn_Radio           =   (Button) findViewById(R.id.btn_Radio);
        btn_Ninepatch       =   (Button) findViewById(R.id.btn_Ninepatch);
        btn_inherit         =   (Button) findViewById(R.id.btn_inherit);
        btn_logfile         =   (Button) findViewById(R.id.btn_logfile);
        btn_serailization   =   (Button) findViewById(R.id.btn_serailization);
        btn_fragment        =   (Button) findViewById(R.id.btn_fragment);
        btn_exception       =   (Button) findViewById(R.id.btn_exception);


        utils.printLog(TAG,"Outside Reference");
    }


    /**
     * set Listener of buttons
     */
    @Override
    protected void OnListener(){

        utils.printLog(TAG,"Outside Reference");

        btn_Linear.setOnClickListener(this);
        btn_relative.setOnClickListener(this);
        btn_Table.setOnClickListener(this);
        btn_Frame.setOnClickListener(this);
        btn_Scroll.setOnClickListener(this);
        btn_Custom.setOnClickListener(this);
        btn_dynamic.setOnClickListener(this);
        btn_animation.setOnClickListener(this);
        btn_Webview.setOnClickListener(this);
        btn_Radio.setOnClickListener(this);
        btn_Ninepatch.setOnClickListener(this);
        btn_inherit.setOnClickListener(this);
        btn_logfile.setOnClickListener(this);
        btn_serailization.setOnClickListener(this);
        btn_exception.setOnClickListener(this);
        btn_fragment.setOnClickListener(this);


        utils.printLog(TAG,"Outside Reference");
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_Linear:
                this.linearLayout();
                break;

            case R.id.btn_relative:
                this.relativeLayout();
                break;

            case R.id.btn_Table:
                this.tableLayout();
                break;

            case R.id.btn_Frame:
                this.frameLayout();
                break;

            case R.id.btn_Scroll:
                this.scrollbar();
                break;

            case R.id.btn_Custom:
                this.customTextView();
                break;

            case R.id.btn_dynamic:
                this.dynamicAddLinear();
                break;

            case R.id.btn_animation:
                this.animation();
                break;

            case R.id.btn_Webview:
                this.webView();
                break;

            case R.id.btn_Radio:
                this.radioButton();
                break;

            case R.id.btn_Ninepatch:
                this.ninePatch();
                break;

            case R.id.btn_inherit:
                this.inheritance();
                break;

            case R.id.btn_logfile:
                this.logFile();
                break;

            case R.id.btn_serailization:
                this.Serailizable();
                break;
            case R.id.btn_fragment:
                this.fragment();
                break;

            case R.id.btn_exception:
                this.exception();
                break;

            default:
                break;

        }

    }
    private void linearLayout() {
        startActivity(new Intent(Mainlayout.this,Linearlayout.class));
    }

    private void relativeLayout() {
        startActivity(new Intent(Mainlayout.this,Relativelayout.class));

    }

    private void tableLayout() {
        startActivity(new Intent(Mainlayout.this, Tablelayout.class));
    }

    private void frameLayout() {
        startActivity(new Intent(Mainlayout.this, framlayout.class));
    }

    private void scrollbar() {
        startActivity(new Intent(Mainlayout.this, Scrollview.class));
    }

    private void customTextView() {
        startActivity(new Intent(Mainlayout.this, Commonactivity.class));
    }

    private void dynamicAddLinear() {
        startActivity(new Intent(Mainlayout.this, DynamicView.class));
    }

    private void animation() {
        startActivity(new Intent(Mainlayout.this, SunAnimation.class));
    }

    private void webView() {
        startActivity(new Intent(Mainlayout.this, Webvieww.class));
    }

    private void radioButton() {
        startActivity(new Intent(Mainlayout.this, Radio_Button.class));
    }

    private void ninePatch() {
        startActivity(new Intent(Mainlayout.this, NInePatch.class));

    }

    private void inheritance() {
        startActivity(new Intent(Mainlayout.this, MainInheritance.class));
    }

    private void logFile() {
        startActivity(new Intent(Mainlayout.this, Logfile.class));
    }

    private void Serailizable() {
        startActivity(new Intent(Mainlayout.this, Serail_Main.class));
    }

    private void fragment() {
        startActivity(new Intent(Mainlayout.this, MainActivityyy.class));
    }

    private void exception() {
        startActivity(new Intent(Mainlayout.this, Activity_Exception.class));
    }



}
