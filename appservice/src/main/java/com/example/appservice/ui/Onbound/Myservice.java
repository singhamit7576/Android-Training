package com.example.appservice.ui.Onbound;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.appservice.R;

/**
 * create class Myservice
 * which extends Service.
 */
public class Myservice extends Service implements MediaPlayer.OnCompletionListener {

    private MediaPlayer mediaPlayer;
    LocalBinder mBinder = new LocalBinder();

    class LocalBinder extends Binder{

        Myservice getService(){
            return Myservice.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }




    public void playMusic(){
        mediaPlayer      =   MediaPlayer.create(this, R.raw.humsafar);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("TAG", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("TAG", "onDestroy");
        mediaPlayer.stop();

        super.onDestroy();
    }


    public void stopmusic(){
        mediaPlayer.stop();
    }




//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        mediaPlayer.start();
////        if(mediaPlayer.isPlaying()){
////            mediaPlayer.pause();
////            Toast.makeText(Myservice.this, "PAUSED", Toast.LENGTH_SHORT).show();
////
////        } else {
////            mediaPlayer.start();
////            Toast.makeText(Myservice.this, "PLAY", Toast.LENGTH_SHORT).show();
////        }
//        return START_STICKY;
//    }



//    public void onstopmusic() {
//
//        mediaPlayer.stop();
//
////        if(mediaPlayer.isPlaying()) {
////            mediaPlayer.stop();
////            Toast.makeText(Myservice.this, "My Service Stopped", Toast.LENGTH_SHORT).show();
////        }
////        mediaPlayer.release();
//    }
//



    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();

    }




}
