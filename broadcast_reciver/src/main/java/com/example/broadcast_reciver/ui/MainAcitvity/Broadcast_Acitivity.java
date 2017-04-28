package com.example.broadcast_reciver.ui.MainAcitvity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.broadcast_reciver.R;
import com.example.broadcast_reciver.ui.BaseAcitvityy.BaseAcitivity;
import com.example.broadcast_reciver.ui.DynamicBroadcast.Dynamic_Brodcast_Receiver;
import com.example.broadcast_reciver.ui.StaticReciver.MainActivity;

/**
 * create Activity Broadcast_Acitivity
 * which extends  my Abstract class  which have some
 * abstract method.
 */
public class Broadcast_Acitivity extends BaseAcitivity implements View.OnClickListener {

    private Button btn_static,btn_dynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast__acitivity);
        this.setReference();
        this.onListener();
    }



    /**
     * set Reference of
     * of Button.
     */
    @Override
    protected void setReference() {

        btn_static          =       (Button)     findViewById(R.id.btn_static);
        btn_dynamic         =       (Button)     findViewById(R.id.btn_dynamic);

    }

    /**
     * set listener of button
     */
    @Override
    protected void onListener() {
        btn_static.setOnClickListener(this);
        btn_dynamic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_static:
                startActivity(new Intent(Broadcast_Acitivity.this, MainActivity.class));
                break;

            case R.id.btn_dynamic:
                startActivity(new Intent(Broadcast_Acitivity.this, Dynamic_Brodcast_Receiver.class));
            default:
                break;

        }


    }
}
