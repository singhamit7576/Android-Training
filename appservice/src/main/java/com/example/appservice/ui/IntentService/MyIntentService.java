package com.example.appservice.ui.IntentService;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.example.appservice.R;

/**
 * create MyIntentService Class which
 * extends IntentService.
 */
public class MyIntentService extends IntentService {

    private  MediaPlayer mediaPlayer;

    public MyIntentService() {
        super(MyIntentService.class.getName());
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        mediaPlayer      =   MediaPlayer.create(getApplicationContext(), R.raw.humsafar);
        mediaPlayer.start();
        SystemClock.sleep(mediaPlayer.getDuration());

    }

    @Override
    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();

        }
      mediaPlayer.release();
        super.onDestroy();





    }

}
