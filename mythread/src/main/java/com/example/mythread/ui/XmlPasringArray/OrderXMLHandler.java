package com.example.mythread.ui.XmlPasringArray;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


public class OrderXMLHandler extends DefaultHandler {

    boolean currentElement = false;
    String currentValue = "";
    ProductInfo productInfo;
    private ArrayList<ProductInfo> itemsList = new ArrayList<>();



    public ArrayList<ProductInfo> getItemsList() {
        return itemsList;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;
        currentValue = "";

        if (localName.equals("OrderItemDetail")) {
            productInfo = new ProductInfo();
        }

    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;


        if (localName.equalsIgnoreCase("itemNumber"))
            productInfo.setItemNumber(currentValue);
        else if (localName.equalsIgnoreCase("Quantity"))
            productInfo.setQuantity(currentValue);
        else if (localName.equalsIgnoreCase("OrderItemDetail"))
            itemsList.add(productInfo);

    }
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }

    }

}
