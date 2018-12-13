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

    /**
     * 登录
     *
     * @param admin
     * @return
     */
    public AdminResponse loginAdmin(Admin admin) {
        LogUtils.info(admin.toString());
        AdminResponse adminResponse = new AdminResponse();
        ResponseHeader header = new ResponseHeader();
        if (admin.getPassword().isEmpty() && admin.getPassword().isEmpty()) {
            adminResponse.header = header;
            return adminResponse;
        }
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(admin.getUser());
        criteria.andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = mAdminMapper.selectByExample(example);
        if (admins.size() > 0) {
            header.code = ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.LOGIN_SUCCESS_TEXT;
            adminResponse.admin = admins.get(0);
        } else {
            header.msg = ConnectionMessage.LOGIN_FAIL_TEXT;
        }
        adminResponse.header = header;
        return adminResponse;
    }

    /**
     * 添加管理员
     *
     * @param admin
     * @return
     */
    public ResponseHeader addAdmin(Admin admin) {
        ResponseHeader header = new ResponseHeader();
        int type = mAdminMapper.insertSelective(admin);
        if (type == 0) {
            header.msg = ConnectionMessage.ADD_FAIL_TEXT;
        } else {
            header.code = ConnectionMessage.SUCCESS_CODE;
            header.msg = ConnectionMessage.ADD_SUCCESS_TEXT;
        }
        return header;
    }
}
