package com.ui.View_Pager_Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.listview.R;

/**
 * Created by user on 20/3/17.
 */
public class PagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view    =       inflater.inflate(R.layout.tab1,container,false);
        this.setText(view);
        return view;
    }

    private void setText(View view) {
      //Bundle bundle = getArguments();
        int num      =  getArguments().getInt("key");
        TextView tab_num     =   (TextView)  view.findViewById(R.id.tab_num);
        //tab_num.setText("Tab Number"+bundle.getInt("key"));
        tab_num.setText("TAB NUMBER" +num);
    }
}
