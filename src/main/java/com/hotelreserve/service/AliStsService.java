package com.hotelreserve.service;

import org.springframework.stereotype.Service;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
/**
 * Created by 15090 on 2018/12/16.
 */
@Service
public class AliStsService  {

    public static void main(String[] args){
//        getAliSTS();
    }


    public  void getAliSTS(){
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
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());
        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());
        }
    }
}
