package com.wee.test.controller.shop.dto;

public class ReportDto {

    private String shopName;
    private int countItems;

    public ReportDto(String shopName, int countItems) {
        this.shopName = shopName;
        this.countItems = countItems;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getCountItems() {
        return countItems;
    }

    public void setCountItems(int countItems) {
        this.countItems = countItems;
    }
}
