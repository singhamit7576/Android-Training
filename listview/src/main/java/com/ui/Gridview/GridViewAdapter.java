package com.ui.Gridview;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.listview.R;
import com.ui.demo.Employee;
import java.util.List;

/**
 * Create Custom Adapter which extends BAse Adpater
 */
public class GridViewAdapter extends BaseAdapter {


    /**
     *  /* create List which name
     is Mylist.
     */
    private Context context;
    List<Employee> mylist;


    /**
     * make Constructor of
     * Grid View Adpater and pass
     * context for - current state of the application/object.
     * It is an entity that represents various environment data.
     * @param context
     * @param mylist
     */
    public GridViewAdapter(Context context, List<Employee> mylist) {

        this.context = context;
        this.mylist = mylist;
    }


    /**
     * /*retun size of Mylist.
     * @return size of list.
     */
    @Override
    public int getCount() {

        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mylist.indexOf(getItem(position));
    }
    public static class ViewHolder{
        TextView txt1;
        TextView txt2;
        public TextView txt;
    }

    /**
     *  /*getView to inflate our Layout
     * if View Is null.
     * LayoutInflater  used to retrieve a LayoutInflater
     * for inflating layout resources in this context.
     * @param position
     * @param convertView
     * @param parent
     * @return
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater          =       (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder;
        /*create object of view Holder class*/

        viewHolder          =       new ViewHolder();
        if (convertView     ==      null) {


            convertView         =     inflater.inflate(R.layout.custom_layout, null);
            viewHolder.txt1     =    (TextView) convertView.findViewById(R.id.txt1);
            viewHolder.txt2     =    (TextView) convertView.findViewById(R.id.txt2);
            convertView.setTag(viewHolder);

        } else {
            viewHolder          =   (ViewHolder) convertView.getTag();
        }


        Employee employee    =   (Employee) getItem(position);
        viewHolder.txt1.setText(employee.getName());
        viewHolder.txt2.setText(employee.getPlace());


        return convertView;
    }

}
