package com.ui.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Create MyActivity which extends
 *  Abstract BaseClass.
 */
public class My_Activity extends BaseClass implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<Employee>mylist;
    private String[] name;
    private String[] place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*    From here
        *     our Activity created*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {

        name    =    new String[]{"AMIT", "SAURABH", "ANKIT",
                "BINIT", "SURYA", "LALIT","NIKHIL",
                " ABHI", "ABHISKEH",
        };

        place   =   new String[]{"DELHI", "GOA", "MUMBAI",
                "DELHI", "BIHAR", "AGRA","PAUNJAB",
                " ALASKA", "GHAZIPUR",
        };


    }

    @Override
    protected void setReference() {
          /* setReference of
          * List View */
        listView     =  (ListView) findViewById(R.id.listview);

    }

    @Override
    protected void OnListener() {
         /* create object of Array List
          * and call the ,method GetDAataInList()
          * to get data in arryalist. */

        mylist   =  new ArrayList<Employee>();
        this.getDataInList();
        this.setAdapater();

    }

    private void getDataInList() {
         /* create object our class and
          * call the method of our class and
           * add data in list.*/
        for(int i    = 0;    i< name.length;     i++){

            Employee employee   =    new Employee();
            employee.setName(name[i]);
            employee.setPlace  (place[i]);
            mylist.add(employee);
        }
    }

    private void setAdapater() {
         /* In this method
         * we set our custom Adapter */
        MyCustomAdapater adapter     =  new MyCustomAdapater(this,mylist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          /* In this method
         * when u clicked on any items in list
          * then it will show an Toast message.*/
        Toast.makeText(My_Activity.this, "clciked", Toast.LENGTH_SHORT).show();
    }
}
