package com.example.moqiaowen.mydemo9;

import org.litepal.crud.DataSupport;

/**
 * Created by moqiaowen on 2017/11/14.
 */

public class Book extends DataSupport {

    private String name;
    private String author;
    private int pages;
    private double price;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
