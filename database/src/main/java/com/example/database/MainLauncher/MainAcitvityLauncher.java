package com.example.database.MainLauncher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.database.DATABSE.Acitivity;
import com.example.database.InsertData.InsertActivity;
import com.example.database.CreateDataBase.MainActivity;
import com.example.database.R;
import com.example.database.Ui.Activities.BaseActivity;

public class MainAcitvityLauncher extends BaseActivity implements View.OnClickListener {


    private Button btn_simpleDatabase,btn_InsertData,btn_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_acitvity_launcher);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {

        btn_simpleDatabase = (Button) findViewById(R.id.btn_simpleDatabase);
        btn_InsertData     = (Button) findViewById(R.id.btn_InsertData);
        btn_database       = (Button) findViewById(R.id.btn_database);

    }

    @Override
    protected void onListener() {

        btn_simpleDatabase.setOnClickListener(this);
        btn_InsertData.setOnClickListener(this);
        btn_database.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btn_simpleDatabase:
                startActivity(new Intent (MainAcitvityLauncher.this, MainActivity.class));
                break;

            case R.id.btn_InsertData:
                startActivity(new Intent (MainAcitvityLauncher.this, InsertActivity.class));
                break;

            case R.id.btn_database:

                startActivity(new Intent (MainAcitvityLauncher.this, Acitivity.class));

                break;

        }
    }
}
