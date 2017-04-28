package com.example.database.DATABSE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.database.R;
import com.example.database.Ui.Activities.BaseActivity;
import com.example.database.utils.Utils;

public class Acitivity extends BaseActivity implements View.OnClickListener {

    private  Student student ;
    private StudentTable studentTable = new StudentTable(this) ;
    private TextView tv_viewall ;
    private Button btnretrive , btninsert , btnupdate , btndelete , btnclear ,btnviewall;
    private EditText edt_id , edt_name , edt_fname , edt_address ;
    private String name ,fname ,address , id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        student = new Student() ;

        edt_id          = (EditText) findViewById(R.id.edt_id);
        edt_name        = (EditText) findViewById(R.id.edt_name);
        edt_fname       = (EditText) findViewById(R.id.edt_fname);
        edt_address     = (EditText) findViewById(R.id.edt_address);
        btnretrive      = (Button)   findViewById(R.id.btnretrive);
        btninsert       = (Button)   findViewById(R.id.btninsert);
        btnupdate       = (Button)   findViewById(R.id.btnupdate);
        btndelete       = (Button)   findViewById(R.id.btndelete);
        btnclear        = (Button)   findViewById(R.id.btnclear);
        btnviewall      = (Button)   findViewById(R.id.btnviewall);
        tv_viewall      = (TextView) findViewById(R.id.tv_viewall);

    }

    @Override
    protected void onListener() {

        btninsert.setOnClickListener(this);
        btnretrive.setOnClickListener(this);
        btnupdate.setOnClickListener(this);
        btndelete.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        btnviewall.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnretrive :
                this.retriveData();
                break;

            case R.id.btninsert :
                this.insertData();
                break;

            case R.id.btnupdate :
                this.updateData();
                break;

            case R.id.btndelete :
                this.deleteData();

                break;
            case R.id.btnclear :
                clearData();
                break;
            case R.id.btnviewall :
                this.viewAllData();
                break;
        }

    }

    private void viewAllData() {
        studentTable.openConnection();
        String data = studentTable.viewAll();

        tv_viewall.setText(data);
        studentTable.closeConeection();
    }

    private void deleteData() {
        String id1 = edt_id.getText().toString() ;
        if(id1.trim().length()==0)
        {
            Utils.show(this , "Please enter id");
            return;
        }else {
            studentTable.openConnection();
            studentTable.deleteData(id1);
            studentTable.closeConeection();

        }
    }

    private void updateData() {
        String id2 = edt_id.getText().toString() ;
        if(id2.trim().length()==0)
        {
            Utils.show(this, "Please enter Rollno");
            return;
        }else{
            studentTable.openConnection();
            studentTable.updateData(id2);
            studentTable.closeConeection();
        }
    }

    private void insertData() {
        getdata();
        studentTable.openConnection();
        studentTable.insertData();
        studentTable.closeConeection();
        clearData();
    }

    private void retriveData() {

        String id = edt_id.getText().toString() ;
        if(id.trim().length()==0)
        {
            Utils.show(this, "Please enter id");
            return;
        }else{

            studentTable.openConnection();
            student =  studentTable.retriveData(id);
            this.setData(student);
            studentTable.closeConeection();
        }
    }


    private void clearData() {
        edt_id.setText("");
        edt_name.setText("") ;
        edt_fname.setText("") ;
        edt_address.setText("") ;
    }

    private void setData(Student student) {
        edt_id.setText(""+student.getId());
        edt_name.setText(student.getName()) ;
        edt_fname.setText(student.getLastname()) ;
        edt_address.setText(student.getAddress()) ;
    }

    public void getdata() {
        id      = edt_id.getText().toString() ;
        name    = edt_name.getText().toString() ;
        fname   = edt_fname.getText().toString() ;
        address = edt_address.getText().toString() ;
        student.setId(Integer.parseInt(id));
        student.setName(name);
        student.setLastname(fname);
        student.setAddress(address);
        studentTable = new StudentTable(this , student) ;
    }







}
