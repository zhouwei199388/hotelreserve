package com.hotelreserve.service;

import com.google.gson.Gson;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.HotelModel;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.HotelInfosResponse;
import com.hotelreserve.mapper.HotelImageMapper;
import com.hotelreserve.mapper.HotelInfoMapper;
import com.hotelreserve.model.*;
import com.hotelreserve.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouwei on 2018/12/7.
 */
@Service
public class HotelService {
    @Autowired
    private HotelInfoMapper mHotelInfoMapper;
    @Autowired
    private HotelImageMapper mHotelImageMapper;
    /**
     * 获取酒店列表
     * @return
     */
    public HotelInfosResponse getHotelInfoList() {
        HotelInfosResponse hotelInfosResponse = new HotelInfosResponse();
        ResponseHeader header = new ResponseHeader();
        List<HotelInfo> hotelInfos = mHotelInfoMapper.selectByExample(new HotelInfoExample());
        if(hotelInfos.size()==0){
            header.msg = ConnectionMessage.DATA_IS_NULL;
        }else{
            List<HotelModel> hotelModels = new ArrayList<>();
            for(HotelInfo info :hotelInfos){
                HotelModel hotelModel = new HotelModel();
                HotelImageExample hotelImageExample = new HotelImageExample();
                HotelImageExample.Criteria roomCriteria = hotelImageExample.createCriteria();
                roomCriteria.andHotelidEqualTo(info.getId());
                hotelModel.hotelImages = mHotelImageMapper.selectByExample(hotelImageExample);
                hotelModel.copyFromHotel(info);
                hotelModels.add(hotelModel);
            }
            hotelInfosResponse.hotelModels = hotelModels;
            header.msg = ConnectionMessage.SUCCESS_TEXT;
            header.code = ConnectionMessage.SUCCESS_CODE;
        }
        hotelInfosResponse.header = header;
        return hotelInfosResponse;
    }

    /**
     * 添加一个酒店
     * @param hotelModel
     * @return
     */
    @Transactional
    public ResponseHeader insertHotelInfo(HotelModel hotelModel){
        ResponseHeader header = new ResponseHeader();
        HotelInfo hotelInfo = hotelModel.copyToHotel();
        int id = mHotelInfoMapper.insert(hotelInfo);
        LogUtils.info(id+"");
        if (id!=0){
            if(hotelModel.hotelImages.size()>0){
                for (HotelImage hotelImage:hotelModel.hotelImages){
                    hotelImage.setHotelid(hotelInfo.getId());
                    LogUtils.info(new Gson().toJson(hotelImage));
                    int result = mHotelImageMapper.insertSelective(hotelImage);
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
     * 根据id修改一个酒店
     * @param hotelModel
     * @return
     */
    public ResponseHeader updateHotelInfo(HotelModel hotelModel){
        ResponseHeader header = new ResponseHeader();
        LogUtils.info(new Gson().toJson(hotelModel));
        int type = mHotelInfoMapper.updateByPrimaryKeySelective(hotelModel.copyToHotel());
        if (type!=0){
            HotelImageExample example = new HotelImageExample();
            HotelImageExample.Criteria criteria = example.createCriteria();
            criteria.andHotelidEqualTo(hotelModel.id);

            List<HotelImage> hotelImages = mHotelImageMapper.selectByExample(example);
            if(hotelImages.size()>0){
                int deleteResult =  mHotelImageMapper.deleteByExample(example);
                if(deleteResult==0){
                    throw new RuntimeException("删除错误");
                }
            }
            for (HotelImage hotelImage:hotelModel.hotelImages){
                hotelImage.setHotelid(hotelModel.id);
                int result = mHotelImageMapper.insert(hotelImage);
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
     * 删除一个酒店
     * @param id
     * @return
     */
    public ResponseHeader deleteHotelInfo(int id){
        ResponseHeader header = new ResponseHeader();
        HotelInfo hotelInfo = mHotelInfoMapper.selectByPrimaryKey(id);
        if(hotelInfo==null){
            header.msg = ConnectionMessage.HOTELROOM_IS_NULL;
            return header;
        }
        HotelImageExample example = new HotelImageExample();
        HotelImageExample.Criteria criteria = example.createCriteria();
        criteria.andHotelidEqualTo(id);
        List<HotelImage> hotelImages = mHotelImageMapper.selectByExample(example);
        if(hotelImages.size()>0){
            int deImgResult = mHotelImageMapper.deleteByExample(example);
            if (deImgResult == 0) {
                header.msg = ConnectionMessage.DELETE_FAIL_TEXT;
                return header;
            }
        }
        int deRoomResult = mHotelInfoMapper.deleteByPrimaryKey(id);
        if (deRoomResult!=0){
            header.code= ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.DELETE_SUCCESS_TEXT;
        }
        return header;
    }



}
