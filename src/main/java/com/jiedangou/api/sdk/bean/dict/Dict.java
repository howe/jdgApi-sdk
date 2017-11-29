package com.jiedangou.api.sdk.bean.dict;

/**
 * Created on 2017/11/25
 *
 * @author Jianghao(howechiang@gmail.com)
 */
public class Dict {

    public static final String DATE_FORMART_FULL = "yyyy-MM-dd HH:mm:ss";
    public static String JDG_API_HOST = "https://api.jiedangou.com";
    public static String JDG_API_VERSION = "1.0";
    public static String JDG_API_ACTION_GAME_QUERYGAMELIST = "/game/queryGameList.htm";
    public static String JDG_API_ACTION_GAME_QUERYGAMEDETAIL = "/game/queryGame.htm";
    public static String JDG_API_ACTION_ORDER_CREATEORDER = "/order/createOrder.htm";
    public static String JDG_API_ACTION_ORDER_CREATEORDER_V1 = "/order/createOrderV1.htm";
    public static String JDG_API_ACTION_ORDER_MODIFYORDER = "/order/modifyOrder.htm";

    /**
     * 订单类型
     * 1 普通
     * 2 优质
     * 3 私有
     */
    public static final Integer ORDERTYPE_ARRAY[] = {1, 2, 3};

    public static final Integer ORDERTYPE_ORDINARY = 1;
    public static final Integer ORDERTYPE_GRADE = 2;
    public static final Integer ORDERTYPE_PRIVATE = 3;

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
    public static final Integer PLTYPE_ARRAY[] = {0, 1, 2, 3, 4, 5, 6, 7};

    /**
     * 订单状态
     * 0 已取消
     * 1 已下单（未接手）
     * 2 处理中（代练中）
     * 3 待验收
     * 4 撤销中
     * 5 仲裁中
     * 6 异常
     * 7 锁定
     * 8 已下架
     * 9 已撤销
     * 10 已仲裁
     * 11 强制仲裁
     * 88 已结算
     * 99 已完成
     */
    public static final Integer ORDERSTATUS_ARRAY[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 88, 99};
}
