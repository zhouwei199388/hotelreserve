package com.hotelreserve.model;

import java.util.Date;

public class Order {
    private Integer id;

    private String ordernumber;

    private Integer roomnumbeer;

    private String people;

    private String phone;

    private String note;

    private Integer status;

    private Double price;

    private Date starttime;

    private Date endtime;

    private String hotel;

    private String hotelroom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public Integer getRoomnumbeer() {
        return roomnumbeer;
    }

    public void setRoomnumbeer(Integer roomnumbeer) {
        this.roomnumbeer = roomnumbeer;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people == null ? null : people.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel == null ? null : hotel.trim();
    }

    public String getHotelroom() {
        return hotelroom;
    }

    public void setHotelroom(String hotelroom) {
        this.hotelroom = hotelroom == null ? null : hotelroom.trim();
    }
}