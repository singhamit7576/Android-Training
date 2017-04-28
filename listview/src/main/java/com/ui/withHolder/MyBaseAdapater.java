package com.ui.withHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.listview.R;
import com.ui.listview.RowItem;
import java.util.List;

public class MyBaseAdapater extends BaseAdapter {

//    public static final int TYPE_ODD = 0;
//    public static final int TYPE_EVEN = 1;
    private Context context;
    private List<RowItem> rowItems;

    public MyBaseAdapater(Context context, List<RowItem>rowItems ) {
        /*created a constructor
        * of MyBase Adpater*/
        this.context    = context;
        this.rowItems    = rowItems;
    }

    public static class ViewHolder{
        /*create an class named as VieHolder.
        ViewHolder pattern will create a static instance of the ViewHolder
        and attach it to the view item the first time it is loaded,

         and then it will be retrieved from that view tag on the future calls.*/
        public TextView label;
        //public ImageView image;
//        public TextView txtview;
//        TextView Simple;
        public TextView txt;


    }


    @Override

    public View getView(final int position, View convertview, ViewGroup parent) {

        LayoutInflater inflater         =        (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewHolder;
        viewHolder   = new ViewHolder();//create object of View holder
        if (convertview     == null) {

//            if(getItemViewType( position) == 1) {
//                convertview = inflater.inflate(R.layout.multicell, null);
//            }
//            else{
//                convertview = inflater.inflate(R.layout.simple1, null);
//            }
//            else if(getItemViewType(position) == TYPE_EVEN){
//                convertview = inflater.inflate(R.layout.simple1,null);
//            }

                /*if View is null
                * then oue layout will inflate*/


            convertview         =   inflater.inflate(R.layout.items_list, null);
            viewHolder.label    =   (TextView) convertview.findViewById(R.id.label);
            viewHolder.txt      =   (TextView)convertview.findViewById(R.id.txt);
            convertview.setTag(viewHolder);
        }
        else {
            viewHolder          =   (ViewHolder) convertview.getTag();
        }
        RowItem rowItem         =   (RowItem) getItem(position);
        viewHolder.label.setText(rowItem.getName());
        return convertview;
    }

    @Override
    public int getCount() {

        /*get the size of rowitems*/
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        /*get item position of
        * rowitems*/

        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItems.indexOf(getItem(position));
    }



//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return rowItems.get(position).getType();
//
//    }



}




