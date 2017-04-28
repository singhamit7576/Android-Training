package com.example.mythread.ui.Thread_Main_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;
import com.example.mythread.ui.JSON.JsonAcitivty;
import com.example.mythread.ui.JsonExpand.JsonExpandActivity;
import com.example.mythread.ui.JsonExpand.RevreseJson;
import com.example.mythread.ui.JsonList.JsonListActivity;
import com.example.mythread.ui.Thread.AsynTask;
import com.example.mythread.ui.Thread.Handler_Acitvity;
import com.example.mythread.ui.Thread.TimerAcitivity;
import com.example.mythread.ui.ThreadAsyn.Handler_Task;
import com.example.mythread.ui.ThreadAsyn.MyAsynTask;
import com.example.mythread.ui.ThreadAsyn.MyThreadRunOnUi;
import com.example.mythread.ui.XmlPasringArray.MainActivity;
import com.example.mythread.ui.XMlParsing.ParseActivity;

public class MyThread_Activity extends BaseActivity implements View.OnClickListener {


    private Button btn_Timer,btn_handler,btn_AsynTask,btn_textdownload,
            btn_Time_Data,Btn_Xml_Parse,btn_json,btn_jsonlist,
            btn_handler_data,Btn_Xml_Parse_List,btn_jsonExpand, btn_reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_thread_);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {


        btn_Timer           = (Button)   findViewById(R.id.btn_Timer);
        btn_handler         = (Button)   findViewById(R.id.btn_handler);
        btn_AsynTask        = (Button)   findViewById(R.id.btn_AsynTask);
        btn_textdownload    = (Button)   findViewById(R.id.btn_textdownload);
        btn_Time_Data       = (Button)   findViewById(R.id.btn_Time_Data);
        btn_handler_data    = (Button)   findViewById(R.id.btn_handler_data);
        Btn_Xml_Parse       = (Button)   findViewById(R.id.Btn_Xml_Parse);
        Btn_Xml_Parse_List  = (Button)   findViewById(R.id.Btn_Xml_Parse_List);
        btn_json            = (Button)   findViewById(R.id.btn_json);
        btn_jsonlist        = (Button)   findViewById(R.id.btn_jsonlist);
        btn_jsonExpand      = (Button)   findViewById(R.id.btn_jsonExpand);
        btn_reverse         = (Button)   findViewById(R.id.btn_reverse);
    }

    @Override
    protected void onListener() {

        btn_Timer.setOnClickListener(this);
        btn_handler.setOnClickListener(this);
        btn_AsynTask.setOnClickListener(this);
        btn_textdownload.setOnClickListener(this);
        btn_Time_Data.setOnClickListener(this);
        btn_handler_data.setOnClickListener(this);
        Btn_Xml_Parse.setOnClickListener(this);
        Btn_Xml_Parse_List.setOnClickListener(this);
        btn_json.setOnClickListener(this);
        btn_jsonlist.setOnClickListener(this);
        btn_jsonExpand.setOnClickListener(this);
        btn_reverse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.btn_Timer:

                startActivity(new Intent(MyThread_Activity.this, TimerAcitivity.class));
                break;


            case R.id.btn_handler:
                startActivity(new Intent(MyThread_Activity.this, Handler_Acitvity.class));

                break;

            case R.id.btn_AsynTask:
                startActivity(new Intent(MyThread_Activity.this, AsynTask.class));

                break;

            case R.id.btn_textdownload:
                startActivity(new Intent(MyThread_Activity.this, MyAsynTask.class));

                break;

            case R.id.btn_handler_data:
                startActivity(new Intent(MyThread_Activity.this, Handler_Task.class));

                break;

            case R.id.btn_Time_Data:
                startActivity(new Intent(MyThread_Activity.this, MyThreadRunOnUi.class));

                break;

            case R.id.Btn_Xml_Parse:
                startActivity(new Intent(MyThread_Activity.this, ParseActivity.class));

                break;

            case R.id.Btn_Xml_Parse_List:
                startActivity(new Intent(MyThread_Activity.this, MainActivity.class));

                break;
            case R.id.btn_jsonlist:
                startActivity(new Intent(MyThread_Activity.this, JsonListActivity.class));

                break;
            case R.id.btn_json:
                startActivity(new Intent(MyThread_Activity.this, JsonAcitivty.class));

                break;

            case R.id.btn_jsonExpand:
                startActivity(new Intent(MyThread_Activity.this, JsonExpandActivity.class));

                break;



            case R.id.btn_reverse:
                startActivity(new Intent(MyThread_Activity.this, RevreseJson.class));

                break;
        }


    }
}
