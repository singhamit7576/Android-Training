package com.ui.List_View_Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ui.ListviewCheckbox.CheckActivity;
import com.ui.View_Pager.View_Pager_Activity;
import com.example.listview.R;
import com.ui.Expandable_ListView.Expandable_listview;
import com.ui.Gridview.Grid_activity;
import com.ui.Multicell_GridView.Multicell_Activity;
import com.ui.View_Pager_Fragment.Activity;
import com.ui.view_pager_Tablayout.Tab_Layout;
import com.ui.activities.BaseClass;
import com.ui.listview.MainActivity;
import com.ui.simpleListview.Simple_list_view;
import com.ui.withHolder.ListviewExample;


/**
 * Activty which extends BaseClass.
 * all Activity are start from here.
 */
public class List_view_Main extends BaseClass implements View.OnClickListener {


    private     Button  btn_simpleListview,btn_withoutholder,check;
    private     Button  btn_fragmentpager,btn_basewithholder;
    private     Button  btn_expand,btn_grid,btn_multicell,pager;
    private     Button  btn_tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view__main);
        this.setReference();
        this.OnListener();
    }

    @Override
    protected void setReference() {

        btn_simpleListview           = (Button) findViewById(R.id.btn_simpleListview);
        btn_withoutholder            = (Button) findViewById(R.id.btn_withoutholder);
        btn_expand                   = (Button) findViewById(R.id.btn_expand);
        btn_basewithholder           = (Button) findViewById(R.id.btn_basewithholder);
        btn_grid                     = (Button) findViewById(R.id.btn_grid);
        btn_multicell                = (Button) findViewById(R.id.btn_multicell);
        pager                        = (Button) findViewById(R.id.pager);
        check                        = (Button) findViewById(R.id.check);
        btn_fragmentpager            = (Button) findViewById(R.id.btn_fragmentpager);
        btn_tablayout                = (Button) findViewById(R.id.btn_tablayout);
    }

    @Override
    protected void OnListener() {
        btn_simpleListview.setOnClickListener(this);
        btn_multicell.setOnClickListener(this);
        btn_withoutholder.setOnClickListener(this);
        btn_basewithholder.setOnClickListener(this);
        btn_expand.setOnClickListener(this);
        btn_grid.setOnClickListener(this);
        pager.setOnClickListener(this);
        check.setOnClickListener(this);
        btn_fragmentpager.setOnClickListener(this);
        btn_tablayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_simpleListview:
                startActivity(new Intent(List_view_Main.this,Simple_list_view.class));
                break;
            case R.id.btn_withoutholder:
                startActivity(new Intent(List_view_Main.this,MainActivity.class));
                break;

            case R.id.btn_basewithholder:
                startActivity(new Intent(List_view_Main.this,ListviewExample.class));
                break;

            case R.id.btn_expand:
                startActivity(new Intent(List_view_Main.this,Expandable_listview.class));
                break;
            case R.id.btn_grid:
                startActivity(new Intent(List_view_Main.this,Grid_activity.class));
                break;
            case R.id.btn_multicell:
                startActivity(new Intent(List_view_Main.this,Multicell_Activity.class));
                break;
            case R.id.pager:
                startActivity(new Intent(List_view_Main.this,View_Pager_Activity.class));
                break;
            case R.id.check:
                startActivity(new Intent(List_view_Main.this,CheckActivity.class));
                break;
            case R.id.btn_fragmentpager:
                startActivity(new Intent(List_view_Main.this,Activity.class));
                break;
            case R.id.btn_tablayout:
                startActivity(new Intent(List_view_Main.this,Tab_Layout.class));
                break;


            default:
                break;

        }}
}
