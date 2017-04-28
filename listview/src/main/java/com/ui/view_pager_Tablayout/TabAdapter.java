package com.ui.view_pager_Tablayout;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;


/**
 * Created by user on 20/3/17.
 */
public class TabAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments    = null;


    public TabAdapter(FragmentManager fm, ArrayList fragments) {
        super(fm);
        this.fragments  = fragments;

//        fragments = new ArrayList<Fragment>();
//        fragments.add(new Fragment1());
//        fragments.add(new Fragment2());
//        fragments.add(new Fragment3());
    }


    @Override
    public  Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }
}
