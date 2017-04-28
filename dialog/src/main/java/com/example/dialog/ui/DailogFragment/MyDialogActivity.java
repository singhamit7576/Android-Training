package com.example.dialog.ui.DailogFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialog.BaseActivity.BaseActivity;
import com.example.dialog.R;


/**
 * create MyDialog Activity which extends
 * my abstract class.
 */
public class MyDialogActivity extends BaseActivity implements View.OnClickListener,MyDialogFragment.Username {

    private Button btn_fragment;
    private TextView tv_setdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        btn_fragment        =        (Button)    findViewById(R.id.btn_fragment);
        tv_setdata          =        (TextView)  findViewById(R.id.tv_setdata);

    }

    @Override
    protected void onListener() {
        btn_fragment.setOnClickListener(this);

    }


    /**
     * setListener.
     * @param v
     */
    @Override
    public void onClick(View v) {

        MyDialogFragment myDialogFragment   =   new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(),"fragment name");

    }

    @Override
    public void userDailog(String string) {
        tv_setdata.setText(""+ string);
        Toast.makeText(MyDialogActivity.this, "Hello"+string, Toast.LENGTH_SHORT).show();
    }
}
