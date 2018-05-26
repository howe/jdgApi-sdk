package com.jiedangou.api.sdk.bean.param.req.biz;

/**
 * Created on 2018/1/14
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class FetchOrder {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public FetchOrder(String orderNo) {
        this.orderNo = orderNo;
    }

    public FetchOrder() {
    }
}
