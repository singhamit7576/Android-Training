package com.example.mythread.ui.Thread;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

public class TimerAcitivity extends BaseActivity {

    private TextView tv_thread;

    private final int length = 10;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_acitivity);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        tv_thread   =    (TextView) findViewById(R.id.tv_thread);
        progressBar   =    (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    protected void onListener() {
        startThread();
    }


    private void startThread() {

        new Thread(){
            @Override
            public void run() {
                try {

                    for (int i = 0; i <= length; i++) {
                        Thread.sleep(1000);
                        updateUi(i);
                        progressBar.setProgress(i);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }.start();

    }


    private void updateUi(final int value) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                tv_thread.setText(""+value);

            }
        });


    }


}
