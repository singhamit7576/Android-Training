package com.ui.View_Pager_Fragment;

import android.graphics.Color;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import com.example.listview.R;
import com.ui.activities.BaseClass;

public class Activity extends BaseClass {

    private ViewPager view;
    private PagerTabStrip pagerTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        this.setReference();
        this.OnListener();
    }

    @Override
    protected void setReference() {
        view             =   (ViewPager)     findViewById(R.id.view);
        pagerTabStrip    =   (PagerTabStrip) findViewById(R.id.tab_strip);
        pagerTabStrip.setBackgroundColor(Color.WHITE);
        pagerTabStrip.setTextColor(Color.RED);

    }

    @Override
    protected void OnListener() {
        view.setAdapter(new FragmentAdapter(getSupportFragmentManager(),this));
    }

    @Override
    public void onBackPressed() {
        if (view.getCurrentItem()   == 0) {
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            view.setCurrentItem(view.getCurrentItem() - 1);
        }
    }

}
