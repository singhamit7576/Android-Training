package com.myapp.ui.login;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.Widgets.Webvieww;
import com.myapp.ui.activites.Base.BaseActivity;

/**
 * Create an Login Activity which extends
 * abstract Base Class.
 */
public class Loginlayout extends BaseActivity implements View.OnClickListener {

    EditText et_email, et_password;
    TextView tv_forgetPassword;
    Button btnlogin, btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginlayout);
        this.setReference();
        this.OnListener();
    }


    /**
     * set Reference of
     * EditText ,Textview.
     */
    @Override
    protected void setReference() {
        et_email                =   (EditText)  findViewById(R.id.et_email);
        et_password             =   (EditText)  findViewById(R.id.et_password);
        tv_forgetPassword       =   (TextView)  findViewById(R.id.tv_forgetPassword);
        btnlogin                =   (Button)    findViewById(R.id.btnlogin);
        btnsignup               =   (Button)    findViewById(R.id.btnsignup);

    }

    /**
     * setListener
     * of Buttons
     */
    @Override
    protected void OnListener() {
        btnlogin.setOnClickListener(this);
        btnsignup.setOnClickListener(this);
    }


    /**
     * get The id of each Buttons
     * and perform action.
     * @param v
     */
    public void onClick(View v){
        switch(v.getId()){

            case R.id.btnlogin:
                startActivity(new Intent(this,Webvieww.class));
                break;

            case R.id.btnsignup:
                startActivity(new Intent(this,Signuplayout.class));
                break;

            default:
                break;
        }

    }

}



