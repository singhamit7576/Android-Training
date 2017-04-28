package com.example.mythread.ui.Thread;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

import java.io.InputStream;


public class AsynTask extends BaseActivity implements View.OnClickListener {

    private  ImageView image;
    String IMAGE_URL = "http://api.androidhive.info/progressdialog/hive.jpg";
   // String IMAGE_URL = "http://www.androidbegin.com/wp-content/uploads/2013/07/HD-Logo.gif";
    private Button btn_Asyn;
    private  ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        btn_Asyn         =  (Button)        findViewById(R.id.btn_Asyn);
        image            =  (ImageView)     findViewById(R.id.image);


    }

    @Override
    protected void onListener() {
        btn_Asyn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        new DownloadImage().execute(IMAGE_URL);
    }

    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(AsynTask.this);
            mProgressDialog.setTitle("Download Image");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.show();
        }


        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {


                InputStream input = new java.net.URL(imageURL).openStream();

                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            // Set the bitmap into ImageView
            image.setImageBitmap(result);
            // Close progressdialog
            mProgressDialog.dismiss();
        }
    }



}
