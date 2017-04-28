package com.myapp.ui.Widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.view.View;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.user.myapp.R;
import com.myapp.ui.activites.Base.BaseActivity;


/**
 * create  Activity Logfile in which
 * we create file in Tool-Android-Android Device Manager-Data
 * MyApp NAme - file created.Log file.
 */
public class Logfile extends BaseActivity implements View.OnClickListener{

    private EditText mEditText;
    private Button btn_save,btn_read;
    static final int SIZE   = 100;
    private String TAG  =   this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logfile);
        this.setReference();
        this.OnListener();
    }


    /**
     * setReference
     * of
     *  edit Text,buttons.
     */
    @Override
    protected void setReference() {
        mEditText       =   (EditText)  findViewById(R.id.mEditText);
        btn_save        =   (Button)    findViewById(R.id.btn_save) ;
        btn_read        =   (Button)    findViewById(R.id.btn_read);

    }

    /**
     * SetListener
     * of
     *  edit Text,buttons.
     */
    @Override
    protected void OnListener() {
        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);

    }


    /**
     * on click override method
     * in which ,action perfom on button click.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_save:
                this.saveLogFile();/*when Button click by user,*/
                break;

            case R.id.btn_read:
                this.readLogFile();

            default:
                break;
        }
    }


    /**
     * In this method
     * we read the saved data in
     * our file .
     * FileInputStream- used to open the file.
     * InputStreamReader - it read bytes and decode into character.
     */
    private void readLogFile() {


        try{
            FileInputStream mFileInputStream         =   openFileInput("myTextFile.txt");
            InputStreamReader mInputStreamReader     =   new InputStreamReader(mFileInputStream);
            char[] inputBuffer          =      new char[SIZE];
            String data =   "";
            int charRead;

            while ((charRead  =    mInputStreamReader.read(inputBuffer))   >  0) {

                String mString   =   String.copyValueOf(inputBuffer,0,charRead);
                data +=  mString;
            }
            mInputStreamReader.close();
            mEditText.setText(data);

            Toast.makeText(getBaseContext(), "Data Is  "+data, Toast.LENGTH_SHORT).show();


        }catch(Exception e){
            e.printStackTrace();
            Log.e(TAG,"FILE NOT FOUND");
        }
    }

    /**
     * In this Method ,we wrting data into file using -FileOutputStream.
     * OutputStreamWriter- encode into the the bytes from character,
     * ANd write data into our Exiting File.
     */
    private void saveLogFile() {

        String mData        =      mEditText.getText().toString();

        if (!mData.equals("")) {
            try {
                FileOutputStream mFileOutputStream         =          openFileOutput("myTextFile.txt", MODE_PRIVATE);
                OutputStreamWriter mOutputStreamWriter     =          new OutputStreamWriter(mFileOutputStream);
                mOutputStreamWriter.write(mData);
                mOutputStreamWriter.close();

                Toast.makeText(getBaseContext(), "File saved successfully!", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(Logfile.this, "Please Enter Data into file First", Toast.LENGTH_SHORT).show();
        }
    }
}






