package com.ui.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.listview.R;
import java.util.List;


public class MyAdapter extends BaseAdapter {

    private  Context context;
    private List<RowItem> rowItems;



    public MyAdapter(Context context, List<RowItem> rowItems) {
        /*Custom adapter which extends Base Adapter*/

        this.context = context;
        this.rowItems = rowItems;
    }
    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        /*inflate view*/

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertview == null){
            convertview = inflater.inflate(R.layout.list_item, null);
        }

        TextView label = (TextView) convertview.findViewById(R.id.label);
        label.setText(rowItems.get(position).getName());

        return convertview;

    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }


}
