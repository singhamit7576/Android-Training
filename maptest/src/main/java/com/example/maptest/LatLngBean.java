package com.example.maptest;


public class LatLngBean {

    String title="";
    String snippet="";
    double latitude;
    double longitude;
    String id ;

    public LatLngBean(String title, double latitude, double longitude, String snippet) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.snippet=snippet;
    }

    public String getTitle() {
        return title;
    }


    public String getSnippet() {
        return snippet;
    }



    public double getLatitude() {
        return latitude;
    }



    public double getLongitude() {
        return longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }





}
