package com.msw.mydemo19.weatherModel;

//
//	City.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class City extends DataSupport {

    @SerializedName("aqi")
    private String aqi;
    @SerializedName("co")
    private String co;
    @SerializedName("no2")
    private String no2;
    @SerializedName("o3")
    private String o3;
    @SerializedName("pm10")
    private String pm10;
    @SerializedName("pm25")
    private String pm25;
    @SerializedName("qlty")
    private String qlty;
    @SerializedName("so2")
    private String so2;

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getAqi() {
        return this.aqi;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCo() {
        return this.co;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getNo2() {
        return this.no2;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getO3() {
        return this.o3;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm10() {
        return this.pm10;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getPm25() {
        return this.pm25;
    }

    public void setQlty(String qlty) {
        this.qlty = qlty;
    }

    public String getQlty() {
        return this.qlty;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getSo2() {
        return this.so2;
    }

}