package com.jiedangou.api.sdk.bean.param.req.biz;

/**
 * Created on 2018/1/14
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class FetchOrder {

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public FetchOrder(String orderNum) {
        this.orderNum = orderNum;
    }

    public FetchOrder() {
    }
}
