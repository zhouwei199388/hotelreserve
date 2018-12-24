package com.hotelreserve.http.model;

import com.hotelreserve.model.HotelImage;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.RoomImage;

import java.util.List;

/**
 * Created by zouwei on 2018/12/18.
 */
public class HotelModel {
    public Integer id;

    public String hotelname;

    public String hoteladdress;

    public String phone;

    public String facility;

    public String hoteltext;

    public List<HotelImage> hotelImages;

    public void copyFromHotel(HotelInfo hotelInfo){
     this.id = hotelInfo.getId();
     this.hotelname = hotelInfo.getHotelname();
     this.hoteladdress = hotelInfo.getHoteladdress();
     this.hoteltext = hotelInfo.getHoteltext();
     this.facility = hotelInfo.getFacility();
     this.phone = hotelInfo.getPhone();
    }


    public HotelInfo copyToHotel(){
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setId(this.id);
        hotelInfo.setHotelname(this.hotelname);
        hotelInfo.setHoteladdress(this.hoteladdress);
        hotelInfo.setFacility(this.facility);
        hotelInfo.setPhone(this.phone);
        hotelInfo.setHoteltext(this.hoteltext);
        return hotelInfo;
    }



}
