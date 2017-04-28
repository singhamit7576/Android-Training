package com.example.broadcast_reciver.ui.StaticReciver;

import android.content.Intent;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.broadcast_reciver.R;
import com.example.broadcast_reciver.ui.BaseAcitvityy.BaseAcitivity;

/**
 * create  MainActivity which extends  my own Abstract class
 * which have some abstract methods.
 */
public class MainActivity extends BaseAcitivity implements View.OnClickListener {

    private Button static_btn;

    /**
     * oncreate Override method.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();
        this.onListener();

    }


    /**
     * set Reference of
     * of Button.
     */
    @Override
    protected void setReference() {

        static_btn    =   (Button)  findViewById(R.id.static_btn);


    }


    /**
     * set Listener of
     * of Button.
     */
    @Override
    protected void onListener() {
        static_btn.setOnClickListener(this);

    }


    /**
     * action perform
     * on button click.
     * @param v
     */
    @Override
    public void onClick(View v) {
        this.staticBroadcastReceiver();

    }

    /**
     *  method which called  on button click.
     * use put Extra for add extended data with
     * intent.id as KEY
     */

    private void staticBroadcastReceiver() {

        Intent   mIntent  =   new Intent  ("My_Custom_Action");

        //  mIntent.setAction("My_Custom_Action");
        mIntent.putExtra("Key","Boradcast_Receiver");
        sendBroadcast(mIntent);



    }

}


