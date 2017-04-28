package com.example.maptest;

import android.graphics.Bitmap;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by user on 19/4/17.
 */
public class MarkerData {

    LatLng latLng;
    String title;
    Bitmap bitmap;
    String bitmap1;
    String bitmap2;

    MarkerData(){}


    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getBitmap1() {
        return bitmap1;
    }

    public void setBitmap1(String bitmap1) {
        this.bitmap1 = bitmap1;
    }

    public String getBitmap2() {
        return bitmap2;
    }

    public void setBitmap2(String bitmap2) {
        this.bitmap2 = bitmap2;
    }
}
