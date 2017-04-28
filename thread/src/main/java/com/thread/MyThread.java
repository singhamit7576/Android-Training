package com.thread;

import com.BaseClass.utils;

/**
 * Created by user on 15/3/17.
 */
public class MyThread extends Thread {
    String str;
    private String TAG = this.getClass().getSimpleName();
    public MyThread(String str) {
        this.str = str;
    }

    public void run() {
      //  utils.printLog(TAG,"name"+this.currentThread().getName());

        for (int i = 0; i < 10; i++) {

            try {
                utils.printLog(TAG,"Going to sleep"+currentThread().getName());
                Thread.sleep(2000);
                utils.printLog(TAG,"wake from sleep"+currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

          utils.printLog(TAG,""+currentThread().getName());


        }
    }
}
