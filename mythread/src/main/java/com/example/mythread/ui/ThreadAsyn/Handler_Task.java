package com.example.mythread.ui.ThreadAsyn;

import android.os.Handler;
import android.os.Looper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;
import com.example.mythread.ui.BaseAcitivity.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * create Activity Which extends Our Abstract class
 * which have some abstract method.
 * and Implements OnClickListener interface.
 */
public class Handler_Task extends BaseActivity implements View.OnClickListener {


    private Button btn_Asyn;
    private String DATA_URL = "http://api.letsleapahead.com/LeapAheadMultiFreindzy/index.php?action=getLang&langCode=EN&langId=1&appId=6";
    private TextView tv_timer;
    private String TAG = this.getClass().getSimpleName();

    /**
     * create Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler__task);

        this.setReference();
        this.onListener();
    }

    /**
     * setReference od Button and\
     * TextView.
     */
    @Override
    protected void setReference() {

        Utils.printLog(TAG,"Inside setReference ");

        btn_Asyn         =   (Button)     findViewById(R.id.btn_Asyn);
        tv_timer          =   (TextView)   findViewById(R.id.tv_timer);

        Utils.printLog(TAG,"Outside setReference ");
    }


    /**
     * setListener of Button
     */
    @Override
    protected void onListener() {
        Utils.printLog(TAG,"Inside onListener ");

        btn_Asyn.setOnClickListener(this);

        Utils.printLog(TAG,"outside onListener ");
    }


    /**
     * Override On click()
     * @param v
     */
    @Override
    public void onClick(View v) {

        Utils.printLog(TAG,"Inside onClick ");

        this.startThread();

        Utils.printLog(TAG,"outside onClick ");
    }




    /**
     * Override method to perform background compution.
     * start thread
     * *
     * BufferReader read text from character Input stream.
     * and Open connection to this url.

     */

    private void startThread() {
        Utils.printLog(TAG,"Inside Thread ");


        new Thread(){

            @Override
            public void run() {
                String InputLine             = null;
                StringBuilder stringBuilder  = new StringBuilder();

                try {

                    URL url     =   new URL(DATA_URL);
                    BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));


                    while ((    InputLine     =    mBufferedReader.readLine()   )!= null    ){
                        stringBuilder.append(InputLine);
                    }

                    handlerThread(String.valueOf(stringBuilder));
                    mBufferedReader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }.start();
        Utils.printLog(TAG,"Outside Thread ");
    }


    /**
     * set the Result into
     * Text View
     * @param value
     */
    private void handlerThread(final String value) {

        Utils.printLog(TAG,"Inside handlerThread ");

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                tv_timer.setText (value);
            }
        });

        Utils.printLog(TAG,"Outside handlerThread ");



    }


}
