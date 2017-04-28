package com.example.storagesharedprefrences.ui.Activities.ui.InternalAndExternalStorage;

import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.storagesharedprefrences.R;
import com.example.storagesharedprefrences.ui.Activities.ui.BaseActivity.BaseActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalStorage extends BaseActivity implements View.OnClickListener {

    private EditText myInputText;
    private TextView responseText;
    private Button btn_saveInternalstorage,btn_readInternalstorage,
                   btn_saveExternalStorage,btn_readExtrenalStorage;
    private String myData = "";
    private String filename = "MySampleFile.txt";
    private File myExternalFile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        this.setReferences();
        this.onListener();
    }

    @Override
    protected void setReferences() {
        myInputText                 =  (EditText)      findViewById(R.id.myInputText);
        responseText                =  (TextView)      findViewById(R.id.responseText);
        btn_saveInternalstorage     =  (Button)        findViewById(R.id.btn_saveInternalstorage);
        btn_readInternalstorage     =  (Button)        findViewById(R.id.btn_readInternalstorage);
        btn_saveExternalStorage     =  (Button)        findViewById(R.id.btn_saveExternalStorage);
        btn_readExtrenalStorage     =  (Button)        findViewById(R.id.btn_readExtrenalStorage);
    }


    @Override
    protected void onListener() {
        btn_saveInternalstorage.setOnClickListener(this);
        btn_readInternalstorage.setOnClickListener(this);
        btn_saveExternalStorage.setOnClickListener(this);
        btn_readExtrenalStorage.setOnClickListener(this);
        this.availableExternalStorage();
    }

    private void availableExternalStorage() {


        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            btn_saveExternalStorage.setEnabled(false);
        }
        else {
            String filepath = "MyFileStorage";
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
    }


    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_saveInternalstorage:
                this.saveDataInternalStorage();
                break;

            case R.id.btn_readInternalstorage:
                this.readDataInternalStorage();
                break;

            case R.id.btn_saveExternalStorage:
                this.saveDataExternalStorage();
                break;

            case R.id.btn_readExtrenalStorage:
                this.readDataExternalStorage();
                break;
        }
    }

    private void readDataExternalStorage() {

        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        myInputText.setText(myData);
        responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
    }

    private void saveDataExternalStorage() {
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(myInputText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        myInputText.setText("");
        responseText
                .setText("MySampleFile.txt saved to External Storage...");

    }


    private void saveDataInternalStorage() {

        try {
            FileOutputStream fos     =      this.openFileOutput(filename, MODE_PRIVATE);
            fos.write(myInputText.getText().toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myInputText.setText("");
        responseText.setText("MySampleFile.txt saved to Internal Storage...");
    }

    private void readDataInternalStorage() {

        try {
            FileInputStream fis     =        this.openFileInput(filename);
            DataInputStream in      =        new DataInputStream(fis);
            BufferedReader br       =        new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        myInputText.setText(myData);
        responseText.setText("MySampleFile.txt data retrieved from Internal Storage...");
    }

}
