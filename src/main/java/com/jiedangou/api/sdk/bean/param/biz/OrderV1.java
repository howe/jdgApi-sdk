package com.jiedangou.api.sdk.bean.param.biz;

import com.jiedangou.api.sdk.bean.dict.Dict;
import com.jiedangou.api.sdk.bean.param.pro.Account;
import com.jiedangou.api.sdk.bean.param.pro.Contact;
import org.nutz.json.JsonField;
import org.nutz.lang.Lang;

import java.util.Date;

/**
 * 订单
 * Created on 2017/11/21
 *
 * @author Jianghao(howechiang@gmail.com)
 */
public class OrderV1 {

    /**
     * 外部订单号
     */
    private String outOrderNum;

    public String getOutOrderNum() {
        return outOrderNum;
    }

    public void setOutOrderNum(String outOrderNum) {
        this.outOrderNum = outOrderNum;
    }

    /**
     * 游戏名称
     * 请与接单狗平台数据同步
     */
    private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * 渠道名称
     * 请与接单狗平台数据同步
     */
    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 服务器名称
     * 请与接单狗平台数据同步
     */
    private String serverName;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * 订单标题
     */
    private String orderTitle;

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    /**
     * 订单类型
     * 1 普通
     * 2 优质
     * 3 私有
     */
    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 订单金额
     * 保留2位小数
     * 单位 元
     */
    private Double orderAmount;

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 安全保证金
     * 保留2位小数
     * 单位 元
     */
    private Double safetyMargin;

    public Double getSafetyMargin() {
        return safetyMargin;
    }

    public void setSafetyMargin(Double safetyMargin) {
        this.safetyMargin = safetyMargin;
    }

    /**
     * 效率保证金
     * 保留2位小数
     * 单位 元
     */
    private Double efficiencyMargin;

    public Double getEfficiencyMargin() {
        return efficiencyMargin;
    }

    public void setEfficiencyMargin(Double efficiencyMargin) {
        this.efficiencyMargin = efficiencyMargin;
    }

    /**
     * 订单要求完成时间
     */
    @JsonField(dataFormat = Dict.DATE_FORMART_FULL)
    private Date requiredCompleteTime;

    public Date getRequiredCompleteTime() {
        return requiredCompleteTime;
    }

    public void setRequiredCompleteTime(Date requiredCompleteTime) {
        this.requiredCompleteTime = requiredCompleteTime;
    }

    /**
     * 代练(Power Leveling)类型
     * 1 排位 默认
     * 2 定位
     * 3 等级
     * 4 陪练
     * 5 匹配
     * 6 晋级
     * 7 级别
     * 0 其他
     */
    private Integer plType;

    public Integer getPlType() {
        return plType;
    }

    public void setPlType(Integer plType) {

        if (Lang.isEmpty(plType)) {
            this.plType = 1;
        } else {
            this.plType = plType;
        }
    }

    /**
     * 代练(Power Leveling)要求
     */
    private String plRequired;

    public String getPlRequired() {
        return plRequired;
    }

    public void setPlRequired(String plRequired) {
        this.plRequired = plRequired;
    }

    /**
     * 订单说明
     */
    private String orderDesc;

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    /**
     * 客户游戏账户信息
     */
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * 订单备注
     */
    private String orderRemark;

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    /**
     * 附加数据
     * 原样返回，可作为自定义参数使用
     */
    private String attach;

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    /**
     * 联系方式
     */
    private Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}