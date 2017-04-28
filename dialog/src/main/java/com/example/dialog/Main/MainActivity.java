package com.example.dialog.Main;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.dialog.BaseActivity.BaseActivity;
import com.example.dialog.R;
import com.example.dialog.ui.AlertDaiolog.Alert_Dailog;
import com.example.dialog.ui.Custom_Dailog.CustomDailog;
import com.example.dialog.ui.DailogFragment.MyDialogActivity;
import com.example.dialog.ui.Datepicker.DatePicker;


/**
 *  create MainActivity which extends my
 *  BaseActivity.
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_alertDailog;
    private Button btn_custom,btn_progressbar;
    private Button btn_DatePicker,btn_DailogFragment;
    private ProgressDialog progressDialog;
    boolean clicked ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();
        this.onListener();
    }


    /**
     * set Refrence of
     * buttons
     */
    @Override
    protected void setReference() {

        btn_alertDailog          = (Button) findViewById(R.id.btn_alertDailog);
        btn_custom               = (Button) findViewById(R.id.btn_custom);
        btn_DatePicker           = (Button) findViewById(R.id.btn_DatePicker);
        btn_progressbar          = (Button) findViewById(R.id.btn_progressbar);
        btn_DailogFragment       = (Button) findViewById(R.id.btn_DailogFragment);

    }


    /**
     * set Listener of
     * Buttons
     */
    @Override
    protected void onListener() {
        btn_alertDailog.setOnClickListener(this );
        btn_custom.setOnClickListener(this );
        btn_DatePicker.setOnClickListener(this );
        btn_progressbar.setOnClickListener(this);
        btn_DailogFragment.setOnClickListener(this );
    }


    /**
     * event perform on buttons
     * click
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_alertDailog:
                this.alertDailog();

                break;

            case R.id.btn_custom:
                this.CustomDailog();
                break;

            case R.id.btn_DatePicker:
                this.DatePicker();
                break;

            case R.id.btn_progressbar:
                this.progersBar();
                break;

            case R.id.btn_DailogFragment:
                startActivity(new Intent(MainActivity.this, MyDialogActivity.class));
                break;

            default:
                break;


        }
    }


    /**
     * go to Alert_Dailog Activity
     */

    private void alertDailog() {
        startActivity(new Intent(MainActivity.this,Alert_Dailog.class));
    }



    /**
     *create class object
     * and show our custom
     * layout.
     */
    private void CustomDailog() {
        CustomDailog customdailog  =  new CustomDailog(this);
        customdailog.setTitle(R.string.title);
        customdailog.show();
    }




    /**
     * Go To
     * DatePicker Activity.
     */
    private void DatePicker() {
        startActivity(new Intent(MainActivity.this,DatePicker.class));
    }




    /**
     * this.Method
     * set Progress Dailog
     * and
     */
    private void progersBar() {

        this.progressTitle();
        this.cancelButton();
        progressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int currentTime = progressDialog.getProgress();
                try{
                    while(currentTime <= progressDialog.getMax()){
                        if(clicked) {
                            clicked = false;
                            break;
                        }
                        Thread.sleep(100);
                        currentTime += 1;
                        progressDialog.setProgress(currentTime);
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }
                if(progressDialog.getProgress() == progressDialog.getMax()){
                    progressDialog.dismiss();
                }

            }


//            @Override
//            public void run() {
//                try{
//                    Thread.sleep(5000);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//                progressDialog.dismiss();
//
//            }
        }).start();


    }


    /**
     * In This Method ,we Set The
     * Progress Dialog Message And
     * Title.
     */
    private void progressTitle() {
        progressDialog    =         new ProgressDialog(MainActivity.this);
        progressDialog.setTitle ("Downloading ...");
        progressDialog.setMessage   ("Download in progress ...");
        progressDialog.setProgressStyle (progressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable    (false);
        progressDialog.setMax   (100);
        progressDialog.setProgress  (0);
    }



    /**
     * In this method,
     * you can Cancel Your
     * Progress Dailog .
     */
    private void cancelButton() {

        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clicked     =   true;
                progressDialog.dismiss();
            }
        });
    }



}
