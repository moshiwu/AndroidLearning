package com.msw.mydemo19.weatherModel;

//
//	HeWeather.java
//
//	Create by 莫 锹文 on 2018/01/06
//	Copyright © 2018. All rights reserved.


import org.json.*;
import org.litepal.crud.DataSupport;

import java.util.*;

import com.google.gson.annotations.SerializedName;


public class HeWeather extends DataSupport {

    @SerializedName("aqi")
    private Aqi aqi;
    @SerializedName("basic")
    private Basic basic;
    @SerializedName("daily_forecast")
    private DailyForecast[] dailyForecast;
    @SerializedName("hourly_forecast")
    private HourlyForecast[] hourlyForecast;
    @SerializedName("now")
    private Now now;
    @SerializedName("status")
    private String status;
    @SerializedName("suggestion")
    private Suggestion suggestion;

    public void setAqi(Aqi aqi) {
        this.aqi = aqi;
    }

    public Aqi getAqi() {
        return this.aqi;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Basic getBasic() {
        return this.basic;
    }

    public void setDailyForecast(DailyForecast[] dailyForecast) {
        this.dailyForecast = dailyForecast;
    }

    public DailyForecast[] getDailyForecast() {
        return this.dailyForecast;
    }

    public void setHourlyForecast(HourlyForecast[] hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public HourlyForecast[] getHourlyForecast() {
        return this.hourlyForecast;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public Now getNow() {
        return this.now;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public Suggestion getSuggestion() {
        return this.suggestion;
    }

}