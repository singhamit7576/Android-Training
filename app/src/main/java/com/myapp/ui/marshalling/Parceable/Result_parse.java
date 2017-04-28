package com.myapp.ui.marshalling.Parceable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.marshalling.Serialization.Student;
/**
 * Create an Login Activity which extends
 * abstract Base Class.
 */
public class Result_parse extends BaseActivity {

    private TextView prs_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_parse);
        this.setReference();
        this.OnListener();
    }

    /**
     * set Reference of
     *  ,Textview.
     */
    @Override
    protected void setReference() {
        prs_result  =   (TextView) findViewById(R.id.prs_result);

    }

    /**
     * get date from
     * activity and set into textview.
     */
    @Override
    protected void OnListener() {

        Person person       =   (Person)    getIntent().getParcelableExtra("KEY");

        prs_result.setText( "NAME-  "+  person.getName()+"        "+ "Age- "    +person.getAge());

    }
}
