package com.example.storagesharedprefrences.ui.Activities.ui.listSharedPrefrences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_retriveName;
    private Button btn_retrive;
    private SharedPreferences.Editor editor;
    public static final String PREFS = "KEY";
    public static final String PREFS_DATA = "USER";
    private List<String> list ;

    UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        this.setReferences();
        this.saveSharedPreferences();
        this.onListener();
    }

    @Override
    protected void setReferences() {

        tv_retriveName          =   (TextView)     findViewById(R.id.tv_retriveName);
        btn_retrive             =   (Button)       findViewById(R.id.btn_retrive);

    }


    private void saveSharedPreferences() {



        list= new ArrayList<>();
        SharedPreferences preferences   =   getSharedPreferences(PREFS,MODE_PRIVATE);
        editor   =   preferences.edit();

        list.add(getString(R.string.name));
        list.add(getString(R.string.address));

        Set<String> set = new HashSet<>();
        set.addAll(list);
        editor.putStringSet(PREFS_DATA, set);
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

        String retrieveData = "";
        SharedPreferences sharedPreferences         =   getSharedPreferences(PREFS,MODE_PRIVATE);
        Set<String> set = sharedPreferences.getStringSet(PREFS_DATA, null);
        List<String> list=new ArrayList<>(set);

        for(int i = 0; i < list.size();i++){

            retrieveData += list.get(i)+"\n";
        }
        tv_retriveName.setText(retrieveData);
    }


}
