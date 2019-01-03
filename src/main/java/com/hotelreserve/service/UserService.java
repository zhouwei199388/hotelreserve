package com.hotelreserve.service;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.WXmessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.model.UserModel;
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
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
            //获取微信openid和sessionkey
            wxModel = XcxUtils.getSessionKeyOropenid(request.code, WXmessage.APP_ID, WXmessage.APP_SECRET);
            if (wxModel.openid == null || wxModel.session_key == null) {
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
                header.setSuccess();
            } else {
                user = getUserInfo(request.encryptedData, wxModel.session_key, request.iv);
                if (user == null) {
                    header.setServerError();
                } else {
                    int type = mUserMapper.insertSelective(user);
                    if (type != 0) {
                        header.setSuccess();
                    } else {
                        user = null;
                        header.setServerError();
                    }
                }
            }
            userResponse.header = header;
            if (user != null) {
                UserModel userModel = new UserModel();
                userModel.copyFromUser(user);
                userResponse.user = userModel;
            }
        } else {
            header.setCodeError();
        }
        return userResponse;
    }

    /**
     * 获取微信用户信息
     *
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
     *
     * @param request
     * @return
     */
    public UserResponse bindPhone(BindPhoneRequest request) {
        UserResponse userResponse = new UserResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if (request.id == 0 || request.phone.isEmpty()) {
            userResponse.header = responseHeader;
            return userResponse;
        }
        User user = mUserMapper.selectByPrimaryKey(request.id);
        if(user==null){
            userResponse.header = responseHeader;
            return userResponse;
        }
        user.setPhone(request.phone);
        int result = mUserMapper.updateByPrimaryKeySelective(user);
        if (result != 0) {
            responseHeader.code = ConnectionMessage.SUCCESS_CODE;
            responseHeader.msg = ConnectionMessage.BIND_SUCCESS_TEXT;
        }
        userResponse.header = responseHeader;
        return userResponse;
    }


    /**
     * 获取所有用户
     *
     * @return
     */
    public UserResponse getUserList() {
        UserResponse response = new UserResponse();
        ResponseHeader header = new ResponseHeader();
        List<User> users = mUserMapper.selectByExample(new UserExample());
        if (users.size() == 0) {
            header.msg = ConnectionMessage.DATA_IS_NULL;
        } else {
            header.code = ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.SUCCESS_TEXT;
            response.formatUser(users);
        }
        response.header = header;
        return response;
    }

    /**
     *  发送验证码
     * @param phone
     * @return
     */
    public ResponseHeader sendVerifycode(String phone,String verifyCode){
        ResponseHeader header = new ResponseHeader();
        header.setSuccess();
        try {
            String[] params = {verifyCode,"5"};//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
            SmsSingleSender ssender = new SmsSingleSender(WXmessage.SMS_APP_ID, WXmessage.APP_KEY);
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    WXmessage.TEMPLATE_ID, params, WXmessage.SMS_SIGN, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
            header.setSuccess();
        } catch (HTTPException e) {
            // HTTP响应码错误
            header.setServerError();
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            header.setServerError();
            e.printStackTrace();
        } catch (IOException e) {
            header.setServerError();
            // 网络IO错误
            e.printStackTrace();
        }
        return header;
    }

}
