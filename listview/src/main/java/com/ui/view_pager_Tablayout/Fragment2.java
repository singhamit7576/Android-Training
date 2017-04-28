package com.ui.view_pager_Tablayout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.listview.R;

/**
 * Created by user on 20/3/17.
 */
public class Fragment2 extends Fragment  {

    private EditText  et_frag2;
    private Button btn_frag2;
    private Communication mCommunication;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment2,container,false);
        this.setReference(view);
        this.onListener();
        return view;
    }

    private void setReference(View view) {

        et_frag2          = (EditText)view.findViewById(R.id.et_frag2) ;
        btn_frag2        =  (Button) view .findViewById(R.id.btn_frag2);

    }

    void setReceived(String msg){

        et_frag2.setText(msg);


    }

    private void onListener() {

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str   = et_frag2.getText().toString();
                mCommunication.setCommunication(str);
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCommunication = (Communication) context;

    }
}
