package com.example.appservice.ui.Onbound;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appservice.R;
import com.example.appservice.ui.baseActivity.BaseActivity;

/**
 * create an Activity which extends
 * my abstract class which have som abstract methods.
 * Which Implements View.OnClickListener.
 */
public class BinderActivity extends BaseActivity implements View.OnClickListener{

    private Button play_btn,stop_btn;
    boolean isServiceBinder=false;
    private  Intent mIntent;
    Myservice myservice=null;


    /**
     * Activity created from here.
     * and call two Methods of base Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binder);
        this.setReference();
        this.onListener();
    }


    /**
     * Method in which ,we set Reference of
     * Buttons.
     */
    @Override
    protected void setReference() {
        play_btn     =  (Button)    findViewById(R.id.play_btn);
        stop_btn     =  (Button)    findViewById(R.id.stop_btn);
    }


    /**
     *  Method in which ,we set Listener of
     * Buttons.
     */
    @Override
    protected void onListener() {

        play_btn.setOnClickListener(this);
        play_btn.setEnabled(false);
        stop_btn.setOnClickListener(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        mIntent = new Intent(this, Myservice.class);
        //   bindService(mIntent, mServiceConnection, Context.BIND_AUTO_CREATE);


        Thread mThread = new Thread(){
            @Override
            public void run() {

                bindService(mIntent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        };
        mThread.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isServiceBinder){
            isServiceBinder=false;
        }
        unbindService(mServiceConnection);

        //   stopService(mIntent);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.play_btn:
                this.startSong();
                break;


            case R.id.stop_btn:
                this.stopSong();
                break;
        }

    }

    private void startSong() {
        if(isServiceBinder){

            Toast.makeText(BinderActivity.this, "Song Is playing", Toast.LENGTH_SHORT).show();
        }
        else
        {
            myservice.playMusic();
            play_btn.setEnabled(false);
            stop_btn.setEnabled(true);
            isServiceBinder=true;


        }
    }

    private void stopSong() {


        if (isServiceBinder) {
            myservice.stopmusic();
            play_btn.setEnabled(true);
            stop_btn.setEnabled(false);
            isServiceBinder = false;
        }

    }



    private ServiceConnection mServiceConnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Myservice.LocalBinder localBinder    =  (Myservice.LocalBinder)service;
            myservice                            =   localBinder.getService();
            myservice.playMusic();
            isServiceBinder= true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isServiceBinder= false;

        }
    };
}
