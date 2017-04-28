package com.ui.View_Pager_Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 20/3/17.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    Context context;
    final  int NUM_PAGES    =   4;
    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context        = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment    =  new PagerFragment();
        Bundle bundle        =  new Bundle();
        bundle.putInt("key",position+1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ("TAB"+ (position+1));
    }
}
