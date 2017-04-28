package com.example.mythread.ui.ThreadAsyn;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
public class MyAsynTask  extends BaseActivity implements View.OnClickListener  {


    private Button btn_Asyn;
    private String DATA_URL = "http://api.letsleapahead.com/LeapAheadMultiFreindzy/index.php?action=getLang&langCode=EN&langId=1&appId=6";
    private ProgressDialog mProgressDialog;
    private TextView tv_data;
    private String TAG = this.getClass().getSimpleName();


    /**
     * create Activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_asyn_task);
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
        tv_data          =   (TextView)   findViewById(R.id.tv_data);

        Utils.printLog(TAG,"Outside setReference ");
    }


    /**
     * setListener od Button
     */
    @Override
    protected void onListener() {

        Utils.printLog(TAG,"Inside onListener ");

        btn_Asyn.setOnClickListener(this);

        Utils.printLog(TAG,"Outside onListener ");

    }


    /**
     * override method.
     * @param v
     *  create Object of DownloadImage Class.
     * and Exceute .
     */
    @Override
    public void onClick(View v) {
        DownloadImage downloadImage =    new DownloadImage();
        downloadImage.execute();
    }


    /**
     * craete Class Download Image Which Extends AsynTAsk
     * which enable proeper And easy use of UI thread.
     */
    private class DownloadImage extends AsyncTask<String, String, String> {


        /**
         * runs On ui thread before doIn background().
         * create Progress Dialog which
         * shows Message .
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Utils.printLog(TAG,"Inside onPreExecute ");

            mProgressDialog     =   new ProgressDialog(MyAsynTask.this);
            mProgressDialog.setTitle("Loading Data");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();

            Utils.printLog(TAG,"outside onPreExecute ");
        }


        /**
         * Override method to perform background compution.
         * @param URL
         * @return
         */

        @Override
        protected String doInBackground(String... URL) {

            String InputLine             = null;
            StringBuilder stringBuilder  = new StringBuilder();         //A Mutable sequence of character. with initial Capcity 16

            try {

                URL url = new URL(DATA_URL);//points to the Resource On world wide web.
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                /**
                 * read text from character Input stream.
                 * and Open connection to this url.
                 */


                while ((    InputLine = in.readLine()   )!= null    ){
                    stringBuilder.append(InputLine);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return String.valueOf(stringBuilder);
        }


        /**
         * set the Result into
         * Text View
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {


            Utils.printLog(TAG,"Inside onPostExecute ");

            tv_data.setText(result);
            mProgressDialog.dismiss();

            Utils.printLog(TAG,"Outside onPostExecute ");
        }
    }


}
