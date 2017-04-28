package com.example.mythread.ui.JsonExpand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;
import com.google.gson.Gson;

public class RevreseJson extends BaseActivity {

    TextView tv_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_object_acitvity);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {


        tv_json = (TextView)  findViewById(R.id.tv_json);

    }

    @Override
    protected void onListener() {



        Gson gson = new Gson();
        Parser parser = new Parser(this);
        Data  data = parser.parsedData();
        String mString = gson.toJson(data);
        tv_json.setText(mString);



    }
}
