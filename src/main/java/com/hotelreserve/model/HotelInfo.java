package com.hotelreserve.model;

public class HotelInfo {
    private Integer id;

    private String hotelname;

    private String hoteladdress;

    private String phone;

    private String facility;

    private String hoteltext;

    @Override
    public String toString() {
        return "HotelInfo{" +
                "id=" + id +
                ", hotelname='" + hotelname + '\'' +
                ", hoteladdress='" + hoteladdress + '\'' +
                ", phone='" + phone + '\'' +
                ", facility='" + facility + '\'' +
                ", hoteltext='" + hoteltext + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress == null ? null : hoteladdress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility == null ? null : facility.trim();
    }

    public String getHoteltext() {
        return hoteltext;
    }

    public void setHoteltext(String hoteltext) {
        this.hoteltext = hoteltext == null ? null : hoteltext.trim();
    }
}