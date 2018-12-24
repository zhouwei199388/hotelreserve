package com.hotelreserve.service;

import com.google.gson.Gson;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.model.RoomModel;
import com.hotelreserve.http.request.RoomRequest;
import com.hotelreserve.http.response.RoomResponse;
import com.hotelreserve.mapper.HotelRoomMapper;
import com.hotelreserve.mapper.RoomImageMapper;
import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.HotelRoomExample;
import com.hotelreserve.model.RoomImage;
import com.hotelreserve.model.RoomImageExample;
import com.hotelreserve.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouwei on 2018/12/14.
 */
@Service
public class HotelRoomService {

    @Autowired
    private HotelRoomMapper mRoomMapper;

    @Autowired
    private RoomImageMapper mRoomImageMapper;
    /**
     * 添加房间信息
     * @param roomModel
     * @return
     */
    @Transactional
    public ResponseHeader addRoom(RoomModel roomModel){
        ResponseHeader header = new ResponseHeader();
        HotelRoom room = roomModel.copyToHotelRoom();
        int id = mRoomMapper.insert(room);
        LogUtils.info(id+"");
        if (id!=0){
           if(roomModel.roomImages.size()>0){
             for (RoomImage roomImage:roomModel.roomImages){
                 roomImage.setRoomid(room.getId());
                 LogUtils.info(new Gson().toJson(roomImage));
                int result = mRoomImageMapper.insertSelective(roomImage);
                if(result==0){
                    throw new RuntimeException("图片插入错误");
                }
             }
           }
            header.code= ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.ADD_SUCCESS_TEXT;
        }
        return header;
    }

    /**
     * 修改指定房间信息
     * @param roomModel
     * @return
     */
    @Transactional
    public ResponseHeader updateRoom(RoomModel roomModel){
        ResponseHeader header = new ResponseHeader();
        LogUtils.info(new Gson().toJson(roomModel));
        int type = mRoomMapper.updateByPrimaryKeySelective(roomModel.copyToHotelRoom());
        if (type!=0){
            RoomImageExample example = new RoomImageExample();
            RoomImageExample.Criteria criteria = example.createCriteria();
            criteria.andRoomidEqualTo(roomModel.id);

            List<RoomImage> roomImages = mRoomImageMapper.selectByExample(example);
            if(roomImages.size()>0){
                int deleteResult =  mRoomImageMapper.deleteByExample(example);
                if(deleteResult==0){
                    throw new RuntimeException("删除错误");
                }
            }
            for (RoomImage roomImage:roomModel.roomImages){
                roomImage.setRoomid(roomModel.id);
                int result = mRoomImageMapper.insert(roomImage);
                if(result==0){
                    throw new RuntimeException("图片插入错误");
                }
            }
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
        HotelRoom room = mRoomMapper.selectByPrimaryKey(roomId);
        if(room==null){
            header.msg = ConnectionMessage.HOTELROOM_IS_NULL;
            return header;
        }
        RoomImageExample example = new RoomImageExample();
        RoomImageExample.Criteria criteria = example.createCriteria();
        criteria.andRoomidEqualTo(roomId);
        List<RoomImage> roomImages = mRoomImageMapper.selectByExample(example);
        if(roomImages.size()>0){
            int deImgResult = mRoomImageMapper.deleteByExample(example);
            if (deImgResult == 0) {
                header.msg = ConnectionMessage.DELETE_FAIL_TEXT;
                return header;
            }
        }
        int deRoomResult = mRoomMapper.deleteByPrimaryKey(roomId);
        if (deRoomResult!=0){
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
            List<RoomModel> roomModels = new ArrayList<>();
            for(HotelRoom room :rooms){
                RoomModel roomModel = new RoomModel();
                RoomImageExample roomImageExample = new RoomImageExample();
                RoomImageExample.Criteria roomCriteria = roomImageExample.createCriteria();
                roomCriteria.andRoomidEqualTo(room.getId());
                roomModel.roomImages = mRoomImageMapper.selectByExample(roomImageExample);
                roomModel.copyFromHotelRoom(room);
                roomModels.add(roomModel);
            }
            response.rooms = roomModels;
            header.msg = ConnectionMessage.SUCCESS_TEXT;
        }
        response.header = header;
        return response;
    }
}
