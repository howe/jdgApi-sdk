package com.jiedangou.api.sdk.util.api;

import com.jiedangou.api.sdk.bean.dict.Dict;
import com.jiedangou.api.sdk.bean.param.biz.PaOrder;
import com.jiedangou.api.sdk.bean.param.req.biz.CreateOrder;
import com.jiedangou.api.sdk.bean.param.req.biz.CreateOrderV1;
import com.jiedangou.api.sdk.bean.param.req.BaseReq;
import com.jiedangou.api.sdk.bean.param.req.biz.FetchOrder;
import com.jiedangou.api.sdk.bean.param.req.biz.QueryOrderList;
import com.jiedangou.api.sdk.bean.param.resp.BaseResp;
import com.jiedangou.api.sdk.util.HttpUtil;
import com.jiedangou.api.sdk.util.JdgUtil;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;

import java.util.List;

/**
 * 订单
 * Created on 2017/11/26
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class OrderUtil {

    /**
     * 4.3 发布订单
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param biz       订单信息
     * @return
     */
    public static String createOrder(Integer partnerId, String key, CreateOrder biz) {

        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("url为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else {
                if (Strings.isEmpty(biz.getOutOrderNum())) {
                    throw new Exception("order.outOrderNum为空");
                } else if (Lang.isEmpty(biz.getGameId())) {
                    throw new Exception("order.gameId为空");
                } else if (Lang.isEmpty(biz.getChannelId())) {
                    throw new Exception("order.channelId为空");
                } else if (Lang.isEmpty(biz.getServerId())) {
                    throw new Exception("order.serverId为空");
                } else if (Strings.isBlank(biz.getOrderTitle())) {
                    throw new Exception("order.orderTitle为空");
                } else if (Lang.isEmpty(biz.getOrderType())) {
                    throw new Exception("order.orderType为空");
                } else if (!JdgUtil.checkArrayExists(Dict.ORDERTYPE_ARRAY, biz.getOrderType())) {
                    throw new Exception("order.orderType订单类型错误");
                } else if (Lang.equals(biz.getOrderType(), Dict.ORDERTYPE_PRIVATE) && Lang.isEmpty(biz.getProviderId())) {
                    throw new Exception("order.providerId服务商ID为空");
                } else if (Lang.isEmpty(biz.getOrderAmount())) {
                    throw new Exception("order.orderAmount为空");
                } else if (Lang.isEmpty(biz.getEfficiencyMargin())) {
                    throw new Exception("order.efficiencyMargin为空");
                } else if (Lang.isEmpty(biz.getSafetyMargin())) {
                    throw new Exception("order.safetyMargin为空");
                } else if (Lang.isEmpty(biz.getRequiredCompleteTime())) {
                    throw new Exception("order.requiredCompleteTime为空");
                } else if (!JdgUtil.checkArrayExists(Dict.PLTYPE_ARRAY, biz.getPlType())) {
                    throw new Exception("order.plType代练类型错误");
                } else if (Strings.isBlank(biz.getPlRequired())) {
                    throw new Exception("order.plRequired为空");
                } else if (Lang.isEmpty(biz.getAccount())) {
                    throw new Exception("order.gaccount为空");
                } else if (Lang.isEmpty(biz.getContact())) {
                    throw new Exception("order.contact为空");
                } else if (!JdgUtil.checkAccount(biz.getAccount())) {
                    throw new Exception("order.account验证失败");
                } else if (!JdgUtil.checkContact(biz.getContact())) {
                    throw new Exception("order.contact验证失败");
                } else {
                    BaseReq req = new BaseReq();
                    req.setPartnerId(partnerId);
                    req.setTimestamp(Times.getTS());
                    req.setVersion(Dict.JDG_API_VERSION);
                    req.setBizData(Lang.obj2nutmap(biz));
                    req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                    String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_ORDER_CREATEORDER, Json.toJson(req));
                    if (Strings.isEmpty(json)) {
                        throw new Exception("返回值异常");
                    } else {
                        BaseResp resp = Json.fromJson(BaseResp.class, json);
                        String orderNum = resp.getData().getString("orderNum");
                        return orderNum;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 4.4 发布订单
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param biz       订单信息
     * @return
     */
    public static String createOrderV1(Integer partnerId, String key, CreateOrderV1 biz) {

        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("url为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else {
                if (Strings.isEmpty(biz.getOutOrderNum())) {
                    throw new Exception("order.outOrderNum为空");
                } else if (Strings.isBlank(biz.getGameName())) {
                    throw new Exception("order.gameName为空");
                } else if (Strings.isBlank(biz.getChannelName())) {
                    throw new Exception("order.channelName为空");
                } else if (Strings.isBlank(biz.getServerName())) {
                    throw new Exception("order.serverName为空");
                } else if (Strings.isBlank(biz.getOrderTitle())) {
                    throw new Exception("order.orderTitle为空");
                } else if (Lang.isEmpty(biz.getOrderType())) {
                    throw new Exception("order.orderType为空");
                } else if (!JdgUtil.checkArrayExists(Dict.ORDERTYPE_ARRAY, biz.getOrderType())) {
                    throw new Exception("order.orderType订单类型错误");
                } else if (Lang.isEmpty(biz.getOrderAmount())) {
                    throw new Exception("order.orderAmount为空");
                } else if (Lang.isEmpty(biz.getEfficiencyMargin())) {
                    throw new Exception("order.efficiencyMargin为空");
                } else if (Lang.isEmpty(biz.getSafetyMargin())) {
                    throw new Exception("order.safetyMargin为空");
                } else if (Lang.isEmpty(biz.getRequiredCompleteTime())) {
                    throw new Exception("order.requiredCompleteTime为空");
                } else if (!JdgUtil.checkArrayExists(Dict.PLTYPE_ARRAY, biz.getPlType())) {
                    throw new Exception("order.plType代练类型错误");
                } else if (Lang.equals(biz.getOrderType(), Dict.ORDERTYPE_PRIVATE) && Lang.isEmpty(biz.getProviderId())) {
                    throw new Exception("order.providerId服务商ID为空");
                } else if (Strings.isBlank(biz.getPlRequired())) {
                    throw new Exception("order.plRequired为空");
                } else if (Lang.isEmpty(biz.getAccount())) {
                    throw new Exception("order.gaccount为空");
                } else if (Lang.isEmpty(biz.getContact())) {
                    throw new Exception("order.contact为空");
                } else if (!JdgUtil.checkAccount(biz.getAccount())) {
                    throw new Exception("order.account验证失败");
                } else if (!JdgUtil.checkContact(biz.getContact())) {
                    throw new Exception("order.contact验证失败");
                } else {
                    BaseReq req = new BaseReq();
                    req.setPartnerId(partnerId);
                    req.setTimestamp(Times.getTS());
                    req.setVersion(Dict.JDG_API_VERSION);
                    req.setBizData(Lang.obj2nutmap(biz));
                    req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                    String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_ORDER_CREATEORDER_V1, Json.toJson(req));
                    if (Strings.isEmpty(json)) {
                        throw new Exception("返回值异常");
                    } else {
                        BaseResp resp = Json.fromJson(BaseResp.class, json);
                        String orderNum = resp.getData().getString("orderNum");
                        return orderNum;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 4.20 查询订单信息
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param biz       业务数据
     * @return
     */
    public static PaOrder fetchOrder(Integer partnerId, String key, FetchOrder biz) {

        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("合作商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            if (Strings.isBlank(biz.getOrderNum())) {
                throw new Exception("接单狗订单号为空");
            }
            BaseReq req = new BaseReq();
            req.setPartnerId(partnerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_ORDER_FETCHORDER, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                PaOrder order = resp.getData().getAs("order", PaOrder.class);
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 4.21 查询订单列表
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param biz       业务数据
     * @return
     */
    public static QueryResult queryOrderList(Integer partnerId, String key, QueryOrderList biz) {
        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("合作商ID为空");
            }
            if (Strings.isBlank(key)) {
                throw new Exception("密钥为空");
            }
            BaseReq req = new BaseReq();
            req.setPartnerId(partnerId);
            req.setTimestamp(Times.getTS());
            req.setVersion(Dict.JDG_API_VERSION);
            req.setBizData(Lang.obj2nutmap(biz));
            req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
            String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_ORDER_QUERYORDERLIST, Json.toJson(req));
            if (Strings.isEmpty(json)) {
                throw new Exception("返回值异常");
            } else {
                BaseResp resp = Json.fromJson(BaseResp.class, json);
                List<PaOrder> orders = resp.getData().getAsList("orders", PaOrder.class);
                Pager pager = resp.getData().getAs("pager", Pager.class);
                return new QueryResult(orders, pager);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
