package com.msw.mydemo19.weatherModel;

//
//	DailyForecast.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class DailyForecast extends DataSupport {

    @SerializedName("astro")
    private Astro astro;
    @SerializedName("cond")
    private Cond cond;
    @SerializedName("date")
    private String date;
    @SerializedName("hum")
    private String hum;
    @SerializedName("pcpn")
    private String pcpn;
    @SerializedName("pop")
    private String pop;
    @SerializedName("pres")
    private String pres;
    @SerializedName("tmp")
    private Tmp tmp;
    @SerializedName("uv")
    private String uv;
    @SerializedName("vis")
    private String vis;
    @SerializedName("wind")
    private Wind wind;

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public Astro getAstro() {
        return this.astro;
    }

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

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPcpn() {
        return this.pcpn;
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

    public void setTmp(Tmp tmp) {
        this.tmp = tmp;
    }

    public Tmp getTmp() {
        return this.tmp;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getUv() {
        return this.uv;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getVis() {
        return this.vis;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Wind getWind() {
        return this.wind;
    }

}