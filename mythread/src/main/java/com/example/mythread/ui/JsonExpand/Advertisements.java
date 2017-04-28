package com.example.mythread.ui.JsonExpand;

import java.util.ArrayList;

public class Advertisements {

    public int adID;
    public String adName;
    public boolean enabled;
    public int shopID;
    public String shopName;
    public String description;
    public String validUpTo;
    public  String createDate;
    public ArrayList<ImageList>images;

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public  String updateDate;

    public ArrayList<ImageList> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImageList> images) {
        this.images = images;
    }

    public ArrayList<Adschedule> getShedules() {
        return shedules;
    }

    public void setShedules(ArrayList<Adschedule> shedules) {
        this.shedules = shedules;
    }



    public ArrayList<Adschedule>shedules;

    public int getAdID() {
        return adID;
    }

    public void setAdID(int adID) {
        this.adID = adID;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidUpTo() {
        return validUpTo;
    }

    public void setValidUpTo(String validUpTo) {
        this.validUpTo = validUpTo;
    }
}
