package com.example.appservice.ui.IntentService;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.appservice.R;
import com.example.appservice.ui.baseActivity.BaseActivity;

public class IntentActivity extends BaseActivity implements View.OnClickListener {

    private Button btnn_Play,btnn_stop;
    private  Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {

        btnn_Play        =   (Button)    findViewById(R.id.btnn_Play);
        btnn_stop        =   (Button)    findViewById(R.id.btnn_stop);

    }

    @Override
    protected void onListener() {
        btnn_Play.setOnClickListener(this);
        btnn_stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mIntent = new Intent(IntentActivity.this,MyIntentService.class);
        switch (v.getId()){

            case R.id.btnn_Play:
                startService(mIntent);
//                Thread thread = new Thread(){
//                    @Override
//                    public void run() {
//
//                        startService(mIntent);
//                    }
//                };
//                thread.start();

                break;

            case R.id.btnn_stop:


                stopService(mIntent);


                break;
        }


    }
}
