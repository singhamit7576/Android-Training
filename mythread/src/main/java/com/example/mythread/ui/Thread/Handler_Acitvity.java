package com.example.mythread.ui.Thread;

import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

public class Handler_Acitvity extends BaseActivity {

    private TextView tv_update;
    private final int length=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler__acitvity);

        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {

        tv_update = (TextView) findViewById(R.id.tv_update);


    }

    @Override
    protected void onListener() {
        this.startThread();


    }



    private void startThread() {

        new Thread(){
            @Override
            public void run() {
                try{

                    for (int i = 1 ; i <= length ; i++) {

                        Message message  =    new Message();
                        Bundle bundle    =    new Bundle();
                        bundle.putString("KEY",""+i);
                        message.setData(bundle);
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }.start();
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String value = bundle.getString("KEY");

            tv_update.setText(""+value);
        }
    };
}
