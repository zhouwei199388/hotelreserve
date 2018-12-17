package com.hotelreserve.service;

import com.aliyun.oss.OSSClient;
import com.hotelreserve.http.ConnectionMessage;
import com.hotelreserve.http.model.ResponseHeader;
import com.hotelreserve.http.response.STSResponse;
import com.hotelreserve.utils.LogUtils;
import org.springframework.stereotype.Service;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;

import java.awt.*;

/**
 * Created by 15090 on 2018/12/16.
 */
@Service
public class AliStsService {

    /**
     * 判断oss文件夹是否存在
     * @return
     */
    public  boolean isBucketExit() {
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        String accessKeyId = "LTAIHKVYj6xAQ5Ib";
        String accessKeySecret = "OxaV0XyoL7lNuLEvLwVvnvCLCFwwRb";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 判断文件是否存在。
        boolean found = ossClient.doesObjectExist("hotelimage", "hotel/");
        // 关闭OSSClient。
        ossClient.shutdown();
        return found;
    }

    /**
     * 获取STS授权
     * @param fileName
     * @return
     */
    public STSResponse getAliSTS(String fileName) {
        STSResponse stsResponse = new STSResponse();
        ResponseHeader header = new ResponseHeader();
        String endpoint = "sts.cn-shanghai.aliyuncs.com";
        String accessKeyId = "LTAIHKVYj6xAQ5Ib";
        String accessKeySecret = "OxaV0XyoL7lNuLEvLwVvnvCLCFwwRb";
        String roleArn = "acs:ram::1659627747112333:role/hotel-admin";
        String roleSessionName = "hotel";
        String policy = "{\"Version\": \"1\",\"Statement\": [{\"Action\":[\"oss:*\"],\"Resource\":[\"acs:oss:*:*:*\"],\"Effect\":\"Allow\"}]}";
        try {
            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            // 构造default profile（参数留空，无需添加region ID）
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            // 用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setPolicy(policy); // Optional
            final AssumeRoleResponse response = client.getAcsResponse(request);
            stsResponse.accessKeyId = response.getCredentials().getAccessKeyId();
            stsResponse.accessKeySecret = response.getCredentials().getAccessKeySecret();
            stsResponse.securityToken = response.getCredentials().getSecurityToken();
            if(isBucketExit()){
                stsResponse.bukerName = fileName;
                header.code = ConnectionMessage.SUCCESS_CODE;
                header.msg = ConnectionMessage.SUCCESS_TEXT;
            }else{
                stsResponse.header.msg = ConnectionMessage.BUCKET_FILE_ISEXIT;
            }
//            System.out.println("Expiration: " + response.getCredentials().getExpiration());
//            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
//            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
//            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
//            System.out.println("RequestId: " + response.getRequestId());
        } catch (ClientException e) {
            LogUtils.info(e.toString());
        }
        stsResponse.header = header;
        return stsResponse;
    }
}
