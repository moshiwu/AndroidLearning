package com.msw.mydemo14;

//
//	BaseResponse.java
//
//	Create by 莫 锹文 on 2017/12/14
//	Copyright © 2017. All rights reserved.


public class BaseResponse {

    private Data data;
    private String message;
    private String result;

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}