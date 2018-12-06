package com.hotelreserve.service;

import com.google.gson.JsonObject;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.model.WxModel;
import com.hotelreserve.http.request.UserRequest;
import com.hotelreserve.http.response.UserResponse;
import com.hotelreserve.mapper.UserMapper;
import com.hotelreserve.model.User;
import com.hotelreserve.model.UserExample;
import com.hotelreserve.utils.LogUtils;
import com.hotelreserve.utils.XcxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 15090 on 2018/12/2.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper mUserMapper;
    /**
     * 添加用户  如果用户已存在返回用户信息
     * @param request 小程序code等信息
     * @return
     */
    public UserResponse addUser(UserRequest request) {
        UserResponse userResponse = new UserResponse();
        ResponseHeader header = new ResponseHeader();
        User user = new User();
        LogUtils.info("addUser");
        WxModel wxModel;
        if(!request.getCode().isEmpty()) {
            String appid="wxe7b86a74f9e96203";
            String secret="e912dab12ca28b09c6cae11ccf7bd4ef";
            wxModel =  XcxUtils.getSessionKeyOropenid(request.getCode(),appid,secret);
            if(wxModel==null){
                header.setOpenidOrKeyError();
                userResponse.header = header;
                return userResponse;
            }
            XcxUtils.getUserInfo(request.encryptedData,wxModel.session_key,request.iv);

        }else{
            header.setCodeError();

        }
//        int id = mUserMapper.insertSelective(user);
//        if (id != 0) {
//            //TODO:通过微信小程序code等信息获取用户微信信息
//        }
        userResponse.header=header;
        userResponse.user = user;
        return userResponse;
    }


    /**
     * 绑定手机号
     *
     * @param id    用户id
     * @param phone 手机号
     */
    public void bindPhone(int id, String phone) {
        User user = new User();
        user.setId(id);
        user.setPhone(phone);
        int result = mUserMapper.updateByPrimaryKeySelective(user);

    }


    /**
     * 测试
     *
     * @return
     */
    public List<User> getUser() {
        UserExample example = new UserExample();
        return mUserMapper.selectByExample(example);
    }

}
