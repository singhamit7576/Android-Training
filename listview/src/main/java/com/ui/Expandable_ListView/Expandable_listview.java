package com.ui.Expandable_ListView;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.listview.R;
import com.ui.activities.BaseClass;

import java.util.ArrayList;

public class Expandable_listview extends BaseClass{


    ArrayList<Group> group   =   new ArrayList<Group>();
    private  String []  values;
    private ExpandableListView expand;
    private MyBaseExpandable adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);
        this.setReference();
        this.array();
        this.groupitem();
        this.OnListener();
    }

    private void groupitem() {

         /* Adding elements into
         * ArrayList*/

        for (int i = 0; i < values.length; i++) {
            Group group1     =       new Group(values[i]);
            ArrayList<child> items       =  new ArrayList<child>();  //create child arraylist object and add data.
            items.add(new child("child 0"));
            items.add(new child("child 1"));
            items.add(new child("child 2"));
            group1.setItems(items);
            group.add(group1);
        }

    }

    private void array() {
        values       =       new String[]{"Parent 1", "Parent 2", "Parent 3"};
    }

    @Override
    protected void setReference() {
        expand = (ExpandableListView) findViewById(R.id.expand);  //setReference of expandable View.
    }

    @Override
    protected void OnListener() {


        /* create Custom Expnadable adtapter object
        * set Adapter with ExpnadView object */

        adapter      =      new MyBaseExpandable(this,group);
        expand.setAdapter(adapter);
        this.listener();//perfrom when user click.


    }

    private void listener() {
        /*  method to expand one list view and
        *  close another listview item.*/
        expand.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int len     =    adapter.getGroupCount();
                for (int i   = 0; i  < len; i++) {

                    if (i   !=  groupPosition) {
                        expand.collapseGroup(i);
                    }
                }
            }
        });
    }
}