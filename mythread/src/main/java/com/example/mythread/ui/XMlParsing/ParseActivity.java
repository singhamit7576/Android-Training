package com.example.mythread.ui.XMlParsing;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * Create Activity Which
 * extends Abstract class and which have some abstract method.
 */
public class ParseActivity extends BaseActivity {


    private TextView txt_parse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse);
        this.setReference();
        this.onListener();
    }



    /**
     * setReference Of TextView
     */

    @Override
    protected void setReference() {

        txt_parse    =    (TextView)        findViewById(R.id.txt_parse);
    }

    @Override
    protected void onListener() {

        this.xmlParse();
    }

    /**
     * Method in which
     *  Defines a factory API that enables applications to configure and
     * obtain a SAX based parser to parse XML documents.
     */


    private void xmlParse() {
        /**
         * In this method ,
         * Define factory which enables
         * application to configure
         * and obtain Sax Parser.
         */


        new  Thread(new Runnable() {
            @Override
            public void run() {



        try {

            SAXParserFactory factory             =   SAXParserFactory.newInstance();
            SAXParser saxParser                  =       factory.newSAXParser();
            MyHandler handler                    =       new MyHandler(txt_parse);
            InputStream inputStream  =       getAssets().open("student.xml");
            saxParser.parse(inputStream, handler );


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }



            }
        }).start();


    }
}


