package com.example.storagesharedprefrences.ui.Activities.ui.SharedPreferenceArraylist;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;
import com.example.storagesharedprefrences.ui.Activities.ui.listSharedPrefrences.UserData;

import java.util.ArrayList;

public class ArrayListActivity extends BaseActivity {

    private TextView tv_data;
    private SharedPreference sharedPreference;
    private static  final int length= 5;
    public static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_list);
        this.setReferences();
        this.onListener();
    }

    @Override
    protected void setReferences() {

        tv_data         =       (TextView)       findViewById(R.id.tv_data);
        sharedPreference = new SharedPreference(this);

    }

    @Override
    protected void onListener() {
        this.saveData();
        this.retrivedata();

    }


    private void saveData() {
        ArrayList<UserData>userDataArrayList = new ArrayList<>();

        for(int i  = 0  ; i < length ; i++){
            UserData userData = new UserData();
            userData.setName(getString(R.string.name));
            userData.setAddress(getString(R.string.address));
            userDataArrayList.add(userData);
        }
        sharedPreference.store(KEY,userDataArrayList);
    }


    private void retrivedata() {

        ArrayList <UserData> arrayList=  sharedPreference.load(KEY);
        String textData= "";

        for (int i = 0; i < arrayList.size();i++){

            textData = textData+""+getString(R.string.NAME)+" : "+arrayList.get(i).getName()+"\n";
            textData = textData+""+getString(R.string.NAME)+":  "+arrayList.get(i).getAddress()+"\n";

        }
        tv_data.setText(textData);
    }


}
