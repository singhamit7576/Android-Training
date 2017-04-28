package com.example.mythread.ui.JsonExpand;

import android.os.Bundle;
import android.widget.ExpandableListView;
import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;
import java.util.ArrayList;

public class JsonExpandActivity extends BaseActivity {

    ExpandableListView expand_ListView;
    MyExpandAdpater myExpandAdpater;
    ArrayList<Beacon> beaconInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_expand);
        this.parse();
        this.setReference();
        this.onListener();
    }

    private void parse() {
        Parser parser            =  new Parser(this);
        Data data                =  parser.parsedData();
        beaconInfoArrayList = data.getBeaconIDArrayList();
    }


    @Override
    protected void setReference() {

        expand_ListView      =       (ExpandableListView) findViewById(R.id.expand_ListView);

    }

    @Override
    protected void onListener() {
        myExpandAdpater      =       new MyExpandAdpater(this, getLayoutInflater(),beaconInfoArrayList);
        expand_ListView.setAdapter(myExpandAdpater);
    }



}
