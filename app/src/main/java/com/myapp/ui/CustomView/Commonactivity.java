package com.myapp.ui.CustomView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements OnClickListener Interface.
 *  For Custom TextView.
 */
public class Commonactivity extends BaseActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonactivity);
        this.setReference();
        this.OnListener();
    }

    /**
     * setReference of
     * EditText
     */
    @Override
    protected void setReference() {
        button         =   (Button)    findViewById(R.id.btnpress) ;

    }

    /**
     * setListener
     *  of Button.
     */
    @Override
    protected void OnListener() {

        button.setOnClickListener(this);

    }

    /**
     * go to another Acitivity
     * named as Custom ,FOR Custom TextView
     * @param v
     */
    @Override
    public void onClick(View v) {

        Intent mIntent    =     new Intent(Commonactivity.this,custom.class);
                startActivity(mIntent);

    }
}
