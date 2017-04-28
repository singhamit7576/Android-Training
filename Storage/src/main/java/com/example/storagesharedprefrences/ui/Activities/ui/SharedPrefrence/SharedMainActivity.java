package com.example.storagesharedprefrences.ui.Activities.ui.SharedPrefrence;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SharedMainActivity extends BaseActivity implements View.OnClickListener {


    private TextView tv_retriveName,tv_address;
    private Button btn_retrive;
    SharedPreferences.Editor editor;
    public static final String PREFS = "KEY";
    UserDetails user = new UserDetails();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_main_acitvity);
        this.setReferences();
        this.saveSharedPreferences();
        this.onListener();
    }


    @Override
    protected void setReferences() {

        tv_retriveName          =   (TextView)     findViewById(R.id.tv_retriveName);
        tv_address              =   (TextView)     findViewById(R.id.tv_address);
        btn_retrive             =   (Button)       findViewById(R.id.btn_retrive);

    }


    private void saveSharedPreferences() {

        Gson gson                        =   new Gson();
        SharedPreferences preferences    =   getSharedPreferences(PREFS,MODE_PRIVATE);
        editor                           =   preferences.edit();
        user.setName("Ram");
        user.setAddress("Delhi");
        String value                     =   gson.toJson(user);
        editor.putString("user",value);
        editor.commit();
    }


    @Override
    protected void onListener() {
        btn_retrive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.getSharedPreference();
    }


    private void getSharedPreference() {

        SharedPreferences sharedPreferences         =   getSharedPreferences(PREFS,MODE_PRIVATE);
        String data                                 =   sharedPreferences.getString("user","");
        Gson gson                                   =   new Gson();
        user                                        =   gson.fromJson(data,UserDetails.class);

        String name     =      "NAME:"+ user.getName();
        String address  =      "ADDRESS:" +user.getAddress();
        tv_retriveName.setText(name);
        tv_address.setText(address);
    }
}
