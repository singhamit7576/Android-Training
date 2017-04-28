package com.myapp.ui.activites.NetwrokOperation.Exception;

import com.myapp.ui.CustomView.EmptyException;

/**
 * Create Class(Empty Url) which extends
 * Exception
 * which have Constructor
 */
public class EmptyUrl extends Exception{

    public  EmptyUrl(String message){
        super(message);
    }


    /**
     * @return short Discription
     * Of Throwable
     */

    @Override
    public String toString() {
        return super.toString();
    }
}


