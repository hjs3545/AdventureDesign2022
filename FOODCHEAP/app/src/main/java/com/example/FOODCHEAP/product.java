package com.example.FOODCHEAP;

public class product {
    private String shopName;
    private int imageID;
    private String price1;
    private String price2;
    private String discountRate;
    private String name;
    private String explain;
    private String date;
    private int stock;

    public product(String shopName, int imageID, String price1, String price2, String discountRate, String name, String explain, String date, int stock) {
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

    public String getShopName() {
        return shopName;
    }

    public int getImageID() {
        return imageID;
    }

    public String getPrice1() {
        return price1;
    }

    public String getPrice2() {
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

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public void setPrice2(String price2) {
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
