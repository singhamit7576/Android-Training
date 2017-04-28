package com.myapp.ui.CustomView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Create class MYTEXTView
 * which extends TextView
 * for Custom TExtview Setup
 */
public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
        this.setStyle();
    }

    /**
     * override Method
     * @param context
     * @param attribute
     */
    public MyTextView(Context context, AttributeSet attribute){
        super(context,attribute);
        this.setStyle();
    }

    /**
     *
     * @param context
     * @param attribute
     * @param style
     */
    public MyTextView(Context context, AttributeSet attribute, int style){
        super(context,attribute,style);
        this.setStyle();
    }

    /**
     * called two methods
     * which set color and
     * Font of the text.
     */
    private void setStyle(){
        this.setColor();
        this.setFont();
    }


    /**
     * call methods
     * which set Color and background
     * */
    private void setColor() {
        this.setTextColor(Color.RED );
        this.setBackgroundColor(Color.BLACK);

    }

    /**
     * call methods
     * which set Font.
     * */
    private void setFont() {
        Typeface  typeface=Typeface.createFromAsset(getContext().getAssets(),"Delgadito.ttf");
        this.setTypeface(typeface);
    }
}
