package com.hotelreserve.http.model;

import com.hotelreserve.model.Order;

/**
 * Created by zouwei on 2019/1/3.
 */
public class OrderModel {
    public Integer id;
    public Integer userid;
    public String ordernumber;
    public Integer roomnumber;
    public String people;
    public String phone;
    public String note;
    public Integer status;
    public Double price;
    public String startdate;
    public String enddate;
    public String hotel;
    public String hotelroom;
    public Integer days;
    public void copyFromHotel(Order order) {
        this.id = order.getId();
        this.userid = order.getUserid();
        this.ordernumber = order.getOrdernumber();
        this.roomnumber = order.getRoomnumber();
        this.people = order.getPeople();
        this.phone = order.getPhone();
        this.note = order.getNote();
        this.status = order.getStatus();
        this.price = order.getPrice();
        this.startdate = order.getStartdate();
        this.enddate = order.getEnddate();
        this.hotel = order.getHotel();
        this.hotelroom = order.getHotelroom();
    }

    public Order copyToHotel() {
        Order order = new Order();
        order.setId(this.id);
        order.setUserid(this.userid);
        order.setOrdernumber(this.ordernumber);
        order.setRoomnumber(this.roomnumber);
        order.setPeople(this.people);
        order.setNote(this.note);
        order.setStatus(this.status);
        order.setStartdate(this.startdate);
        order.setEnddate(this.enddate);
        order.setHotel(this.hotel);
        order.setHotelroom(this.hotelroom);
        return order;
    }


}
