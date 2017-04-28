package com.myapp.ui.Freagmentt;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;

/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements List_Fragmentt.Communication  Interface
 */
public class MainActivityyy extends BaseActivity implements List_Fragmentt.Communication {

    private String TAG   = this.getClass().getSimpleName();
    FrameLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityyy);

        utils.printLog(TAG,"Inside OnCreate ()");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"Outside OnCreate ()");

    }


    /**
     * check the Screen Mode
     * @return
     */
    private boolean dualPain(){

        boolean mboolean  =      getApplicationContext().getResources().getBoolean(R.bool.fragment);

        if(mboolean){
            return true;
        }else{
            return false;
        }

    }

    public void addFragment(){

        if(this.dualPain()) {}
        else{
            this.list();
        }
    }

    private void list(){

        List_Fragmentt mList_fragmentt      =       new List_Fragmentt();
        FragmentTransaction ft              =       getFragmentManager().beginTransaction();
        ft.add(R.id.container, mList_fragmentt);
        // ft.addToBackStack(null);
        ft.commit();
    }


    /**
     * This is Interface Method
     * which enable
     * communication between fragments.
     * @param msg
     */
    @Override
    public void setCommunication(String msg) {

        if(this.dualPain()) {

            Detail_Fragmentt detail_fragmentt     =     (Detail_Fragmentt) getFragmentManager().findFragmentById(R.id.frag_Two);
            if (detail_fragmentt     !=     null) {
                detail_fragmentt.setReceived(msg);
            }
        }
        else{
            Detail_Fragmentt mDetail_fragmentt      =       new Detail_Fragmentt();
            this.replace(mDetail_fragmentt);
            Bundle bundle= new Bundle();
            bundle.putString("KEY",msg);
            mDetail_fragmentt.setArguments(bundle);
        }
    }


    /**
     * mathod in which we replace
     * the List Fragmen.
     * @param mDetail_fragmentt
     */
    private void replace(Detail_Fragmentt mDetail_fragmentt ){

        FragmentTransaction  mFragmentTransaction     =       getFragmentManager().beginTransaction();
        mFragmentTransaction.setCustomAnimations(R.animator.left,R.animator.right,R.animator.left,R.animator.right);
        mFragmentTransaction.replace(R.id.container, mDetail_fragmentt);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    /**
     * method for back pressed from
     * second fragment.
     */
    @Override
    public void onBackPressed() {

        utils.printLog(TAG,"inside OnBackPressed");

        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * set Refrence of Container.
     */
    @Override
    protected void setReference() {

        container       =      (FrameLayout) findViewById(R.id.container);
        this.addFragment();
    }

    @Override
    protected void OnListener() {

    }




}
