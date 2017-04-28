package com.ui.Expandable_ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.listview.R;


import java.util.ArrayList;

public class MyBaseExpandable extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group> group ;


    public MyBaseExpandable(Context context, ArrayList<Group> group) {

        /* constructor
         * of MyBaseExpndable Adapter */
        this.context     =  context;
        this.group       =      group;

    }

    @Override
    public int getGroupCount() {

        /* Return the size of ArrayList */
        return group.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return group.get(groupPosition).getItems().size();

    }


    public static class ViewHoldreChild{
        private TextView child1;

    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LayoutInflater inflater      =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        child mchild                 =  (child) getChild(groupPosition, childPosition);
        ViewHoldreChild viewHoldreChild;

        /* if convertView is null then
        * child layout will be inflate.
        * and this is child view(child)*/

        if (convertView  ==     null) {
            convertView              =      inflater.inflate(R.layout.child, null);
            viewHoldreChild          =      new ViewHoldreChild();
            viewHoldreChild.child1   =      (TextView) convertView.findViewById(R.id.child1);
            convertView.setTag(viewHoldreChild);
        }
        else {
            viewHoldreChild     =   (ViewHoldreChild) convertView.getTag();
        }
        viewHoldreChild.child1.setText(mchild.getName());
        return convertView;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        /* if convertView is null then
        * child layout will be inflate.
        * and this is Gruop view (Parent)*/

        LayoutInflater inflater      =      (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolderGroup viewHolderGroup;
        Group mGroup     =   (Group) getGroup(groupPosition);
        if( convertView == null) {

            convertView                  =      inflater.inflate(R.layout.groups, null);
            viewHolderGroup              =      new ViewHolderGroup();
            viewHolderGroup.gruop_txt    =       (TextView) convertView.findViewById(R.id.gruop_txt);
            convertView.setTag(viewHolderGroup);
        }else{
            viewHolderGroup               =          (ViewHolderGroup) convertView.getTag();
        }
        viewHolderGroup.gruop_txt.setText(mGroup.getName());
        return convertView;
    }

    public static class ViewHolderGroup{
        TextView gruop_txt;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return group.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return group.get(groupPosition).getItems().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
