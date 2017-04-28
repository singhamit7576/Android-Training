package com.example.database.CreateDataBase;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.database.R;
import com.example.database.Ui.Activities.BaseActivity;

public class MainActivity extends BaseActivity {


    InfoDataBase infoDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {

    }

    @Override
    protected void onListener() {


        infoDataBase = new InfoDataBase(this);

        SQLiteDatabase sqLiteDatabase =  infoDataBase.getReadableDatabase();

    }
}
