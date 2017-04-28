package com.myapp.ui.CustomView;

/**
 * Create Class(Empty Url) which extends
 * Exception
 * which have Contructor.
 * which show Exception
 */
public class EmptyException extends Exception{

    EmptyException(String message){
        super(message);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
