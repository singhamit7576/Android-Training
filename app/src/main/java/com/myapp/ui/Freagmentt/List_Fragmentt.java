package com.myapp.ui.Freagmentt;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.user.myapp.R;
import com.myapp.ui.utils.utils;

/**
 * create List Fragment which Extends
 * Fragment.
 * Create Interface For Fragments Communication.
 */
public class List_Fragmentt extends Fragment {

    private String TAG  = this.getClass().getSimpleName();
    private Communication mCommunication     = null;
    final int LENGTH=4;


    /**
     * create Interface for Communication between
     * Fragments
     *
     */
    interface Communication{
        void setCommunication(String msg);
    }


    /**
     * Override Fragments Method
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view                   =         inflater.inflate(R.layout.fragment_list__fragmentt, container, false);
        LinearLayout linearLayout   =         (LinearLayout)    view.findViewById(R.id.linearlayout);
        this.addview(linearLayout,inflater);

        return view;
    }


    /**
     * This Method  is Used to inflate
     * our Custom CELL.xml in Fragment.
     * @param linearlayout
     * @param inflater
     */
    private void addview(LinearLayout linearlayout, LayoutInflater inflater){

        for(int  i =     0  ; i <= LENGTH ; i++){

            View mView               =          inflater.inflate(R.layout.cell, null, false);
            Button btn_item          =          (Button)     mView.findViewById(R.id.btn_item);
            final EditText item_et   =          (EditText)   mView.findViewById(R.id.item_et);

            btn_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String mString       =      item_et.getText().toString();
                    sendMessage(mString);
                }
            });
            linearlayout.addView(mView);        //add the own layout in fragment
        }
    }

    @Override
    public void onAttach(Activity activity) {
        try {
            mCommunication       =  (Communication) activity;
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onAttach(activity);
    }

    private void sendMessage(String msg) {
        mCommunication.setCommunication(msg);
    }
}
