package com.example.FOODCHEAP;

import java.text.DecimalFormat;

public class product {
    private int id;
    private String shopName;
    private int imageID;
    private int price1;
    private int price2;
    private String discountRate;
    private String name;
    private String explain;
    private String date;
    private int stock;

    public product(String shopName, int imageID, int price1, int price2, String discountRate, String name, String explain, String date, int stock) {
        this.shopName = shopName;
        this.imageID = imageID;
        this.price1 = price1;
        this.price2 = price2;
        this.discountRate = discountRate;
        this.name = name;
        this.explain = explain;
        this.date = date;
        this.stock = stock;
    }

    public product(int id, int imageID, String name, int price2) {
        this.id = id;
        this.imageID = imageID;
        this.price2 = price2;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getShopName() {
        return shopName;
    }

    public int getImageID() {
        return imageID;
    }

    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }
    public String getDiscountRate() {
        return discountRate;
    }

    public String getName() {
        return name;
    }

    public String getExplain() {
        return explain;
    }

    public String getDate() {
        return date;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
