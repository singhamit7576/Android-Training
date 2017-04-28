package com.myapp.ui.intentt;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements List_Fragmentt.Communication  Interface
 */
public class  MainActivity extends BaseActivity implements View.OnClickListener{         //extends Abstract class BaseActivity.

    final int REQUEST_CODE=1001;                                                     // make request code as constant.
    private Button button,btnlog,button22;
    private int value;
    private String msg,name,email;
    private EditText txt1,txt2,et_email,et_name;
    private String TAG = this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {                            //create Activity from here
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utils.printLog(TAG,"Inside Create");

        setReference();
        OnListener();

        utils.printLog(TAG,"Outside Create");
    }

    /* Called when the activity is about to become visible. */
    @Override
    protected void onStart() {

        super.onStart();
        Log.d(TAG, "The onStart() event");
    }

    /* Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "The onResume() event");
    }

    /* Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "The onPause() event");
    }

    /* Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "The onStop() event");
    }

    /* Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "The onDestroy() event");
    }


    /*setReference of
       * widgets*/
    @Override
    protected void setReference() {

        utils.printLog(TAG,"Inside setReference");

        txt1         =  (EditText)  findViewById(R.id.txt1);
        txt2         =  (EditText)  findViewById(R.id.txt2);
        button       =  (Button)    findViewById(R.id.button);
        button22     =  (Button)    findViewById(R.id.button22);
        btnlog       =  (Button)    findViewById(R.id.btnlog);
        et_name      =  (EditText)  findViewById(R.id.et_name);
        et_email     =  (EditText)  findViewById(R.id.et_email);

        utils.printLog(TAG,"Outside setReference");
    }


    /**
     *  perform OnClickListner Event ,
     *  when u click Button .
     */
    @Override
    protected void OnListener() {

        utils.printLog(TAG,"Inside OnListener");

        button.setOnClickListener(this);
        button22.setOnClickListener(this);
        btnlog.setOnClickListener(this);

        utils.printLog(TAG,"Inside OnListener");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
                this.intentActivity();
                break;

            case R.id.button22:
                this.passDataBundle();
                break;

            case R.id.btnlog:
                this.logUse();
                break;


            default:
                break;
        }
    }

    private void intentActivity(){

        Log.i(TAG,"Start Intent Activity");

        String message   =      txt1.getText().toString();                /*get the message  from EditText which is input by user.*/
        Intent intent    =       new Intent(MainActivity.this, Two.class);//create intent object to pass message from one activity to another activity

        intent.putExtra("MESSAGE",message);                        //use putExtra to send Your message to another Activity with Key
        if (!message.equals("")) {
            startActivityForResult(intent, REQUEST_CODE);
        }
        else {
            Toast.makeText(MainActivity.this, "plz enter the number", Toast.LENGTH_SHORT).show();
        }
    }

    private void passDataBundle() {

        Intent mIntent   =  new Intent(MainActivity.this, Intent_Third.class);
        mIntent.putExtras(this.getbundle());

        if(name.equals("")&&email.equals("")){
            Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();

        }else {
            startActivity(mIntent);
        }
    }

    private Bundle getbundle(){
        name           =   et_name.getText().toString();
        email          =   et_email.getText().toString();

        Bundle b=new Bundle();
        b.putString("NAME", name);
        b.putString("EMAIL", email);
        return b;
    }


    private void logUse() {

        Log.v(TAG,"start Log");

        msg           =   txt1.getText().toString();

        if(!msg.equals("")) {
            value    = Integer.parseInt(msg);
            try {
                value    =  value / 0;
            } catch (Exception e) {
                Log.e(TAG, "ERROR");
            }
        }
        else{
            Toast.makeText(MainActivity.this, "plz enter number", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {          //method for getting data from second activity ont to fisrt activity

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode   ==  RESULT_OK ) {

            if (requestCode      ==     REQUEST_CODE)  {

                String result       = data.getStringExtra("MESSAGE");
                txt2.setText(result);                                           //set data in EditText which got from second screen.
            }
        }

    }
}
