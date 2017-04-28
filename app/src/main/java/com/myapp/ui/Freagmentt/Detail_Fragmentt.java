package com.myapp.ui.Freagmentt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.myapp.R;
import com.myapp.ui.utils.utils;

/**
 * Create Fragment which Extends
 * Fragments.
 */
public class Detail_Fragmentt extends Fragment {

    private String TAG      = this.getClass().getSimpleName();
    private TextView textView;


    /**
     * Override method
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view       = inflater.inflate(R.layout.fragment_detail__fragmentt, container, false);

        this.setRefernce(view);

        Bundle bundle       =   getArguments();
        if(bundle    !=   null) {

            String string      =    bundle.getString("KEY");
            textView.setText(string);
        }

        return view;
    }


    /**
     * set Refrence of text view
     * @param view
     */
    private void setRefernce(View view) {
        textView       = (TextView)view.findViewById(R.id.textView);
    }

    /**
     * this Method Recived
     * the datab from main Activity
     * which Is defined in Main Activity.
     * @param msg
     */
    void setReceived(String msg){

        utils.printLog(TAG,"Inside setReceived");

        textView.setText(msg);

        utils.printLog(TAG,"Outside setReceived");
    }



}
