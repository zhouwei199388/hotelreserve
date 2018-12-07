package com.hotelreserve.service;

import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.mapper.HotelInfoMapper;
import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelInfoExample;
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
            header.setSuccess();
        }
        response.header=header;
        response.hotelInfos = hotelInfos;
        return response;
    }


    /**
     * 添加一个酒店
     * @param hotelInfo
     * @return
     */
    public ResponseHeader insertHotelInfo(HotelInfo hotelInfo){
        ResponseHeader header = new ResponseHeader();
       int type =  mHotelInfoMapper.insertSelective(hotelInfo);
       if(type!=0){
           header.setSuccess();
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
        int type =  mHotelInfoMapper.updateByPrimaryKey(hotelInfo);
        if(type!=0){
            header.setSuccess();
        }
        return header;
    }



}
