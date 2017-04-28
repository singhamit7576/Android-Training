package com.example.contentprovidertest.Ui.MainLauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contentprovidertest.R;
import com.example.contentprovidertest.Ui.CustomContentProvider.BookRegisterActivity;
import com.example.contentprovidertest.model.MainActivity;

public class ContentMAinActivity extends AppCompatActivity implements View.OnClickListener {
    
    Button btn_contact,btn_OwnConetentProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_main);
        this.setReference();
        this.onListener();
    }

    private void onListener() {
        btn_contact.setOnClickListener(this);
        btn_OwnConetentProvider.setOnClickListener(this);

    }

    private void setReference() {

        btn_contact                 = (Button)      findViewById(R.id.btn_contact);
        btn_OwnConetentProvider     = (Button)      findViewById(R.id.btn_OwnConetentProvider);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_contact:
                startActivity(new Intent(ContentMAinActivity.this, MainActivity.class));
                break;
            case R.id.btn_OwnConetentProvider:
                startActivity(new Intent(ContentMAinActivity.this, BookRegisterActivity.class));
                break;
        }

    }
}
