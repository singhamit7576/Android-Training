package com.ui.listview;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;

import java.util.ArrayList;
import java.util.List;

/**
 * create ListView in this
 * Activity.
 */
public class MainActivity extends BaseClass implements AdapterView.OnItemClickListener {

    private ListView listview;
    private String values [];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {

        /*initializing array elements*/
        values      =   new String[]{   "Naught", "Marshmellow", "Lollipop",
                                        "Kitkat", "Jellybean", "Icecream","Honeycomb",
                                        " Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake"
        };

    }

    /**
     *set Reference of Listview
     */
    @Override
    protected void setReference() {

        listview        =    (ListView) findViewById(R.id.listview);

    }

    @Override
    protected void OnListener() {

        List<RowItem>    rowItems   =   new     ArrayList<RowItem>();

        for (int  i   =  0 ; i < values.length; i++) {

            RowItem item    =    new RowItem(values[i] , 0);
            rowItems.add(item);
        }
        /*create object of custom adapter*/
        MyAdapter adapter   =   new MyAdapter(this, rowItems);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*gives
        * position and selected item*/

        String itemvalue  =     (String)    listview.getItemAtPosition(position);

        Toast.makeText(MainActivity.this, "Position" + position + "value" + itemvalue, Toast.LENGTH_SHORT).show();
    }
}

