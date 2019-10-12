package com.msw.mydemo19.weatherModel;

//
//	HourlyForecast.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class HourlyForecast extends DataSupport {

    @SerializedName("cond")
    private Cond cond;
    @SerializedName("date")
    private String date;
    @SerializedName("hum")
    private String hum;
    @SerializedName("pop")
    private String pop;
    @SerializedName("pres")
    private String pres;
    @SerializedName("tmp")
    private String tmp;
    @SerializedName("wind")
    private Wind wind;

    public void setCond(Cond cond) {
        this.cond = cond;
    }

    public Cond getCond() {
        return this.cond;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getHum() {
        return this.hum;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPop() {
        return this.pop;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getPres() {
        return this.pres;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getTmp() {
        return this.tmp;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Wind getWind() {
        return this.wind;
    }

}