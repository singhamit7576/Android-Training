package com.myapp.ui.activites.NetwrokOperation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.activites.NetwrokOperation.Exception.EmptyUrl;
import com.myapp.ui.activites.NetwrokOperation.Exception.Invalidurl;
import com.myapp.ui.utils.utils;


/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements OnClickListener Interface.
 */
public class Activity_Exception extends BaseActivity implements View.OnClickListener {

    private EditText edit_text;
    private Button btn;
    private String TAG   =    this.getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__exception);

        utils.printLog(TAG,"Inside Oncreat()");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"Outside Oncreat()");
    }


    /**
     * setReference of
     * EditText and
     * Button.
     */
    @Override
    protected void setReference() {

        utils.printLog(TAG,"Inside setReference()");

        edit_text        =       (EditText) findViewById(R.id.edit_text);
        btn              =       (Button)   findViewById(R.id.btn);

        utils.printLog(TAG,"Outside setReference()");
    }


    /**
     * setListener
     *  of Button.
     */
    @Override
    protected void OnListener() {

        utils.printLog(TAG,"Inside OnListener()");

        btn.setOnClickListener(this);

        utils.printLog(TAG,"Outside OnListener()");

    }


    /**
     * data get into Strign url which is input by User.
     * Create Object Of Network Operation.
     * AND USe Try AnD CAtch for Exception.
     * @param v
     */
    @Override
    public void onClick(View v) {

        utils.printLog(TAG,"Inside onClick()");

        String url       =       edit_text.getText().toString();

        NetworkOperationn networkOperationn     =    new NetworkOperationn(); //

        try{
            networkOperationn.request(url);
        }
        catch (EmptyUrl emptyurl) {

            utils.show(this,emptyurl.toString());
        }

        catch (Invalidurl invalidurl) {

            utils.show(this,invalidurl.toString());
        }

        utils.printLog(TAG,"Outside onClick()");
    }
}
