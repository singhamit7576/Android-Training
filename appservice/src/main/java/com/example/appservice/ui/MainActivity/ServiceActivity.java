package com.example.appservice.ui.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.appservice.R;
import com.example.appservice.ui.IntentService.IntentActivity;
import com.example.appservice.ui.MusicPlayer.MusicAcitvity;
import com.example.appservice.ui.Onbound.BinderActivity;
import com.example.appservice.ui.baseActivity.BaseActivity;

public class ServiceActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_Music, btn_binder;
    private Button btn_Intent_Service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        btn_Music = (Button) findViewById(R.id.btn_Music);//(Normal Service)
        btn_binder = (Button) findViewById(R.id.btn_binder);
        btn_Intent_Service = (Button) findViewById(R.id.btn_Intent_Service);

    }

    @Override
    protected void onListener() {

        btn_Music.setOnClickListener(this);
        btn_binder.setOnClickListener(this);
        btn_Intent_Service.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_Music:

                startActivity(new Intent(ServiceActivity.this, MusicAcitvity.class));
                break;


            case R.id.btn_binder:
                startActivity(new Intent(ServiceActivity.this, BinderActivity.class));

                break;

            case R.id.btn_Intent_Service:
                startActivity(new Intent(ServiceActivity.this, IntentActivity.class));

                break;
        }
    }
}
