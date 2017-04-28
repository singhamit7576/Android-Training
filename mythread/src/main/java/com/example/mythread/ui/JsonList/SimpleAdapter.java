package com.example.mythread.ui.JsonList;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.mythread.R;

import java.util.List;


public class SimpleAdapter extends ArrayAdapter {


    private List<Contact> itemList;
    private Context context;

    public SimpleAdapter(List<Contact> itemList, Context context) {
        super(context, android.R.layout.simple_list_item_1, itemList);
        this.itemList = itemList;
        this.context = context;
    }

    public int getCount() {
        if (itemList != null)
            return itemList.size();
        return 0;
    }

    public Contact getItem(int position) {
        if (itemList != null)
            return itemList.get(position);
        return null;
    }

    public long getItemId(int position) {
        if (itemList != null)
            return itemList.get(position).hashCode();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        if(convertView == null){

            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.list,null);
        }

        Contact contact = itemList.get(position);
        TextView text1 = (TextView) convertView.findViewById(R.id.Text1);

//        String data = null;
//        data = data +contact.getArea()+"\n "+contact.getCity();
//        text1.setText(data);




        StringBuffer buffer  = new StringBuffer();
        buffer.append(contact.getArea()).append("\n").append(contact.getCity());
        text1.setText(buffer);


        // text1.setText(contact.getArea());
        //   text1.setText(contact.getCity());


        return convertView;
    }



}
