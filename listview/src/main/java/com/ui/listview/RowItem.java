package com.ui.listview;

/**
 * Created by user on 7/3/17.
 */
public class RowItem {

    private String name;
    int type;

    public int getType() {
        return type;
    }

//    public void setType(int type) {
//        this.type = type;
//    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public RowItem(String name , int type){
        this.name   =   name;
        this.type   =   type;

    }



}
