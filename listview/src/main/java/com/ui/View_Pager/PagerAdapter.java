package com.ui.View_Pager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import com.example.listview.R;

/**
 * Created by user on 10/3/17.
 */
public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    Context context;
    int img[];
    String [] rank;
    LayoutInflater  inflater;

    public PagerAdapter( Context context,String [] rank,int[] img) {
        /*make constructor
        * pass rank,context for current state
        */
        this.rank   =  rank;
        this.img    =   img;
        this.context    =   context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView txtrank;
        ImageView immg;

        /*Container The containing View in which the page will be shown.
        Position The page position to be instantiated.
        Returns an Object representing the new page*/

        inflater            =   (LayoutInflater) context .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View convertview    =   inflater.inflate(R.layout.viewpager_item,null);
        txtrank             =   ( TextView) convertview.findViewById(R.id.rank);
        txtrank.setText(rank[position]);
        immg                =    (ImageView) convertview.findViewById(R.id.img);
        immg.setImageResource(img[position]);
        ((ViewPager)container).addView(convertview);
        return convertview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
    @Override
    public int getCount()
    {
        /*retun lenth*/
        return rank.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view     ==   ((RelativeLayout)object);
    }




}

