package com.ui.view_pager_Tablayout;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.example.listview.R;
import com.ui.activities.BaseClass;

import java.util.ArrayList;
/**
 * Tab_Layout extends my abstract class and
 * implements  TabLayout.OnTabSelectedListener.
 */
public class Tab_Layout extends BaseClass implements TabLayout.OnTabSelectedListener,Communication {

    private ViewPager view_pager;
    TabLayout tab_header;
    int [] imageid;
    final int length=2;
    private int poistion;
    private ArrayList<Fragment>fragments= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab__layout);
        this.array();
        this.setFrgaments();
        this.setReference();
        this.OnListener();

    }

    private void setFrgaments() {
        fragments     =  new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
    }

    private void array() {
        imageid     =   new int[] {
                R.drawable.image1,
                R.drawable.images5,
                R.drawable.images7
        };
    }

    @Override
    protected void setReference() {
        view_pager      =     (ViewPager)  findViewById(R.id.view_pager);
        tab_header      =     (TabLayout)  findViewById(R.id. tab_header);

        this.setTextTabLayout();
        this.setImage();
    }

    private void setImage() {
        for(int i = 0 ; i <= length ; i++){
            tab_header.getTabAt(i).setIcon(imageid[i]);
        }
//        tab_header.getTabAt(0).setIcon(imageid[0]);
//        tab_header.getTabAt(1).setIcon(imageid[1]);
//        tab_header.getTabAt(2).setIcon(imageid[2]);
    }

    private void setTextTabLayout() {



        for(int  i = 0 ; i <= length ;i++){
            tab_header.addTab(tab_header.newTab().setText("Image "+(i+1)));
        }


//        tab_header.addTab(tab_header.newTab().setText("Tab 1"));
//        tab_header.addTab(tab_header.newTab().setText("Tab 2"));
//        tab_header.addTab(tab_header.newTab().setText("Tab 3"));
        tab_header.setTabGravity(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void OnListener() {
        this.setAdapter();
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_header));
        tab_header.setOnTabSelectedListener(this);
    }

    private void setAdapter() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(),fragments);
        view_pager.setAdapter(tabAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        view_pager.setCurrentItem(tab.getPosition());
        poistion = tab.getPosition();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }


    @Override
    public void setCommunication(String msg) {
        Log.e("" , "Message " + msg);


        if(poistion == 0) {
            Fragment2 fragment2          =  (Fragment2) ((TabAdapter) view_pager.getAdapter()).getItem(1);
            fragment2.setReceived(msg);
            Log.e("", "Message " + msg);
        }
        else{
            Fragment3 fragment3          =  (Fragment3) ((TabAdapter)view_pager.getAdapter()).getItem(2);
            fragment3.setReceived(msg);
        }

    }


    @Override
    public void onBackPressed() {
        if (view_pager.getCurrentItem() == 0) {
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            view_pager.setCurrentItem(view_pager.getCurrentItem() - 1);
        }
    }

}
