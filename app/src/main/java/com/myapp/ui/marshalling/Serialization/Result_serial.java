package com.myapp.ui.marshalling.Serialization;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;

/**
 * Create an Login Activity which extends
 * abstract Base Class.
 */
public class Result_serial extends BaseActivity {
    private TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_serial);



    }

    private void action() {
        Student student         =   (Student)   getIntent().getSerializableExtra    ("KEY");

        txt_result.setText("NAME-  "+ student.getName()+"     "+ "Address- " +student.getAddress());
    }

    /**
     * set Reference of
     *  ,Textview.
     */
    @Override
    protected void setReference() {
        txt_result      =   (TextView)  findViewById(R.id.txt_result);

    }

    /**
     * get date from
     * activity and set into textview.
     */
    @Override
    protected void OnListener() {
        this.action();

    }
}
