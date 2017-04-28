package com.ui.ListviewCheckbox;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.listview.R;

import java.util.ArrayList;

/**
 * Custom ListAdapter which extends BaseAdapter.
 */
public class ListAdapter extends BaseAdapter  {

    Context context;
    ArrayList<Student>studentlist;
    LayoutInflater inflater;

    /*create Constructor*/
    public ListAdapter(Context context, ArrayList<Student> studentlist) {
        this.context        =    context;
        this.studentlist    =   studentlist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public ArrayList<Student> getStudentlist() {
//        return studentlist;
//    }
//
//    public void setStudentlist(ArrayList<Student> studentlist) {
//        this.studentlist = studentlist;
//    }

    /**
     * create ViewHolder class and set id of
     * each widgets.
     */
    public  class ViewHolderr{
        TextView txt_name,txt_result;
        Button btn_accept,btn_decline;
        CheckBox checkbox;
        public ViewHolderr(View view){

            txt_name         =  (TextView)  view.findViewById(R.id.txt_name);
            btn_accept       =  (Button)    view.findViewById(R.id.btn_accept);
            btn_decline      =  (Button)     view.findViewById(R.id.btn_decline);
            txt_result       =   (TextView)  view.findViewById(R.id.txt_result);
            checkbox         = (CheckBox)     view.findViewById(R.id.checkbox);
        }
    }

    /**
     * in getview,we infalte our layout
     * and create viewHolader Object .
     * and call two method for Listner.
     */
    @Override
    public View getView(final int position,  View convertView,  ViewGroup parent) {
        ViewHolderr viewHolderr = null;
        if(convertView == null){
            convertView     =    inflater.inflate(R.layout.checklistview,null);
            viewHolderr     =    new ViewHolderr(convertView);
            convertView.setTag(viewHolderr);

        } else{
            viewHolderr     = (ViewHolderr)convertView.getTag();
        }


        final Student  student   =   (Student) getItem(position);
        viewHolderr.txt_name.setText(student.getName());
        viewHolderr.txt_result.setTag(position);


       // viewHolderr.checkbox.setTag(position);//set tag
        viewHolderr.checkbox.setChecked(studentlist.get(position).isSelected());
        viewHolderr.txt_result.setText(studentlist.get(position).getTextSet());



        if(student.isCheck()){

            viewHolderr.btn_accept.setVisibility(View.GONE);
            viewHolderr.btn_decline.setVisibility(View.GONE);
            viewHolderr.txt_result.setVisibility(View.VISIBLE);
        }else{

            viewHolderr.btn_accept.setVisibility(View.VISIBLE);
            viewHolderr.btn_decline.setVisibility(View.VISIBLE);
            viewHolderr.txt_result.setVisibility(View.GONE);
        }


        final ViewHolderr finalViewHolderr = viewHolderr;
        viewHolderr.btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Log.i("TAG", "onClicked ");
                studentlist.get(position).setTextSet("Accepted");
                student.setCheck(true);
                finalViewHolderr.txt_result.setVisibility(View.GONE);
                notifyDataSetChanged();
            }
        });

        viewHolderr.btn_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentlist.get(position).setTextSet("Declined");
                student.setCheck(true);
                finalViewHolderr.txt_result.setVisibility(View.VISIBLE);
                notifyDataSetChanged();


            }
        });
        this.checkBoxState(viewHolderr,position);
        this.listner(finalViewHolderr,position);
        return convertView;
    }

    /**
     * this method save the state of checkbox
     */
    private void checkBoxState(ViewHolderr viewHolderr, final int position) {
//        viewHolderr.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                int getPosition = (Integer) buttonView.getTag();//get the button state from setTag.
//                studentlist.get(getPosition).setSelected(buttonView.isChecked());// Set the value of checkbox to maintain its state.
//            }
//        });
//
        viewHolderr.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentlist.get(position).setSelected( !studentlist.get(position).isCheck());
                notifyDataSetChanged();
            }
        });


    }


    /**
     * this method called for button listner.
     * */
    private void listner(final ViewHolderr viewHolderr, final int position) {

    }


    @Override
    public int getCount() {
        return studentlist.size();
    }

    @Override
    public Object getItem(int position) {
        return studentlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return studentlist.indexOf(getItem(position));
    }




}
