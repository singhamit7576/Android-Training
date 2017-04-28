package com.example.contentprovidertest.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contentprovidertest.R;

import java.util.List;


public class CustomAdapterArray extends BaseAdapter {

    private Context context;
    private List<ContactData>list;

    public CustomAdapterArray(Context context, List<ContactData>list) {
        this. context    =   context;
        this.list        =   list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView   ==  null){
            convertView  =  inflater.inflate(R.layout.lv_layout, null);
        }

        TextView tv_name   = (TextView) convertView.findViewById(R.id.tv_name);
        ImageView iv_photo  = (ImageView) convertView.findViewById(R.id.iv_photo);
        TextView tv_phoneNumber = (TextView) convertView.findViewById(R.id.tv_details);
        tv_name.setText(list.get(position).getName());
        iv_photo.setImageBitmap(list.get(position).getBitmap());
        tv_phoneNumber.setText(list.get(position).getPhoneNumber());

        return convertView;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
