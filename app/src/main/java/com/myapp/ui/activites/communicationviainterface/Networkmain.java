package com.myapp.ui.activites.communicationviainterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.user.myapp.R;
import com.myapp.ui.utils.utils;


/**
 * create Activity which extends
 * AppCompactActivity.
 */
public class Networkmain extends AppCompatActivity {

    private ProgressBar progressBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networkmain);

        utils.printLog("tag","Inside create");

        this.progressBar     =   (ProgressBar)   findViewById(R.id.prog);

        this.testCallback();

        utils.printLog("tag","Outside create");
    }


    /**
     * In this Method,
     * we create Object of NetworkOperation,
     * and perfrom progressbar.
     */
    private void testCallback() {

        utils.printLog("tag","testCallback");
        //  Log.e("TAG", " Time " + System.currentTimeMillis() + "");
        progressBar.setVisibility(View.VISIBLE);

        utils.printLog("tag","progressbarvisible");

        NetworkOperation networkOperation = new NetworkOperation(new InetwrokOperation() {
            @Override
            public void onOperationComplete(String result) {

                utils.printLog("tag","Inside Onoprtn");

                Log.e("TAG", " Time " + System.currentTimeMillis() + "");

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        utils.printLog("tag","Inside runonui");

                        progressBar.setVisibility(View.GONE);

                        utils.printLog("tag","outside runonui");
                    }
                });
            }
        });
        utils.printLog("tag","Outside Onoprtn");

        networkOperation.downloadImage();

        utils.printLog("tag","Object");

    }

}





