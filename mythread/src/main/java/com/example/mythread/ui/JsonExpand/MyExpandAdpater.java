package com.example.mythread.ui.JsonExpand;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.view.LayoutInflater;
import com.example.mythread.R;
import java.util.List;

/**
 * create MyExpandAdapter which expand Base ExpandListAdapter.
 */
public class MyExpandAdpater extends BaseExpandableListAdapter {

    private List<Beacon> beaconInfoList = null;
    private Context context;
    LayoutInflater layoutInflater;
    public MyExpandAdpater(Context con,LayoutInflater inflater, List<Beacon> beaconInfoList){
        context = con;
        layoutInflater = inflater;
        this.beaconInfoList = beaconInfoList;

    }

    @Override
    public int getGroupCount() {
        return beaconInfoList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return beaconInfoList.get(groupPosition).getItems().size();
    }


    /**
     * craete ViewHolder Class
     * of parent Xml.
     */
    public  class ViewHolderParent {
        TextView parent_tv ;
        TextView beconid  ;
        TextView tv_beaconUUID  ;
        TextView tv_beaconVendor;
        TextView tv_major;
        TextView tv_minor  ;
        TextView tv_status    ;
        TextView tv_latitude   ;
        TextView tv_longitude;
    }


    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderParent viewHolder;
        viewHolder   = new ViewHolderParent();
        if (convertView     == null) {


            convertView = LayoutInflater.from(context).inflate(R.layout.parent, parent, false);
            viewHolder.parent_tv          =         (TextView)      convertView.findViewById(R.id.parent_tv);
            viewHolder.beconid            =         (TextView)      convertView.findViewById(R.id.beconid);
            viewHolder.tv_beaconUUID      =         (TextView)      convertView.findViewById(R.id.tv_beaconUUID);
            viewHolder.tv_beaconVendor    =         (TextView)      convertView.findViewById(R.id.tv_beaconVendor);
            viewHolder.tv_major           =         (TextView)      convertView.findViewById(R.id.tv_major);
            viewHolder.tv_minor           =         (TextView)      convertView.findViewById(R.id.tv_minor);
            viewHolder.tv_status          =         (TextView)      convertView.findViewById(R.id.tv_status);
            viewHolder.tv_latitude        =         (TextView)      convertView.findViewById(R.id.tv_latitude);
            viewHolder.tv_longitude       =         (TextView)      convertView.findViewById(R.id.tv_longitude);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder                    =   (ViewHolderParent) convertView.getTag();
        }
        viewHolder.beconid.setText(String.valueOf(beaconInfoList.get(groupPosition).getBeaconID()));
        viewHolder.parent_tv.setText(beaconInfoList.get(groupPosition).getBeaconName());
        viewHolder.tv_beaconUUID.setText(beaconInfoList.get(groupPosition).getBeaconUUID());
        viewHolder.tv_beaconVendor.setText(beaconInfoList.get(groupPosition).getBeaconVendor());
        viewHolder.tv_major.setText(String.valueOf(beaconInfoList.get(groupPosition).getMajor()));
        viewHolder.tv_minor.setText(String.valueOf(beaconInfoList.get(groupPosition).getMinor()));
        viewHolder.tv_status.setText(String.valueOf(beaconInfoList.get(groupPosition).isStatus()));
        viewHolder.tv_latitude.setText(String.valueOf(beaconInfoList.get(groupPosition).getLatitude()));
        viewHolder.tv_longitude.setText(String.valueOf(beaconInfoList.get(groupPosition).getLongitude()));
        return convertView;
    }

    /**
     * create child view holder class
     */
    public  class ChildViewHolder{
        TextView tv_adID ;
        TextView tv_adName  ;
        TextView tv_enabled;
        TextView tv_shopID;
        TextView tv_shopName  ;
        TextView tv_description    ;
        TextView tv_validUpTo   ;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildViewHolder childHolder = new ChildViewHolder();

        if (convertView     == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.child, parent, false);
            childHolder.tv_adID              =         (TextView)      convertView.findViewById(R.id.tv_adID);
            childHolder.tv_adName            =         (TextView)      convertView.findViewById(R.id.tv_adName);
            childHolder.tv_enabled           =         (TextView)      convertView.findViewById(R.id.tv_enabled);
            childHolder.tv_shopID            =         (TextView)      convertView.findViewById(R.id.tv_shopID);
            childHolder.tv_shopName          =         (TextView)      convertView.findViewById(R.id.tv_shopName);
            childHolder.tv_description       =         (TextView)      convertView.findViewById(R.id.tv_description);
            childHolder.tv_validUpTo         =         (TextView)      convertView.findViewById(R.id.tv_validUpTo);
            convertView.setTag(childHolder);
        }
        else {
            childHolder                    =   (ChildViewHolder) convertView.getTag();
        }

        childHolder.tv_adID.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).getAdID()));
        childHolder.tv_adName.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getAdName());
        childHolder.tv_enabled.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).isEnabled()));
        childHolder.tv_shopID.setText(String.valueOf(beaconInfoList.get(groupPosition).getItems().get(childPosition).getShopID()));
        childHolder.tv_shopName.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getShopName());
        childHolder.tv_description.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getDescription());
        childHolder.tv_validUpTo.setText(beaconInfoList.get(groupPosition).getItems().get(childPosition).getValidUpTo());
        return convertView;
    }


    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
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
