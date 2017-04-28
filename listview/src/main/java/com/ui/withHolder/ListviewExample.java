package com.ui.withHolder;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;
import com.ui.listview.RowItem;
import java.util.ArrayList;
import java.util.List;

public class ListviewExample extends BaseClass implements AdapterView.OnItemClickListener,View.OnClickListener {

    private ListView list;
    private EditText et;
    private int getposition;
    private int count;
    private String values [];
    private MyBaseAdapater adapterr=null;
    private List<RowItem> rowItems;
    private Button btn_add,btn_remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_example);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {
        //array initializing.
        values      =    new String[]{"Naught", "MarshMallow", "Lollipop",
                "Kitkat", "Jellybean", "IceCream","Honeycomb",
                " Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake"
        };
    }

    @Override
    protected void setReference() {
        /*set Refrence of list,
        * button add
        * button remove,and edit text*/
        list        =        (ListView) findViewById(R.id.list);
        btn_add     =        (Button)   findViewById(R.id.btn_add);
        et          =        (EditText) findViewById(R.id.et);
        btn_remove  =        (Button)   findViewById(R.id.btn_remove);
    }

    @Override
    protected void OnListener() {

        this.getDataInList();
        btn_add.setOnClickListener(this);
        btn_remove.setOnClickListener(this);
        list.setOnItemClickListener(this);
    }

    private void getDataInList() {
        rowItems = new ArrayList<RowItem>();

        for  (int i   = 0;    i < values.length;  i++) {
            RowItem item    =    new RowItem(values[i], 1);
            rowItems.add(item);
        }

        adapterr     =   new MyBaseAdapater(this, rowItems);
        list.setAdapter(adapterr);
    }
//thiscmnt sction in in getdata.
//        for (int i = 0; i < values.length; i++) {
//            if( i % 2 == 0) {
//                RowItem item = new RowItem(values[i], 1);
//                rowItems.add(item);
//            }else{
//                RowItem item = new RowItem(values[i], 0);
//                rowItems.add(item);
//            }
//        }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getposition     =   position;
    }


    @Override
    public void onClick(View v) {
        //this will get the id of btn add and remove
        switch (v.getId()) {

            case R.id.btn_add:
                this.add();//call add()method.
                break;

            case R.id.btn_remove:
                this.removeRow();
                break;
        }

    }


    private void removeRow() {

        String string   =    et.getText().toString();

        if (!string.equals("")) {
            int position     =   Integer.parseInt(string);
            if (position < this.childcount()) {
                rowItems.remove(position);
                adapterr.notifyDataSetChanged();
            } else {
                Toast.makeText(ListviewExample.this, "enter index less than" + this.childcount(), Toast.LENGTH_SHORT).show();
            }

        } else {
            if (this.childcount()   > 0) {
                rowItems.remove(getposition);
                adapterr.notifyDataSetChanged();

            } else {
                Toast.makeText(ListviewExample.this, "NO ANY ITEM TO REMOVE", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void add() {

        String string    =   et.getText().toString();
        if(!string.equals("")) {
            int position    =    Integer.parseInt(string);           //get the postion of current str.
            if(position      <=     this.childcount() ){

                rowItems.add(position, new RowItem("naught" ,1));
                adapterr.notifyDataSetChanged();
            }
            else{
                Toast.makeText(ListviewExample.this, "enter valid index less than"+count, Toast.LENGTH_SHORT).show();
            }

        }else{
            rowItems.add(this.childcount(), new RowItem("naught" ,1));
            adapterr.notifyDataSetChanged();
        }

    }

    private int childcount(){
        count= list.getChildCount();
        return count;
    }



}
