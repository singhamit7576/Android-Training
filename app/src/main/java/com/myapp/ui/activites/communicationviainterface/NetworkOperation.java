package com.myapp.ui.activites.communicationviainterface;

import com.myapp.ui.utils.utils;

/**
 * create class
 * which create callback instance of interface
 * for communication.
 */
public class NetworkOperation {

    private InetwrokOperation callback = null;


    /**
     * create Constructor of this class And
     * pass interface as Parameter.
     */
    public  NetworkOperation(InetwrokOperation callback){
        this.callback = callback;
    }



    public void downloadImage(){

        utils.printLog("tag","download");

        new Thread(new Runnable() {
            @Override
            public void run() {
                utils.printLog("tag","inside normal threadd");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                utils.printLog("tag","outside normal threadd");
                callback.onOperationComplete("Image Downloaded");
            }

        }).start();
        utils.printLog("tag","outsidedownload");
    }




}
