package com.msw.mydemo19.weatherModel;

//
//	Basic.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Basic extends DataSupport {

    @SerializedName("city")
    private String city;
    @SerializedName("cnty")
    private String cnty;
    @SerializedName("id")
    private String id;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("update")
    private Update update;

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getCnty() {
        return this.cnty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLon() {
        return this.lon;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public Update getUpdate() {
        return this.update;
    }

}