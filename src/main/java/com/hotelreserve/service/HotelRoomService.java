package com.hotelreserve.service;

import com.google.gson.Gson;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.RoomResponse;
import com.hotelreserve.mapper.HotelRoomMapper;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.HotelRoomExample;
import com.hotelreserve.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouwei on 2018/12/14.
 */
@Service
public class HotelRoomService {

    @Autowired
    private HotelRoomMapper mRoomMapper;

    /**
     * 添加房间信息
     * @param room
     * @return
     */
    public ResponseHeader addRoom(HotelRoom room){
        ResponseHeader header = new ResponseHeader();
        int type = mRoomMapper.insertSelective(room);
        if (type!=0){
           header.code= ConnectionMessage.SUCCESS_CODE;
           header.msg = ConnectionMessage.ADD_SUCCESS_TEXT;
        }
        return header;
    }

    /**
     * 修改指定房间信息
     * @param room
     * @return
     */
    public ResponseHeader updateRoom(HotelRoom room){
        ResponseHeader header = new ResponseHeader();
        LogUtils.info(new Gson().toJson(room));
        int type = mRoomMapper.updateByPrimaryKeySelective(room);
        if (type!=0){
            header.code= ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.UPDATE_SUCCESS_TEXT;
        }
        return header;
    }


    /**
     * 删除指定房间信息
     * @param roomId
     * @return
     */
    public ResponseHeader deleteRoom(int roomId){
        ResponseHeader header = new ResponseHeader();
        int type = mRoomMapper.deleteByPrimaryKey(roomId);
        if (type!=0){
            header.code= ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.DELETE_SUCCESS_TEXT;
        }
        return header;
    }

    /**
     * 获取酒店房间
     * @return
     */
    public RoomResponse getRooms(int hotelId){
        RoomResponse response = new RoomResponse();
        ResponseHeader header = new ResponseHeader();
        HotelRoomExample example = new HotelRoomExample();
        HotelRoomExample.Criteria criteria = example.createCriteria();
        criteria.andHotelidEqualTo(hotelId);
        List<HotelRoom> rooms = mRoomMapper.selectByExample(new HotelRoomExample());
        if(rooms.size()==0){
          header.msg = ConnectionMessage.DATA_IS_NULL;
        }else{
            header.msg = ConnectionMessage.SUCCESS_TEXT;
            response.rooms= rooms;
        }
        response.header = header;
        return response;
    }
}
