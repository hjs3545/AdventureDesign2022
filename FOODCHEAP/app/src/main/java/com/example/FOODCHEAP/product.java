package com.example.FOODCHEAP;

import java.text.DecimalFormat;

public class product {
    DecimalFormat decFormat = new DecimalFormat("###,###");
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
    private String PRICE2;

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

    public product(int id, int imageID, String name, String PRICE2) {
        this.id = id;
        this.imageID = imageID;
        this.PRICE2 = PRICE2;
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

    public String getPrice1() {
        String str = decFormat.format(price1) + "원";
        return str;
    }

    public String getPrice2() {
        String str= decFormat.format(price2) + "원";
        return str;
    }

    public String GETPRICE2() {
        return PRICE2;
    }

    public int GetPrice2() {
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
