package com.ui.view_pager_Tablayout;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.listview.R;

public class Fragment3 extends Fragment {

    private  TextView txt_tab3;
    private  TextView txt_data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view   = inflater.inflate(R.layout.fragment3, container, false);
        txt_tab3     = (TextView) view.findViewById(R.id.txt_tab3);
        txt_data     = (TextView)  view .findViewById(R.id.txt_data);
        return view;
    }

    void setReceived(String msg){
        txt_data.setText(msg);
    }


}
