package com.hotelreserve.http.request;

import com.hotelreserve.model.Order;
import com.hotelreserve.utils.TimeUtil;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by zouwei on 2019/1/3.
 */
public class OrderRequest {
    public Integer userid;

    public Integer hotelid;

    public Integer roomid;

    public String ordernumber;

    public String roomnumber;
    public Integer roomCount;

    public String note;

    public Integer status;

    public Integer days;

    public Double price;

    public String startdate;

    public String enddate;

    public long createtime;
    public void copyFromOrder(Order order) {
        this.userid = order.getUserid();
        this.ordernumber = order.getOrdernumber();
        this.roomnumber = order.getRoomnumber();
        this.roomCount = order.getRoomcount();
        this.note = order.getNote();
        this.status = order.getStatus();
        this.price = order.getPrice();
        this.startdate = order.getStartdate();
        this.enddate = order.getEnddate();
        this.createtime = order.getCreatetime();
    }

    public Order copyToOrder() {
        Order order = new Order();
        order.setUserid(this.userid);
        order.setHotelid(this.hotelid);
        order.setAdminid(0);
        order.setRoomnumber("");
        order.setRoomid(this.roomid);
        order.setOrdernumber(this.ordernumber);
        order.setTransactionid("");
        order.setRoomnumber(this.roomnumber);
        order.setRoomcount(this.roomCount);
        order.setPrice(this.price);
        order.setNote(this.note);
        order.setDays(this.days);
        order.setStatus(this.status);
        order.setStartdate(this.startdate);
        order.setEnddate(this.enddate);
        return order;
    }

    public String getPrice(){
        int price = (int)(this.price*100);
        return String.valueOf(price);
    }


}
