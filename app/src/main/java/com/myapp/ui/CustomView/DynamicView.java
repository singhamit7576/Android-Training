package com.myapp.ui.CustomView;

import android.os.Bundle;
import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;
import com.myapp.ui.utils.utils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
/**
 * create Activity
 *  which Extends Abstract class BAseActivity
 *  which have Some  Abstract Methods
 *  And Implements OnClickListener Interface
 */

public class DynamicView extends BaseActivity implements View.OnClickListener {

    private LinearLayout linearLayout;
    private Button btn_add,btn_remove;
    private  String TAG     =   this.getClass().getSimpleName();


    /**
     *  Activity created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view);

        utils.printLog(TAG,"Inside Create");

        this.setReference();
        this.OnListener();

        utils.printLog(TAG,"Outside Create");

    }


    /*Set reference of
        * button add
        * Linear layout*/
    @Override
    protected void setReference() {


        utils.printLog(TAG,"Inside setReference");

        btn_add          =       (Button)   findViewById(R.id.btn_add);
        btn_remove       =       (Button)   findViewById(R.id.btn_remove);
        linearLayout     =       (LinearLayout)  findViewById(R.id.linearlayout);

        utils.printLog(TAG,"Outside setReference");
    }


    /**
     * set Listener on
     * Buttons.
     */
    @Override
    protected void OnListener() {

        utils.printLog(TAG,"Inside OnListener");

        btn_add.setOnClickListener(this);
        btn_remove.setOnClickListener(this);

        utils.printLog(TAG,"Outside OnListener");
    }


    /**Use switch  which get id og Eacjh
     *  Buttons and set the
     *  button add and btn_remove.
     */

    @Override
    public void onClick(View v) {


        switch(v.getId())
        {
            case R.id.btn_add:

                this.addview(this.getView());
                break;

            case R.id.btn_remove:

                this.removeException();
                break;
        }
    }

    private void removeException() {

        utils.printLog(TAG,"Inside removeException");

        try {

            this.remove();
        }
        catch(EmptyException e){

            utils.show(this,e.toString());
        }

        utils.printLog(TAG,"Inside removeException");
    }


    /**
     * Method ,In which
     * Linear Layout add.
     * @param view
     */
    private void addview(View view) {
        linearLayout.addView(view);
    }

    private View getView(){

        View view                    =          getLayoutInflater().inflate(R.layout.items,linearLayout,false);
        final Button btn_item        =          (Button)    view.findViewById(R.id.btn_item);
        final EditText item_et       =          (EditText)   view.findViewById(R.id.item_et);
        btn_item.setTag(1);
        btn_item.setText("SAVE");

        btn_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message        =      item_et.getText().toString();
                if(!message.equals("")) {
                    final  int value     = (Integer) v.getTag();

                    if(value     ==     1){

                        this.resetBtn();
                        btn_item.setText("CLICKED");
                        Toast.makeText(DynamicView.this, message, Toast.LENGTH_SHORT).show();
                        v.setTag(0);

                    }

                    else{

                        btn_item.setText("SAVE");
                        v.setTag(1);
                    }

                }
                else{
                    Toast.makeText(DynamicView.this, "Please Enter Something", Toast.LENGTH_SHORT).show();
                }



            }

            private void resetBtn() {

                utils.printLog(TAG,"Inside reset");

                int id      =   linearLayout.getChildCount();

                for(int i   =  0  ; i < id ; i ++){

                    View view            =      linearLayout.getChildAt(i);
                    Button btn_item      =       (Button)    view.findViewById(R.id.btn_item);
                    btn_item.setText("save");
                    btn_item.setTag(1);
                }
            }

        });

        return view;

    }



    private void remove() throws EmptyException {

        int size     =  linearLayout.getChildCount();
        if (size >  0) {
            linearLayout.removeViewAt(size-1);
        }
        else{
            throw new EmptyException("please add an item ");
            // utils.show(this,"plz enter row");
        }
    }




}
