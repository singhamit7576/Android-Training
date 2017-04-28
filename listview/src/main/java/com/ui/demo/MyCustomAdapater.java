package com.ui.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.R;
import com.ui.listview.RowItem;

import java.util.List;

/**
 * Created by user on 8/3/17.
 */
public class MyCustomAdapater extends BaseAdapter{

    private Context context;
    List<Employee>mylist;

    public MyCustomAdapater(Context context, List<Employee> mylist) {
          /* We create Constructor
           * and pass Conetxt for basic environment setup
            * and my List*/
        this.context    =   context;
        this.mylist  =   mylist;
    }

    @Override
    public int getCount() {
          /* get the Elements
           * in our List */
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
          /* In this method
         * we get position of our element */
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mylist.indexOf(getItem(position));
    }
    public static class ViewHolder{
        TextView txt1;
        TextView txt2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
          /* In getView ,
           * we inflate our layout if it is null */
        LayoutInflater inflater     =    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder;
        if (convertView  ==  null) {

            convertView      =       inflater.inflate(R.layout.custom_layout, null);
            viewHolder       =       new ViewHolder();
            viewHolder.txt1  =       (TextView) convertView.findViewById(R.id.txt1);
            viewHolder.txt2  =       (TextView)convertView.findViewById(R.id.txt2);
            convertView.setTag(viewHolder);

              /* create the Textview object and
               * use method called setTag */

        } else {
            viewHolder  =   (ViewHolder) convertView.getTag();
        }

         /* set the employee name and
         * employee place */
        Employee employee    =      (Employee) getItem(position);
        viewHolder.txt1.setText(employee.getName());
        viewHolder.txt2.setText(employee.getPlace());
        return convertView;
    }
}
