package com.myapp.ui.intentt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 */
public class Intent_Third extends BaseActivity {

    private EditText et_name;
    private EditText et_email;

    /**
     * Activity created.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__third);
        this.setReference();
        this.OnListener();
    }

    @Override
    protected void setReference() {
        /*get the id of
        * name and email*/
        et_name          =      (EditText)findViewById(R.id.et_namee);
        et_email         =       (EditText)findViewById(R.id.et_emaill);
    }

    /**
     * get data from Intent.
     * set the data in name and email.
     */
    @Override
    protected void OnListener() {

        Bundle  bundle       =  getIntent().getExtras();
        String name          =  bundle.getString("NAME");
        String email         =  bundle.getString("EMAIL");

        et_name.setText("name :"+name);
        et_email.setText("email :"+email);
    }
}
