package com.myapp.ui.marshalling.Serialization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.marshalling.Parceable.Person;
import com.myapp.ui.marshalling.Parceable.Result_parse;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements OnClickListener Interface
 */
public class Serail_Main extends BaseActivity implements View.OnClickListener {

    private Button btn_pass;
    private Button btn_parce;
    private String TAG      =   this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serail__main);

        utils.printLog(TAG,"Inside Create()");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"Outside Create()");
    }

    /**
     *  /*Set reference of
     * buttons
     */
    @Override
    protected void setReference() {

        utils.printLog(TAG,"Inside setReference()");

        btn_pass        =   (Button)    findViewById(R.id.btn_pass);
        btn_parce       =   (Button)    findViewById(R.id.btn_parce);

        utils.printLog(TAG,"Outside setReference()");

    }


    /**
     *  /*Set Listener of
     * buttons
     */
    @Override
    protected void OnListener() {

        utils.printLog(TAG,"Inside OnListener()");

        btn_pass.setOnClickListener(this) ;
        btn_parce.setOnClickListener(this) ;

        utils.printLog(TAG,"Outside OnListener()");

    }



    @Override
    public void onClick(View v) {

        utils.printLog(TAG,"Inside OnClick()");

        switch (    v.getId()   ) {

            case R.id.btn_pass: {
                this.OnclickSerial();//call OnclickSerial method.
                break;
            }

            case R.id.btn_parce: {
                this.OnClickParceable();
            }
            default:
                break;
        }
        utils.printLog(TAG,"Outside OnClick()");

    }

    private void OnclickSerial() {

        utils.printLog(TAG,"Inside Serial()");

        Intent intent   =   new Intent  (Serail_Main.this, Result_serial.class);//go to Result_serial Activity
        intent.putExtras(this.getBundle()); //call get Bundle method
        startActivity(intent);

        utils.printLog(TAG,"Outside serial()");
    }


    /**
     * return Bundle
     * @return
     */
    private Bundle getBundle(){

        Bundle bundle   =    new Bundle();
        bundle.putSerializable("KEY", this.getStudent());
        return bundle;
    }

    /**
     * return claas Object.
     * @return
     */
    private Student getStudent(){

        Student student  =  new Student();
        student.setName("Ankit");
        student.setAddress("Mumbai");
        return student;
    }

    private void OnClickParceable() {

        utils.printLog(TAG,"Inside parceable()");

        Intent mIntent   =  new Intent  (Serail_Main.this, Result_parse.class);//go to Result_parse Activity
        mIntent.putExtras   (this.getBundleObject());//call get Bundle method
        startActivity(mIntent);

        utils.printLog(TAG,"Outside parceable()");
    }

    /**
     * return Bundle
     * @return
     */
    private Bundle getBundleObject(){

        Bundle bundle   =    new Bundle();
        bundle.putParcelable("KEY",this.getObjectPerson());
        return bundle;
    }

    /**
     * return claas Object.
     * @return
     */
    private Person getObjectPerson() {

        Person person    =   new Person();
        person.setName("Ankitt");
        person.setAge(25);
        return person;

    }





}
