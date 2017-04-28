package com.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thread.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        this.action();
    }

    private void action() {

        MyThread  t1 = new MyThread("Thread 1");
        MyThread  t2 = new MyThread("Thread 2");
        t1.setName("thread-1");
        t2.setName("thread-2");
        t1.start();
        try{
            t1.join(5000);	//Waiting for t1 to finish
        }catch(InterruptedException ie){}
        t2.start();
    }
}
