package com.example.dialog.ui.AlertDaiolog;


import android.os.Bundle;
import android.widget.EditText;

import com.example.dialog.BaseActivity.BaseActivity;
import com.example.dialog.R;

/**
 *  creat Activity which
 *  get data from Alert_dialog
 *  Activity
 */
public class SavedAcitvity extends BaseActivity {
    private EditText et_saved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_acitvity);
        this.setReference();
        this.onListener();
    }


    /**
     *  setReference of
     *  Edit Text
     */
    @Override
    protected void setReference() {
        et_saved        =(EditText) findViewById(R.id.et_saved);

    }


    /**
     *  get data Via
     *  Bundle And
     *  set Into our Edit Text
     */
    @Override
    protected void onListener() {

        Bundle bundle        = getIntent().getExtras();
        String data          = bundle.getString("DATA");
        et_saved.setText(data);

    }
}
