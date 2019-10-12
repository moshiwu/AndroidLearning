package com.msw.mydemo19.weatherModel;

//
//	Wind.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Wind extends DataSupport {

    @SerializedName("deg")
    private String deg;
    @SerializedName("dir")
    private String dir;
    @SerializedName("sc")
    private String sc;
    @SerializedName("spd")
    private String spd;

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getDeg() {
        return this.deg;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return this.dir;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getSc() {
        return this.sc;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getSpd() {
        return this.spd;
    }

}