package com.example.broadcast_reciver.ui.DynamicBroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcast_reciver.R;
import com.example.broadcast_reciver.ui.BaseAcitvityy.BaseAcitivity;

/**
 * create  Dynamic_Brodcast_Receiver which extends  my own Abstract class
 * which have some abstract methods.
 */
public class Dynamic_Brodcast_Receiver extends BaseAcitivity implements View.OnClickListener {

    MyDynamicReceiver receiver;
    private Button dynamic_btn;
    IntentFilter intentFilter;
    Intent mIntent;



    /**
     * oncreate Override method.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic__brodcast__receiver);
        this.set();
        this.setReference();
        this.onListener();
    }


    /**
     * create object of MyDynamicReceiver
     * class and set intent-filter.
     */
    private void set() {
        receiver        =        new MyDynamicReceiver();
        intentFilter    =        new IntentFilter("My_Action");

    }

    /**
     * set Reference of
     * of Button.
     */
    @Override
    protected void setReference() {

        dynamic_btn     =    (Button)    findViewById(R.id.dynamic_btn);
    }


    /**
     * set Listener of
     * of Button.
     */
    @Override
    protected void onListener() {

        dynamic_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.dynamicBrodcast();

    }

    /**
     * method which perform on button click.
     * use put Extra for add extended data with
     * intent.id as KEY
     */
    private void dynamicBrodcast() {
        mIntent     =   new Intent("My_Action");
        mIntent.putExtra("KEY", "dynamicBroadcast");
        sendBroadcast(mIntent);


    }


    /**
     * override method onResume ()
     * in which we register the receiver
     */
    @Override
    protected void onResume() {

        super.onResume();
        registerReceiver(receiver,intentFilter);

    }


    /**
     * override method onPause ()
     * in which we unregister the receiver
     */
    @Override
    protected void onPause() {

        super.onPause();
        unregisterReceiver(receiver);


    }
}
