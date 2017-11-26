package com.jiedangou.api.sdk.util.inf;

import com.jiedangou.api.sdk.bean.dict.Dict;
import com.jiedangou.api.sdk.bean.param.biz.Order;
import com.jiedangou.api.sdk.bean.param.biz.OrderV1;
import com.jiedangou.api.sdk.bean.param.req.BaseReq;
import com.jiedangou.api.sdk.bean.param.resp.BaseResp;
import com.jiedangou.api.sdk.util.HttpUtil;
import com.jiedangou.api.sdk.util.JdgUtil;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 订单
 * Created on 2017/11/26
 *
 * @author Jianghao(howechiang@gmail.com)
 */
public class OrderUtil {

    protected static final Log log = Logs.get();

    /**
     * 4.3 发布订单
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param order     订单信息
     * @return
     */
    public static String createOrder(Integer partnerId, String key, Order order) {

        if (Lang.isEmpty(partnerId)) {
            log.error("url为空");
            return null;
        } else if (Strings.isBlank(key)) {
            log.error("key为空");
            return null;
        } else {
            if (Strings.isEmpty(order.getOutOrderNum())) {
                log.error("order.outOrderNum为空");
                return null;
            } else if (Lang.isEmpty(order.getGameId())) {
                log.error("order.gameId为空");
                return null;
            } else if (Lang.isEmpty(order.getChannelId())) {
                log.error("order.channelId为空");
                return null;
            } else if (Lang.isEmpty(order.getServerId())) {
                log.error("order.serverId为空");
                return null;
            } else if (Strings.isBlank(order.getOrderTitle())) {
                log.error("order.orderTitle为空");
                return null;
            } else if (Lang.isEmpty(order.getOrderType())) {
                log.error("order.orderType为空");
                return null;
            } else if (JdgUtil.checkArrayExists(Dict.ORDERTYPE_ARRAY, order.getOrderType())) {
                log.error("order.orderType订单类型错误");
                return null;
            } else if (Lang.isEmpty(order.getOrderAmount())) {
                log.error("order.orderAmount为空");
                return null;
            } else if (Lang.isEmpty(order.getEfficiencyMargin())) {
                log.error("order.efficiencyMargin为空");
                return null;
            } else if (Lang.isEmpty(order.getSafetyMargin())) {
                log.error("order.safetyMargin为空");
                return null;
            } else if (Lang.isEmpty(order.getRequiredCompleteTime())) {
                log.error("order.requiredCompleteTime为空");
                return null;
            } else if (!JdgUtil.checkArrayExists(Dict.PLTYPE_ARRAY, order.getPlType())) {
                log.error("order.plType代练类型错误");
                return null;
            } else if (Strings.isBlank(order.getPlRequired())) {
                log.error("order.plRequired为空");
                return null;
            } else if (Lang.isEmpty(order.getAccount())) {
                log.error("order.gaccount为空");
                return null;
            } else if (Lang.isEmpty(order.getContact())) {
                log.error("order.contact为空");
                return null;
            } else if (JdgUtil.checkAccount(order.getAccount())) {
                return null;
            } else if (JdgUtil.checkContact(order.getContact())) {
                return null;
            } else {
                BaseReq req = new BaseReq();
                req.setPartnerId(partnerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setBizData(Lang.obj2nutmap(order));
                req.setSign(Lang.md5(JdgUtil.buildParmas(Lang.obj2nutmap(req), new String[]{"sign"}) + key));
                String json = HttpUtil.post(Dict.JDG_API_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMELIST, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    log.error("返回值异常");
                    return null;
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    String orderNum = resp.getData().getString("orderNum");
                    return orderNum;
                }
            }
        }
    }

    /**
     * 4.4 发布订单
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param order     订单信息
     * @return
     */
    public static String createOrderV1(Integer partnerId, String key, OrderV1 order) {

        if (Lang.isEmpty(partnerId)) {
            log.error("url为空");
            return null;
        } else if (Strings.isBlank(key)) {
            log.error("key为空");
            return null;
        } else {
            if (Strings.isEmpty(order.getOutOrderNum())) {
                log.error("order.outOrderNum为空");
                return null;
            } else if (Strings.isBlank(order.getGameName())) {
                log.error("order.gameName为空");
                return null;
            } else if (Strings.isBlank(order.getChannelName())) {
                log.error("order.channelName为空");
                return null;
            } else if (Strings.isBlank(order.getServerName())) {
                log.error("order.serverName为空");
                return null;
            } else if (Strings.isBlank(order.getOrderTitle())) {
                log.error("order.orderTitle为空");
                return null;
            } else if (Lang.isEmpty(order.getOrderType())) {
                log.error("order.orderType为空");
                return null;
            } else if (!JdgUtil.checkArrayExists(Dict.ORDERTYPE_ARRAY, order.getOrderType())) {
                log.error("order.orderType订单类型错误");
                return null;
            } else if (Lang.isEmpty(order.getOrderAmount())) {
                log.error("order.orderAmount为空");
                return null;
            } else if (Lang.isEmpty(order.getEfficiencyMargin())) {
                log.error("order.efficiencyMargin为空");
                return null;
            } else if (Lang.isEmpty(order.getSafetyMargin())) {
                log.error("order.safetyMargin为空");
                return null;
            } else if (Lang.isEmpty(order.getRequiredCompleteTime())) {
                log.error("order.requiredCompleteTime为空");
                return null;
            } else if (!JdgUtil.checkArrayExists(Dict.PLTYPE_ARRAY, order.getPlType())) {
                log.error("order.plType代练类型错误");
                return null;
            } else if (Strings.isBlank(order.getPlRequired())) {
                log.error("order.plRequired为空");
                return null;
            } else if (Lang.isEmpty(order.getAccount())) {
                log.error("order.gaccount为空");
                return null;
            } else if (Lang.isEmpty(order.getContact())) {
                log.error("order.contact为空");
                return null;
            } else if (JdgUtil.checkAccount(order.getAccount())) {
                return null;
            } else if (JdgUtil.checkContact(order.getContact())) {
                return null;
            } else {
                BaseReq req = new BaseReq();
                req.setPartnerId(partnerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setBizData(Lang.obj2nutmap(order));
                req.setSign(Lang.md5(JdgUtil.buildParmas(Lang.obj2nutmap(req), new String[]{"sign"}) + key));
                String json = HttpUtil.post(Dict.JDG_API_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMELIST, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    log.error("返回值异常");
                    return null;
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    String orderNum = resp.getData().getString("orderNum");
                    return orderNum;
                }
            }
        }
    }
}
