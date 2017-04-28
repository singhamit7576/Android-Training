package com.example.dialog.ui.AlertDaiolog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dialog.BaseActivity.BaseActivity;
import com.example.dialog.R;


/**
 *  create Activity
 *  wguch extends my Baseclass.
 */
public class Alert_Dailog extends BaseActivity implements View.OnClickListener {

    private EditText et_name;
    private Button btn_save;
    private Button btn_close;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert__dailog);
        this.setReference();
        this.onListener();
    }


    /**
     *  set Reference
     *  of
     *  editText,Button
     */
    @Override
    protected void setReference() {

        et_name             = (EditText) findViewById(R.id.et_name);
        btn_save            = (Button) findViewById(R.id.btn_save);
        btn_close           = (Button) findViewById(R.id.btn_close);
    }


    /**
     *  set Listener
     *  of
     *  Button
     */
    @Override
    protected void onListener() {

        btn_save.setOnClickListener(this);
        btn_close.setOnClickListener(this);


    }


    /**
     *  set Alert Dailog
     *  title and message
     */

    private void Alertsetup() {
        builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.message)
                .setTitle(R.string.title);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_save:
                this.save();
                break;

            case R.id.btn_close:
                this.exit();
                break;

            default:
                break;

        }

    }
    /**
     * action perform on
     * buttons og alertbox
     */
    private void save() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.savee)
                .setTitle(R.string.title);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String data = et_name.getText().toString();
                this.datapass(data);
            }

            private void datapass(String data) {
                Intent intent =          new Intent(Alert_Dailog.this, SavedAcitvity.class);//create intent object to pass message from one activity to another activity
                intent.putExtra("DATA",data);
                startActivity(intent);
                Toast.makeText(Alert_Dailog.this, "DATA SAVED", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_Dailog.this, "clicked cancel", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });


        AlertDialog alert = builder.create();
        alert.show();


    }

    /**
     * action perform on
     * buttons og alertbox
     */
    private void exit() {

        this.Alertsetup();

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(Alert_Dailog.this, "Ok Button Clicked", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builder.setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_Dailog.this, "clicked cancel", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });


        AlertDialog alert = builder.create();
        alert.show();

    }

}
