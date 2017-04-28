package com.ui.View_Pager;

import android.support.v4.view.*;
import android.os.Bundle;

import com.example.listview.R;
import com.ui.activities.BaseClass;

public class  View_Pager_Activity extends BaseClass {

    private ViewPager pager;
    private int[] img;
    private String [] rank;
    private android.support.v4.view.PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__pager_);
        this.array();
        this.setReference();
        this.OnListener();
    }

    private void array() {
        img     =   new int[]{  R.drawable.image1,R.drawable.images2,R.drawable.images3,
                R.drawable.images4,
                R.drawable.images5,R.drawable.images6,R.drawable.images7,
        };

        rank     =       new String[] { "Pic-1", "Pic-2", "Pic-3", "Pic-4", "Pic-5", "Pic-6", "Pic-7" };

    }

    @Override
    protected void setReference() {
        /*set Refrence of ViewPager*/

        pager    =  (ViewPager) findViewById(R.id.pager);

    }

    @Override
    protected void OnListener() {
        //create Object of page adpater and
        //pass this img and rank and context.
        pagerAdapter    =    new PagerAdapter(this,rank,img);
        pager.setAdapter(pagerAdapter);


    }
}
