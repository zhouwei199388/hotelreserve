package com.hotelreserve.http.model;

import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.RoomImage;

import java.util.List;

/**
 * Created by zouwei on 2018/12/18.
 */
public class RoomModel {
    public Integer id;

    public Integer hotelid;

    public String name;

    public Double price;

    public Integer window;

    public String image;

    public List<RoomImage> roomImages;

    public void copyFromHotelRoom(HotelRoom room){
     this.id = room.getId();
     this.hotelid = room.getHotelid();
     this.name = room.getName();
     this.price = room.getPrice();
     this.window = room.getIswindow();
     this.image = room.getImage();
    }


    public HotelRoom copyToHotelRoom(){
        HotelRoom room = new HotelRoom();
        room.setId(this.id);
        room.setHotelid(this.hotelid);
        room.setImage(this.image);
        room.setName(this.name);
        room.setPrice(this.price);
        room.setIswindow(this.window);
        return room;
    }



}
