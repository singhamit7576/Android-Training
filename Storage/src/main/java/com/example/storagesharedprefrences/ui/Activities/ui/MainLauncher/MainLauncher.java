package com.example.storagesharedprefrences.ui.Activities.ui.MainLauncher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;
import com.example.storagesharedprefrences.ui.Activities.ui.InternalAndExternalStorage.InternalStorage;
import com.example.storagesharedprefrences.ui.Activities.ui.SharedPreferenceArraylist.ArrayListActivity;
import com.example.storagesharedprefrences.ui.Activities.ui.SharedPrefrence.SharedMainActivity;
import com.example.storagesharedprefrences.ui.Activities.ui.listSharedPrefrences.ListActivity;

public class MainLauncher extends BaseActivity implements View.OnClickListener {

    private Button btn_SharedObject,btn_listShared,btn_Arraylist;
    private Button btn_datastorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);
        this.setReferences();
        this.onListener();
    }


    @Override
    protected void setReferences() {


        btn_SharedObject       =  (Button)   findViewById(R.id.btn_SharedObject);
        btn_listShared         =  (Button)   findViewById(R.id.btn_listShared);
        btn_Arraylist          =  (Button)   findViewById(R.id.btn_Arraylist);
        btn_datastorage        =  (Button)   findViewById(R.id.btn_datastorage);

    }



    @Override
    protected void onListener() {

        btn_SharedObject.setOnClickListener(this);
        btn_listShared.setOnClickListener(this);
        btn_Arraylist.setOnClickListener(this);
        btn_datastorage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btn_SharedObject:

                startActivity(new Intent(MainLauncher.this, SharedMainActivity.class));
                break;


            case R.id.btn_listShared:
                startActivity(new Intent(MainLauncher.this, ListActivity.class));

                break;

            case R.id.btn_Arraylist:
                startActivity(new Intent(MainLauncher.this, ArrayListActivity.class));

                break;

            case R.id.btn_datastorage:
                startActivity(new Intent(MainLauncher.this, InternalStorage.class));

                break;

        }


    }
}
