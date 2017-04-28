package com.example.mythread.ui.JsonList;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonListActivity extends BaseActivity {



    private ListView ListView;
    SimpleAdapter  adapter;
    List<Contact> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_list);

        this.setReference();
        this.Adpater();

        this.onListener();
    }

    @Override
    protected void setReference() {

        ListView   = (ListView) findViewById(R.id.listView);

    }

    public String loadAsset() {

        String json = null;
        try {

            InputStream inputStream = getAssets().open("jsonfile.json");

            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            inputStream.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    @Override
    protected void onListener() {


        try {
            this.result();
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    private List<Contact> result() throws JSONException {



        JSONArray arr = new JSONArray(loadAsset());

        for (int i=0; i < arr.length(); i++) {

            itemList.add(convertContact(arr.getJSONObject(i)));

        }

        return itemList;


    }

    private Contact convertContact(JSONObject  obj) throws JSONException  {


        String area = obj.getString("area");
        String city = obj.getString("city");

        return new Contact(area,city);

    }

    private void Adpater() {

        adapter = new SimpleAdapter(itemList,this);

        ListView.setAdapter(adapter);

    }




}
