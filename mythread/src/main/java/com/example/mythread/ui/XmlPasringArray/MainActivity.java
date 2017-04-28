package com.example.mythread.ui.XmlPasringArray;


import android.os.Bundle;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * create Acitvity which extend abstract class
 * ehich have some methods
 */
public class MainActivity extends BaseActivity {

    private TextView textView1;
    private String data ="";
    private OrderXMLHandler orderXMLHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setReference();
        this.onListener();
    }

    /**
     * set reference of TextView
     */
    @Override
    protected void setReference() {

        textView1 = (TextView) findViewById(R.id.textView1);
    }

    @Override
    protected void onListener() {
        this.parseXML();
    }


    /**
     * In this Method,set Factory
     * and
     */
    private void    parseXML() {
        Thread mThread = new Thread(){
            @Override
            public void run() {


        try {
            SAXParserFactory factory    =       SAXParserFactory.newInstance();
            SAXParser parser            =       factory.newSAXParser();
            orderXMLHandler             =       new OrderXMLHandler();
            InputStream mInputStream    =       getAssets().open("oreder.xml");
            parser.parse(mInputStream, orderXMLHandler);
            list();
            updateUi();


        } catch (IOException | ParserConfigurationException | SAXException e1) {
            e1.printStackTrace();
        }


            }
        };
        mThread.start();






    }

    private void updateUi() {


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView1.setText(data);
            }
        });
    }


    private void list() {



        ArrayList<ProductInfo> itemsList = orderXMLHandler.getItemsList();

        for (int i = 0;  i < itemsList.size() ;  i++) {

            ProductInfo productInfo  =  itemsList.get(i);

            data = data + "----->\n";
            data = data + "Item Number: " + productInfo.getItemNumber() +"\n";
            data = data + "Quantity: " + productInfo.getQuantity() +"\n\n" ;


        }

    }


}