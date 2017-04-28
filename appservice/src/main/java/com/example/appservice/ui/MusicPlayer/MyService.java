package com.example.appservice.ui.MusicPlayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.appservice.R;


/**
 * class which extends service and implments
 * MediaPlayer.OnCompletionListener
 */
public class MyService extends Service implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * create Mediaplayer
     */
    @Override
    public void onCreate() {
        Toast.makeText(MyService.this, "My Service Created", Toast.LENGTH_SHORT).show();

        mediaPlayer      =   MediaPlayer.create(this, R.raw.humsafar);
        mediaPlayer.setLooping(false);      //set palyer is reapeat or not.
        mediaPlayer.setOnCompletionListener(this);


    }

    /**
     * start the MediaPlayer.
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            Toast.makeText(MyService.this, "PAUSED", Toast.LENGTH_SHORT).show();

        } else {
            mediaPlayer.start();
            Toast.makeText(MyService.this, "PLAY", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }


    /**
     * stop the Media player.
     * release the Resources related
     * to the media player object.
     */
    @Override
    public void onDestroy() {

        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            Toast.makeText(MyService.this, "My Service Stopped", Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.release();
        super.onDestroy();
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();

    }
}
