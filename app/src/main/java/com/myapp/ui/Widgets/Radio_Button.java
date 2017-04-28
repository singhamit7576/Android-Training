package com.myapp.ui.Widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;


/**
 * create Acitvity which
 * extends abstract class.
 */
public class Radio_Button extends BaseActivity implements View.OnClickListener {

    private Button button;
    private RadioGroup rdgroup;
    private int id;
    private RadioButton rdbtn;
    private String TAG=this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio__button);
        utils.printLog(TAG,"inside");
        this.setReference();
        this.OnListener();
        utils.printLog(TAG,"outside");
    }

    @Override
    protected void setReference() {
        button      =   (Button)        findViewById(R.id.btn);
        rdgroup     =   (RadioGroup)    findViewById(R.id.rdgroup);
    }

    @Override
    protected void OnListener() {

        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        {

            id   =  rdgroup.getCheckedRadioButtonId();

            if (id > 0) {

                rdbtn   =   (RadioButton) findViewById(id);

                Toast.makeText(Radio_Button.this, rdbtn.getText().toString(), Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(Radio_Button.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }
        }
    }





}
