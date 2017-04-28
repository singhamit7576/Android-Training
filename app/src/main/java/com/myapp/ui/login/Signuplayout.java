package com.myapp.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;


/**
 * create Signup activity
 * which extends Base class
 */
public class Signuplayout extends BaseActivity {

    private EditText edittxt_name;
    private EditText edtxt_email;
    private EditText ed_txt_password;
    private EditText et_confirm_password;
    private Switch mswitch;
    private TextView txtmale;
    private TextView txtfemale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuplayout);
        this.setReference();
        this.OnListener();
    }


    /**
     * set Refernces of edit text ,
     * textview
     */
    @Override
    protected void setReference() {
        edittxt_name                =   (EditText)  findViewById(R.id.edittxt_name);
        edtxt_email                 =   (EditText)  findViewById(R.id.edtxt_email);
        ed_txt_password             =   (EditText)  findViewById(R.id.ed_txt_password);
        et_confirm_password         =   (EditText)  findViewById(R.id.et_confirm_password);
        mswitch                     =   (Switch)    findViewById(R.id.mswitch);
        txtmale                     =   (TextView)  findViewById(R.id.textmale);
        txtfemale                   =   (TextView)  findViewById(R.id.txtfemale);

    }

    /**
     * set Listner of swtich ,
     * which change the color when user
     * hit the switch.
     */
    @Override
    protected void OnListener() {


        mswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    txtmale.setTextColor(Color.RED);
                    txtfemale.setTextColor(Color.BLUE);
                }
                else
                {
                    txtmale.setTextColor(Color.BLUE);
                    txtfemale.setTextColor(Color.RED);
                }
            }
        });

    }
}
