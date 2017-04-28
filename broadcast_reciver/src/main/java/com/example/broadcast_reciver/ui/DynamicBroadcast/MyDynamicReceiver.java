package com.example.broadcast_reciver.ui.DynamicBroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * created class which extends
 * BroadcastReceiver;
 */
public class MyDynamicReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

         String  data =  intent.getStringExtra("KEY");

        Toast.makeText(context, ""+intent.getAction()+"    "+"DATA IS-"+"   "+data, Toast.LENGTH_SHORT).show();

    }
}
