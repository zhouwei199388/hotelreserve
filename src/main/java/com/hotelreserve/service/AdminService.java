package com.hotelreserve.service;

import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.AdminResponse;
import com.hotelreserve.mapper.AdminMapper;
import com.hotelreserve.model.Admin;
import com.hotelreserve.model.AdminExample;
import com.hotelreserve.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zouwei on 2018/12/12.
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper mAdminMapper;

    public AdminResponse selectAdmin(Admin admin) {
        LogUtils.info(admin.toString());
        AdminResponse adminResponse = new AdminResponse();
        ResponseHeader header = new ResponseHeader();
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(admin.getUser());
        criteria.andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = mAdminMapper.selectByExample(example);
        if (admins.size() > 0) {
              header.resultText = ConnectionMessage.LOGIN_SUCCESS_TEXT;
        }else{
            header.resultText = ConnectionMessage.LOGIN_FAIL_TEXT;
        }
        adminResponse.header = header;
        return adminResponse;
    }
}
