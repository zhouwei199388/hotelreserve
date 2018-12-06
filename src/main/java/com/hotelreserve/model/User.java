package com.hotelreserve.model;

public class User {
    String result = "{\n" +
            "\t\"openId\": \"ofIRZ5BAfiLYT203ahdW8oJiJAzU\",\n" +
            "\t\"nickName\": \"邹维\",\n" +
            "\t\"gender\": 1,\n" +
            "\t\"language\": \"zh_CN\",\n" +
            "\t\"city\": \"\",\n" +
            "\t\"province\": \"\",\n" +
            "\t\"country\": \"China\",\n" +
            "\t\"avatarUrl\": \"https://wx.qlogo.cn/mmopen/vi_32/FC7d3bDPUHSOMpMSiaHF0cliaP0IPiauVpGjia8LamtavvqiaxAQAeS4A7CCRd54tFq8bDSibgsmGIeoyw2eeiaWuflAQ/132\",\n" +
            "\t\"watermark\": {\n" +
            "\t\t\"timestamp\": 1544086416,\n" +
            "\t\t\"appid\": \"wxe7b86a74f9e96203\"\n" +
            "\t}\n" +
            "}"

    private Integer id;

    private String openid;

    private String sessionkey;

    private Integer level;

    private String phone;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey == null ? null : sessionkey.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}