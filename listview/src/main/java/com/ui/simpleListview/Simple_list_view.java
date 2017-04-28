package com.ui.simpleListview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;


public class Simple_list_view extends BaseClass implements AdapterView.OnItemClickListener {

    private ListView list;
    private String values [];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         /*ACtivity created */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {
        /*Initializing array
        */
        values = new String[] {
                "Naught", "Marshmellow", "Lollipop",
                "Kitkat", "Jellybean", "Icecream","Honeycomb",
                " Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake"};
    }

    protected void setReference() {
         /*set Refrence of List view*/
        list    =   (ListView) findViewById(R.id.list);
    }


    protected void OnListener() {

        ArrayAdapter adapter     =   new ArrayAdapter<String>(this, R.layout.itmes, R.id.txt, values);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String itemvalue  =     (String) list.getItemAtPosition(position);

        Toast.makeText(Simple_list_view.this, "Position" + position + "value" + itemvalue, Toast.LENGTH_SHORT).show();
    }
}
