package com.hotelreserve.model;

public class PreOrderResponse {
    private Integer id;

    private Integer orderid;

    private String noncestr;

    private String packagestr;

    private String timestamap;

    private String paysign;

    private String appid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr == null ? null : noncestr.trim();
    }

    public String getPackagestr() {
        return packagestr;
    }

    public void setPackagestr(String packagestr) {
        this.packagestr = packagestr == null ? null : packagestr.trim();
    }

    public String getTimestamap() {
        return timestamap;
    }

    public void setTimestamap(String timestamap) {
        this.timestamap = timestamap == null ? null : timestamap.trim();
    }

    public String getPaysign() {
        return paysign;
    }

    public void setPaysign(String paysign) {
        this.paysign = paysign == null ? null : paysign.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }
}