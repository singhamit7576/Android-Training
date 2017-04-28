package com.example.storagesharedprefrences.ui.Activities.ui.InternalAndExternalStorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;

public class ImageSaveActivity extends BaseActivity implements View.OnClickListener {


    private Button btn_image;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_save);
        this.setReferences();
        this.onListener();
    }

    @Override
    protected void setReferences() {

        imageView      =   (ImageView)    findViewById(R.id.imageView);
        btn_image      =   (Button)       findViewById(R.id.btn_image);

    }

    @Override
    protected void onListener() {

        btn_image.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

    }
}
