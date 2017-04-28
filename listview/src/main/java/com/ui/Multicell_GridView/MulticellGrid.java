package com.ui.Multicell_GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.R;
import com.ui.demo.Employee;
import com.ui.withHolder.MyBaseAdapater;

import java.util.List;

/**
 * Created by user on 9/3/17.
 */
public class    MulticellGrid extends BaseAdapter {

    private List<Employee>mylist;
    private Context context;
    public static final int TYPE_ODD = 0;
    public static final int TYPE_EVEN = 1;
    //public static final int TYPE_E_WHITE = 2;

    public MulticellGrid(List<Employee> mylist, Context context) {
        /*create constructor pf
        * MulticellGrid*/
        this.mylist = mylist;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        //gettype of mylist
        return mylist.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

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
        return 0;
    }

    public static class ViewHolderM{
        public TextView txt;
        public TextView txt1;
        public TextView txt2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater  =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderM viewHolderM  =  new ViewHolderM();
        Employee emp     =   (Employee)getItem(position);

        int type    =    getItemViewType( position);
        if(convertView == null) {

            if( type == 0) {
                convertView          =      inflater.inflate(R.layout.multicell, null);
                viewHolderM.txt      =       (TextView) convertView.findViewById(R.id.txt);
                viewHolderM.txt.setText(emp.getName());

            }

            else if (type == 1){
                convertView           =   inflater.inflate(R.layout.simple1, null);
                viewHolderM.txt1      =   (TextView) convertView.findViewById(R.id.txt1);
                viewHolderM.txt1.setText(emp.getPlace());

            }
            else{
                convertView             =   inflater.inflate(R.layout.image, null);
                viewHolderM.txt2        =   (TextView) convertView.findViewById(R.id.txt2);
                viewHolderM.txt2.setText(""+emp.getAge());
            }


          //  viewHolderM.txt = (TextView) convertView.findViewById(R.id.txt);
            convertView.setTag(viewHolderM);
        }else{
            viewHolderM =(ViewHolderM) convertView.getTag();
        }


       // viewHolderM.txt.setText(emp.getName());
        return convertView;

    }
}
