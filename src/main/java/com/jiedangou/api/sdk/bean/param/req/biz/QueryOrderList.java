package com.jiedangou.api.sdk.bean.param.req.biz;

import org.nutz.lang.Lang;

/**
 * Created by Jianghao on 2017/12/22
 *
 * @howechiang
 */
public class QueryOrderList {

    private Integer pageNumber;
    private Integer pageSize;

    public Integer getPageNumber() {
        return Lang.isEmpty(pageNumber) ? 1 : pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return Lang.isEmpty(pageSize) ? 30 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public QueryOrderList() {
    }

    public QueryOrderList(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
