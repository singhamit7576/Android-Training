package com.myapp.ui.activites.NetwrokOperation;

import com.google.gson.annotations.Until;
import com.myapp.ui.activites.NetwrokOperation.Exception.EmptyUrl;
import com.myapp.ui.activites.NetwrokOperation.Exception.Invalidurl;
import com.myapp.ui.utils.utils;

/**
 * Create Class NetworkOperation
 * which  thros Empty url and
 * Invalid url Exception
 */
public class NetworkOperationn {

     String url;

    /**
     * which throws EmptyUrl,Invalidurl
     * @param url
     * @throws EmptyUrl
     * @throws Invalidurl
     */
    public void request(String url)throws EmptyUrl,Invalidurl{

        this.url = url;

        if(url.equals("")){
            throw  new EmptyUrl("Url is Empty");
        }

        if (url.startsWith("http"))
        {
            utils.printLog("tag","valid Url");
        }
        else{
            throw new Invalidurl("invalid url");
        }

    }
}
