package com.example.broadcast_reciver.ui.StaticReciver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 *created class which extends
 * BroadcastReceiver;
 */
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String data         =  intent.getStringExtra("Key");
        Toast.makeText(context, "Action:"+intent.getAction()+"  "+data, Toast.LENGTH_SHORT).show();
    }







}
