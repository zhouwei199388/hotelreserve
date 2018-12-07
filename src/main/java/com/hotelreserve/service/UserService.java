package com.hotelreserve.service;

import com.google.gson.JsonObject;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.model.WxModel;
import com.hotelreserve.http.model.WxUserInfo;
import com.hotelreserve.http.request.BindPhoneRequest;
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
     *
     * @param request 小程序code等信息
     * @return
     */
    public UserResponse addUser(UserRequest request) {
        UserResponse userResponse = new UserResponse();
        ResponseHeader header = new ResponseHeader();
        LogUtils.info("addUser");
        WxModel wxModel;
        //判断code是否为空
        if (!request.code.isEmpty()) {
            String appid = "wxe7b86a74f9e96203";
            String secret = "e912dab12ca28b09c6cae11ccf7bd4ef";
            //获取微信openid和sessionkey
            wxModel = XcxUtils.getSessionKeyOropenid(request.code, appid, secret);
            if (wxModel.openid==null||wxModel.session_key==null) {
                header.setOpenidOrKeyError();
                userResponse.header = header;
                return userResponse;
            }
            //获取到openid之后判断数据库中是否有数据
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(wxModel.openid);
            List<User> users = mUserMapper.selectByExample(example);
            User user;
            //如果数据库获取到了数据  返回数据库用户信息 否从微信获取数据并保存到数据库
            if (users.size() != 0) {
                user = users.get(0);
                user.setOpenid(null);
                user.setSessionkey(null);
            } else {
                user = getUserInfo(request.encryptedData, wxModel.session_key, request.iv);
                if(user==null){
                    header.setServerError();
                }else{
                   int type =  mUserMapper.insertSelective(user);
                   if (type!=0){
                       user.setOpenid(null);
                       user.setSessionkey(null);
                   }else{
                       user = null;
                       header.setServerError();
                   }
                }
            }
            userResponse.user = user;
        } else {
            header.setCodeError();
        }
        return userResponse;
    }

    /**
     *  获取微信用户信息
     * @param encryptedData
     * @param session_key
     * @param iv
     * @return
     */
    public User getUserInfo(String encryptedData, String session_key, String iv) {
        WxUserInfo userInfo = XcxUtils.getUserInfo(encryptedData, session_key, iv);
        if (userInfo == null) {
            return null;
        }
        User user = new User();
        user.setOpenid(userInfo.openId);
        user.setGender(userInfo.gender);
        user.setAvatarurl(userInfo.avatarUrl);
        user.setNickname(userInfo.nickName);
        user.setSessionkey(session_key);
        return user;
    }

    /**
     * 绑定手机号
     * @param request
     * @return
     */
    public ResponseHeader bindPhone(BindPhoneRequest request) {
        ResponseHeader responseHeader = new ResponseHeader();
        if(request.id==0||request.phone.isEmpty()){
            return responseHeader;
        }
        User user = new User();
        user.setId(request.id);
        user.setPhone(request.phone);
        int result = mUserMapper.updateByPrimaryKeySelective(user);
        if(result != 0){
            responseHeader.resultText= ConnectionMessage.BIND_SUCCESS_TEXT;
        }
        return responseHeader;
    }


}
