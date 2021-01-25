package com.example.cms.Models;

public class OrdersModel {
    int orderimage;
    String Sold_item_name, price, order_num;

    public OrdersModel(int orderimage, String sold_item_name, String price, String order_num) {
        this.orderimage = orderimage;
        Sold_item_name = sold_item_name;
        this.price = price;
        this.order_num = order_num;
    }

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getSold_item_name() {
        return Sold_item_name;
    }

    public void setSold_item_name(String sold_item_name) {
        Sold_item_name = sold_item_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }
}
