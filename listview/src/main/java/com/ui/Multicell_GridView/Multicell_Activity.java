package com.ui.Multicell_GridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.listview.R;
import com.ui.activities.BaseClass;
import com.ui.demo.Employee;

import java.util.ArrayList;
import java.util.List;

public class Multicell_Activity extends BaseClass{

    private GridView gridView;
    private String name[];
    private List<Employee>mylist = new ArrayList<Employee>();
    private MulticellGrid multicellGrid = null;
    private String[] place;
    private String [] age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multicell_);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {

        /*Array initializing */
        name = new String[]{"AMIT", "SAURABH", "ANKIT",
                "BINIT", "SURYA", "LALIT","NIKHIL",
                " ABHI", "ABHISKEH","ANUJ","APEX","RAM"};

        place  = new String[]{"GOA", "MUMBAI", "DELHI",
                "NOIDA", "NEW DELHI", "ALASKA","GHAZIPUR",
                " BIHAR", "PUNAJAB","HARIYANA","MP","UP","DELHI",};

        age =new String[]{"11","12","13","14","15","16","17","18","19","20","12","55","25"};

    }

    @Override
    protected void setReference() {

        /*set refernce of Gridview*/
        gridView = (GridView) findViewById(R.id.gridview);

    }

    @Override
    protected void OnListener() {
        this.getDataInlist();
        this.setAdapater();

    }

    private void setAdapater() {

        multicellGrid   =   new MulticellGrid(mylist,this);
        gridView.setAdapter(multicellGrid);
    }

    private void getDataInlist() {
            /*data adding into
            * array in multi cell*/

        for( int i = 0 ; i< name.length ; i++){
            int p =i%3;

            if( p == 0 ){

                Employee emp = new Employee();  //create object of class Employee
                emp.setName(name[i]);
                emp.setType(0);
                mylist.add(emp);                //add the data into list .


            }
            else if (p== 1){
                Employee emp = new Employee();   //create object of class Employee
                emp.setPlace(place[i]);
                emp.setType(1);
                mylist.add(emp);

            }
            else{
                Employee emp = new Employee();   //create object of class Employee
                emp.setAge(Integer.parseInt(age[i]));
                emp.setType(2);
                mylist.add(emp);


            }
        }



    }
}
