package com.hotelreserve.service;

import com.google.gson.Gson;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.mapper.HotelInfoMapper;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelInfoExample;
import com.hotelreserve.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouwei on 2018/12/7.
 */
@Service
public class HotelService {
    @Autowired
    private HotelInfoMapper mHotelInfoMapper;
    /**
     * 获取酒店列表
     * @return
     */
    public HotelInfosResponse getHotelInfoList() {
        HotelInfosResponse response = new HotelInfosResponse();
        ResponseHeader header = new ResponseHeader();
        List<HotelInfo> hotelInfos = mHotelInfoMapper.selectByExample(new HotelInfoExample());
        if (hotelInfos.size() == 0) {
            header.setSuccessNoDate();
        } else {
            response.hotelInfos = hotelInfos;
            header.setSuccess();
        }
        LogUtils.info(new Gson().toJson(response));
        response.header=header;
        return response;
    }

    /**
     * 添加一个酒店
     * @param hotelInfo
     * @return
     */
    public ResponseHeader insertHotelInfo(HotelInfo hotelInfo){
        ResponseHeader header = new ResponseHeader();
       int type =  mHotelInfoMapper.insert(hotelInfo);
       LogUtils.info(type+"");
       if(type!=0){
           header.setAddSuccess();
       }
       return header;
    }

    /**
     * 根据id修改一个酒店
     * @param hotelInfo
     * @return
     */
    public ResponseHeader updateHotelInfo(HotelInfo hotelInfo){
        ResponseHeader header = new ResponseHeader();
        int type =  mHotelInfoMapper.updateByPrimaryKeySelective(hotelInfo);
        if(type!=0){
            header.code = ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.UPDATE_SUCCESS_TEXT;
        }
        return header;
    }

    /**
     * 删除一个酒店
     * @param id
     * @return
     */
    public ResponseHeader deleteHotelInfo(int id){
        ResponseHeader header = new ResponseHeader();
        if(mHotelInfoMapper.selectByPrimaryKey(id)==null){
         header.msg = ConnectionMessage.HOTEL_IS_NULL;
         return header;
        }
        int type  = mHotelInfoMapper.deleteByPrimaryKey(id);
        if(type!=0){
            header.code = ConnectionMessage.SUCCESS_CODE;
           header.msg = ConnectionMessage.DELETE_SUCCESS_TEXT;
        }
        return header;
    }



}
