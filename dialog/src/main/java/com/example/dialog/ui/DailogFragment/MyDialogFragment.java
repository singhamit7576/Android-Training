package com.example.dialog.ui.DailogFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.WindowCompat;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dialog.R;


public class MyDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText edittxt_name;

    interface Username{
        void userDailog(String string);

    }

    public MyDialogFragment( ) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view        =   inflater.inflate(R.layout.fragment_my_dialog, container, false);
        edittxt_name     =    (EditText) view.findViewById( R.id.edittxt_name);


        edittxt_name.setOnEditorActionListener(this);
        edittxt_name.requestFocus();
     //   getDialog().getWindow().setSoftInputMode(WindowCompat..SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");
        return  view;
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        Username username = (Username) getActivity();
        username.userDailog(edittxt_name.getText().toString());
        this.dismiss();
        return true;
    }
}
