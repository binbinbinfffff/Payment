package com.moviemarket.model;

import java.util.Date;

public class Order {
    private Integer order_id;

    private Integer user_openid;

    private Date order_create_time;

    private Integer order_price;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_openid() {
        return user_openid;
    }

    public void setUser_openid(Integer user_openid) {
        this.user_openid = user_openid;
    }

    public Date getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Date order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Integer getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }
}