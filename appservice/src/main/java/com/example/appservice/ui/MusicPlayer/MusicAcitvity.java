package com.example.appservice.ui.MusicPlayer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appservice.R;
import com.example.appservice.ui.baseActivity.BaseActivity;


/**
 * Activity Which extends my
 * BaseACitvity and Implemnets OnclickListener Interface.
 */
public class MusicAcitvity extends BaseActivity implements View.OnClickListener {


    private ImageButton btn_play;
    private ImageButton btn_stop;
     boolean flag = true;

    /**
     * Activity Created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_acitvity);
        this.setReference();
        this.onListener();
    }


    /**
     * setReference of
     *  ImageViewButton
     */
    @Override
    protected void setReference() {
        btn_play         =  (ImageButton)   findViewById(R.id.btn_play);
        btn_stop         =  (ImageButton)   findViewById(R.id.btn_stop);

    }

    /**
     * set  Listener
     * of ImageButtons
     */
    @Override
    protected void onListener() {

        btn_play.setOnClickListener(this);
        btn_stop.setOnClickListener(this);

    }


    /**
     * Override method on click().
     * In which user can
     * play and stop the music
     * @param v
     */
    @Override
    public void onClick(View v) {

        final  Intent mIntent =  new Intent(this,MyService.class);

        switch (v.getId()){

            case R.id.btn_play:

                Log.d("TAG","onclick");
                // this.playMusic(mIntent);      this is for original thread and change button image after click.

                Thread thread = new Thread(){

                    @Override
                    public void run() {
                        startService( mIntent);
                    }
                };
                thread.start();
                break;

            case R.id.btn_stop:

                Toast.makeText(MusicAcitvity.this, "Stopped", Toast.LENGTH_SHORT).show();
                this.stopMusic(mIntent);
                break;

            default:
                break;


        }

    }

    /**
     *play the music.
     * Initially set flag -true.
     *
     * @param mIntent
     */
    private void playMusic(Intent mIntent) {

        startService( mIntent);


//        if(flag){
//            btn_play.setImageResource(R.drawable.pausebtn);
//            startService(mIntent);
//            flag = false;
//
//        } else{
//            btn_play.setImageResource(R.drawable.playit);
//            startService(mIntent);
//            flag = true;
//        }
    }




    /**
     * stop the muzic.
     * @param mIntent
     */
    private void stopMusic(Intent mIntent) {
        stopService(mIntent);


/**
 * this flag for image change .,when
 * use original thread.
 */
//
//        if(!flag){
//            Toast.makeText(MusicAcitvity.this, "if", Toast.LENGTH_SHORT).show();
//            btn_play.setImageResource(R.drawable.playit);
//            stopService(mIntent);
//            flag= true;
//
//        }

    }


}
