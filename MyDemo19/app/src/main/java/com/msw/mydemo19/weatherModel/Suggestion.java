package com.msw.mydemo19.weatherModel;

//
//	Suggestion.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class Suggestion extends DataSupport {

    @SerializedName("air")
    private Air air;
    @SerializedName("comf")
    private Air comf;
    @SerializedName("cw")
    private Air cw;
    @SerializedName("drsg")
    private Air drsg;
    @SerializedName("flu")
    private Air flu;
    @SerializedName("sport")
    private Air sport;
    @SerializedName("trav")
    private Air trav;
    @SerializedName("uv")
    private Air uv;

    public void setAir(Air air) {
        this.air = air;
    }

    public Air getAir() {
        return this.air;
    }

    public void setComf(Air comf) {
        this.comf = comf;
    }

    public Air getComf() {
        return this.comf;
    }

    public void setCw(Air cw) {
        this.cw = cw;
    }

    public Air getCw() {
        return this.cw;
    }

    public void setDrsg(Air drsg) {
        this.drsg = drsg;
    }

    public Air getDrsg() {
        return this.drsg;
    }

    public void setFlu(Air flu) {
        this.flu = flu;
    }

    public Air getFlu() {
        return this.flu;
    }

    public void setSport(Air sport) {
        this.sport = sport;
    }

    public Air getSport() {
        return this.sport;
    }

    public void setTrav(Air trav) {
        this.trav = trav;
    }

    public Air getTrav() {
        return this.trav;
    }

    public void setUv(Air uv) {
        this.uv = uv;
    }

    public Air getUv() {
        return this.uv;
    }

}