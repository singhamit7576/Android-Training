package com.ui.view_pager_Tablayout;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listview.R;


/**
 * frgament1 extends Fragment.
 */

public class Fragment1 extends Fragment {

    private EditText et_data;
    private Button btn_frag1;
    private Communication mCommunication ;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view   =    inflater.inflate(R.layout.fragment1,container,false);
        this.setReference(view);
        this.OnListener();
        return view;
    }

    private void OnListener() {

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str      = et_data.getText().toString();
                mCommunication.setCommunication(str);


            }
        });
    }



    private void setReference(View view) {

        et_data         =  (EditText) view.findViewById(R.id.et_data);
        btn_frag1       =  (Button) view.findViewById(R.id.btn_frag1);


    }



    @Override
    public void onAttach(Context context) {

        try{
            mCommunication = (Communication) context;
        }catch (Exception e){
            e.printStackTrace();
        }
        super.onAttach(context);
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }




}
