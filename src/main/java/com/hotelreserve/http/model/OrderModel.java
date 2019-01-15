package com.hotelreserve.http.model;

import com.hotelreserve.model.*;

import java.util.Date;

/**
 * Created by zouwei on 2019/1/15.
 */
public class OrderModel {
    public Integer id;

    public String ordernumber;

    public Integer roomnumber;

    public String note;

    public Integer status;
    public Integer days;

    public Double price;

    public String startdate;

    public String enddate;

    public Date createtime;

    public User user;
    public HotelInfo hotelInfo;
    public HotelRoom hotelRoom;
    public PreOrderResponse preOrder;

    public void setOrder(Order order){
        this.id = order.getId();
        this.ordernumber = order.getOrdernumber();
        this.roomnumber = order.getRoomnumber();
        this.note = order.getNote();
        this.status = order.getStatus();
        this.days = order.getDays();
        this.price = order.getPrice();
        this.startdate = order.getStartdate();
        this.enddate = order.getEnddate();
        this.createtime = order.getCreatetime();
    }

}
