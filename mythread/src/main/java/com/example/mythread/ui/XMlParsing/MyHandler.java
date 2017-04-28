package com.example.mythread.ui.XMlParsing;

import android.app.Activity;
import android.widget.TextView;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * create Class MyHandler
 * which extends DefaultHandler.
 */
public class MyHandler extends DefaultHandler {

    boolean name = false;
    boolean address = false;
    private TextView txt_parse;

    /**
     * create Constructor.
     * @param txt_parse
     */
    public MyHandler( TextView txt_parse) {
        this.txt_parse= txt_parse;
    }

    /**
     * Override Method
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equalsIgnoreCase("name")) {
            name = true;
        }
        if (qName.equalsIgnoreCase("address")) {
            address = true;
        }

    }
        /**
     * Override method
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

     }


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }




    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (name) {

            txt_parse.setText(txt_parse.getText()+"\n\n Name : " + new String(ch, start, length));
            name = false;
        }
        if (address) {
            txt_parse.setText(txt_parse.getText()+"\n Address : " + new String(ch, start, length));
            address = false;
        }




  }
}
