package com.ui.Gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;
import com.ui.demo.Employee;
import com.ui.demo.MyCustomAdapater;

import java.util.ArrayList;
import java.util.List;

/**
 * Create Grid view
 * in acitivty.
 */

public class Grid_activity extends BaseClass implements AdapterView.OnItemClickListener {

    private GridView grid ;
    private String[] name;
    private String[] place;
    private List<Employee> mylist;
    private GridViewAdapter gridViewAdapter;


    /**
     * /* ACtivity Created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_activity);

        this.array();
        this.setReference();
        this.OnListener();
    }

    /**
     * /* Array inialtizing
     */
    private void array() {


        name    =   new String[]{       "AMIT", "SAURABH", "ANKIT",
                                        "BINIT", "SURYA", "LALIT","NIKHIL",
                                        "ABHI", "ABHISKEH","ANUJ","RAM","RISHU"
                                 };

        place    =  new String[]{       "DELHI", "GOA", "MUMBAI",
                                        "DELHI", "BIHAR", "AGRA","PAUNJAB",
                                        "ALASKA", "GHAZIPUR","DELHI","DELHI","DELHI"
                                  };

    }

    /**
     * set Reference of gridview.
     */
    @Override
    protected void setReference() {
        grid         =  (GridView)   findViewById(R.id.grid);

    }


    /**
     * create object of ArrayList
     * and call the method getDataInList
     * And Set Adapter .
     */
    @Override
    protected void OnListener() {

        mylist = new ArrayList<Employee>();
        this.getDataInList();
        this.setAdapater();

    }

    /**
     * to add all elemenst in Array List.
     */
    private void getDataInList() {

        for(int i   =   0;  i< name.length;  i++){

            Employee employee   =      new Employee();                 //create object of Employee Class.
            employee.setName(name[i]);                          //call the Employee method set Name and pass array as a parameter.
            employee.setPlace(place[i]);
            mylist.add(employee);                               //add all elements
        }
    }

    /**
     * create object of Custom Grid view adapter
     * and set Adpater.
     */
    private void setAdapater() {

        gridViewAdapter      =      new GridViewAdapter(this,mylist);
        grid.setAdapter(gridViewAdapter);
        grid.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(Grid_activity.this, "clicked"+ position, Toast.LENGTH_SHORT).show();
    }
}

