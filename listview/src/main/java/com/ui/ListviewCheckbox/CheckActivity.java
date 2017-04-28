package com.ui.ListviewCheckbox;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.R;
import com.ui.activities.BaseClass;

import java.util.ArrayList;

/**
 * ThisIS my activity named as CheckActivity which extends my cuctom
 * abstract class and implements AdapterView.OnItemsClickListner interface.
 */

public class CheckActivity extends BaseClass implements AdapterView.OnItemClickListener, View.OnClickListener {

    private Button btn_count;
    ArrayList<Student>studentlist;
    // private String []name;
    private final int length=20;
    private ListView lstview;

    /**
     * Activity Created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        //   this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {

//        name = new String[]{"AMIT", "SAURABH", "ANKIT",
//                "BINIT", "SURYA", "LALIT","NIKHIL",
//                " ABHI", "ABHISKEH",
//        };
//        name = new String[length];
//        for(int i = 0;i<length ;i++){
//            name[i] = "Name" +i;
//        }
    }


    /*Set reference of List View*/
    @Override
    protected void setReference() {
        btn_count =  (Button)  findViewById(R.id.btn_Count);
        lstview = (ListView) findViewById(R.id.lstview);
    }


    /**
     * create arrayList.
     * and called Tow method which
     * add data into Studentslist
     * and set the Adapter
     */
    @Override
    protected void OnListener() {

        studentlist    =    new ArrayList<Student>();
        this.getData();
        this.set();

    }


    /**
     * In This we set  our
     * Custom Adapter with ListView.
     */
    private void set() {
        ListAdapter listtAdapter     =      new ListAdapter(this, studentlist);


        lstview.setAdapter(listtAdapter);//set adapter
        lstview.setOnItemClickListener(this);
        btn_count.setOnClickListener(this);

    }

    private void getData() {

        for(int i = 1 ; i<=      length ; i++){

            Student stud     =  new Student();//create object
            stud.setName("Name"+i);//set NAme
            studentlist.add(stud);//add data in list
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    /**
     *
     */

    @Override
    public void onClick(View v) {
        int count   = 0;
        int listsize     =  studentlist.size();

        for(int i = 0; i < listsize; i++){

            if(studentlist.get(i).isSelected()){
                count++;

            }
        }
        Toast.makeText(CheckActivity.this, count+"are selected", Toast.LENGTH_SHORT).show();
    }
}

