package com.example.dialog.ui.Custom_Dailog;

import android.app.Activity;
import android.app.Dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.example.dialog.Main.MainActivity;
import com.example.dialog.R;

/**
 * create Custom Dailog which
 * extends Dialog/
 */
public class CustomDailog extends Dialog implements View.OnClickListener {

    private  Activity activity;
    private TextView tv_data;
    private Button btn_ok,btn_cancel;


    /**
     *create Constructor
     */
    public CustomDailog(Activity activity) {
        super(activity);
        this.activity=activity;
    }


    /**
     *set out custom layout in
     * setContentView.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        Dialog dialog = new Dialog(activity);
        setContentView(R.layout.custom_dialog);
        this.setReference();
        this.onListener();

    }


    /**
     * set References of
     * editText,buttons.
     */
    private void setReference() {
        tv_data         =   (TextView) findViewById(R.id.tv_data);
        btn_ok          =   (Button) findViewById(R.id.btn_ok);
        btn_cancel        =   (Button)  findViewById(R.id.btn_cancel);
        this.setText();
    }


    /**
     *  set the text in EditText
     *  and Buttons.
     */
    private void setText() {
        tv_data.setText(R.string.do_you_want_exit);
        btn_ok.setText(R.string.ok);
        btn_cancel.setText(R.string.Cancel);
    }


    /**
     *  set Listner
     *  on buttons
     */
    private void onListener() {

        btn_ok.setOnClickListener(this);

        btn_cancel.setOnClickListener(this);

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    /**
     *action performed on button click.
     */
    @Override
    public void onClick(View v) {
        Log.d("tag","inside onclick");

        switch (v.getId()){

            case R.id.btn_ok :
                activity.finish();
                break;

            case R.id.btn_cancel :
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }

}
