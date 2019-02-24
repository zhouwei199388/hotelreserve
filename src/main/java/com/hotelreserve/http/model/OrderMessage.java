package com.hotelreserve.http.model;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by zouwei on 2019/2/24.
 */
public class OrderMessage implements Delayed{

    public final static long DELAY = 5*60*1000L;//默认延迟时间  5分钟

    private final int orderId;//订单id

    private final long startTime;//开始时间
    private final long expire; //到期时间
    private final Date now;//创建时间
    private final String orderMsg;//备用字段

    public OrderMessage(int orderId, long startTime, long secondsDelay) {
        super();
        this.orderId = orderId;
        this.startTime = startTime;
        this.expire = startTime+(secondsDelay*1000);
        this.now = new Date();
        this.orderMsg = "";
    }
    public OrderMessage(int orderId, long startTime) {
        super();
        this.orderId = orderId;
        this.startTime = startTime;
        this.expire = startTime+DELAY;
        this.now = new Date();
        this.orderMsg = "";
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
    }

    public int getOrderId() {
        return orderId;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getExpire() {
        return expire;
    }

    public Date getNow() {
        return now;
    }

    public String getOrderMsg() {
        return orderMsg;
    }




}
