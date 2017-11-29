package com.jiedangou.api.sdk.bean.param.biz;

/**
 * 修改订单
 * Created on 2017/11/29
 *
 * @author Jianghao(howechiang@gmail.com)
 */
public class ModifyOrder {

    /**
     * 接单狗订单号
     * 必填
     */
    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 操作类型
     * 必填
     * 锁定账号	OP_LOCK	订单在以下状态才能使用：代练中、异常、待验收
     * 取消锁定	OP_ UNLOCK	订单在以下状态才能使用：已锁定
     * 申请验收	OP_APPLY_ACCEPTANCE	订单在以下状态才能使用：代练中
     * 取消验收	OP_CANCEL_ACCEPTANCE	订单在以下状态才能使用：待验收
     * 完成验收	OP_COMPLETE_ACCEPTANCE	订单在以下状态才能使用：待验收
     * 申请撤销	OP_APPLY_CANCELLATION	订单在以下状态才能使用：代练中、异常、待验收、已锁定
     * 取消撤销	OP_CANCELL_CANCELLATION	订单在以下状态才能使用：撤销中
     * 同意撤销	OP_AGREE_WITHDRAW	订单在以下状态才能使用：撤销中
     * 申请仲裁	OP_APPLY_ARBITRATION	订单在以下状态才能使用：撤销中
     * 取消仲裁	OP_CANCEL_ARBITRATION	订单在以下状态才能使用：仲裁中
     * 提交异常	OP_ABNORMAL_EXCEPTION	订单在以下状态才能使用：代练中
     * 取消异常	OP_CANCEL_EXCEPTION	订单在以下状态才能使用：异常
     * 补时	OP_STOPPAGE_TIME
     * 补款	OP_FILLING_MONEY
     * 修正密码	OP_CORRECT_PASSWORD
     */
    private String operationType;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * 备注理由
     * 在执行申请撤销、提交异常、申请仲裁操作时必填
     */
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 支付密码
     * 在执行完成验收、申请撤销、同意撤销、补款操作时必填，
     * Base64加密后传输，请勿明文
     */
    private String payPassword;

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 加款钱数
     * 在执行补款操作时必填，
     * 单位 元
     */
    private Double addMoney;

    public Double getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(Double addMoney) {
        this.addMoney = addMoney;
    }

    /**
     * 加时
     * 在执行补时操作时必填，
     * 单位 小时
     */
    private Integer addTime;

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * 修正的密码
     * 在执行修正密码操作时必填，
     * Base64加密后传输，请勿明文
     */
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * 事主需支付的金额
     * 在执行申请撤销操作时必填，
     * 单位 元
     */
    private Double payAmount;

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 代练需赔付的金额
     * 在执行申请撤销操作时必填，
     * 单位 元
     */
    private Double offset;

    public Double getOffset() {
        return offset;
    }

    public void setOffset(Double offset) {
        this.offset = offset;
    }
}
