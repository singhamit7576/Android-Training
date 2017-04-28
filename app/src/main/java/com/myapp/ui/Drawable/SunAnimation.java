package com.myapp.ui.Drawable;


import android.nfc.Tag;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.view.animation.Animation;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods.
 */

public class SunAnimation extends BaseActivity {

    private ImageView sun,hour,watch;
    private Animation animClock,animSun,animhour;
    private String TAG  = this.getClass().getSimpleName();


    /**
     * create Activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_animation);

        utils.printLog(TAG, "Inside Create()");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG, "Outside Create()");
    }


    /**
     * SetRefrences of sun,watch,
     * and hour
     */
    @Override
    protected void setReference() {
        utils.printLog(TAG," Inside setReference()");

        sun              =      (ImageView)  findViewById(R.id.sun);
        watch            =      (ImageView)findViewById(R.id.watch);
        hour             =      (ImageView)findViewById(R.id.hourr);
        //grass         =      (ImageView)findViewById(R.id.grass);


        utils.printLog(TAG,"Outside setReference ()");
    }


    /**
     * create Animation Utils,
     * and load the animation with our custom
     * object motions ,rotation of sun .
     * and override methods of Animation.
     * Start The Animation.
     */
    @Override
    protected void OnListener() {                                                   //start the animation.
        utils.printLog(TAG,"Inside OnListener ()");
        this.loadAnimations();
        this.startAnimations();

        animSun.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //OnListener();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        utils.printLog(TAG,"Outside OnListener ()");
    }


    /**
     * start Animations
     */
    private void startAnimations() {

        sun.startAnimation(animSun);//start Animation.
        watch.startAnimation(animClock);
        hour.startAnimation(animhour);
    }


    /**
     * load Animations
     */
    private void loadAnimations() {
        animSun             =   AnimationUtils.loadAnimation(this, R.anim.object_motion);
        animClock           =   AnimationUtils.loadAnimation(this, R.anim.rotation);
        animhour            =   AnimationUtils.loadAnimation(this,R.anim.hour_rotation);
    }
}
