package com.jiedangou.api.sdk.util.inf;

import com.jiedangou.api.sdk.bean.dict.Dict;
import com.jiedangou.api.sdk.bean.param.biz.ModifyOrder;
import com.jiedangou.api.sdk.bean.param.req.biz.CreateOrder;
import com.jiedangou.api.sdk.bean.param.req.biz.CreateOrderV1;
import com.jiedangou.api.sdk.bean.param.req.BaseReq;
import com.jiedangou.api.sdk.bean.param.resp.BaseResp;
import com.jiedangou.api.sdk.util.HttpUtil;
import com.jiedangou.api.sdk.util.JdgUtil;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;

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
                    String json = HttpUtil.post(Dict.JDG_API_HOST + Dict.JDG_API_ACTION_ORDER_CREATEORDER, Json.toJson(req));
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
                    String json = HttpUtil.post(Dict.JDG_API_HOST + Dict.JDG_API_ACTION_ORDER_CREATEORDER_V1, Json.toJson(req));
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
            return null;
        }
    }


    /**
     * 4.5 修改订单
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @param order     订单信息
     * @return
     */
    public static Boolean order(Integer partnerId, String key, ModifyOrder order) {

        try {
            if (Lang.isEmpty(order.getOrderNum())) {
                throw new Exception("order.orderNum接单狗订单号为空");
            }
            if (Lang.isEmpty(order.getOrderNum())) {
                throw new Exception("order.orderNum接单狗订单号为空");
            }
            if (Lang.isEmpty(order.getOperationType())) {
                throw new Exception("操作类型为空");
            }
            if (JdgUtil.checkArrayExists(Dict.OPERATIONTYPE_ARRAY, order.getOperationType())) {
                throw new Exception("操作类型错误");
            }
            if ((Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_APPLY_CANCELLATION)
                    || Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_ABNORMAL_EXCEPTION)
                    || Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_APPLY_ARBITRATION))
                    && Strings.isBlank(order.getReason())) {
                throw new Exception("备注理由为空");
            }
            if ((Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_COMPLETE_ACCEPTANCE)
                    || Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_APPLY_CANCELLATION)
                    || Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_AGREE_WITHDRAW)
                    || Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_FILLING_MONEY))
                    && Strings.isBlank(order.getPayPassword())) {
                throw new Exception("支付密码为空");
            }
            if (Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_FILLING_MONEY)
                    && Lang.isEmpty(order.getAddMoney())) {
                throw new Exception("加款钱数为空");
            }
            if (Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_STOPPAGE_TIME)
                    && Lang.isEmpty(order.getAddTime())) {
                throw new Exception("加时时长为空");
            }
            if (Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_CORRECT_PASSWORD)
                    && Strings.isBlank(order.getNewPassword())) {
                throw new Exception("修正密码为空");
            }
            if (Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_APPLY_CANCELLATION)
                    && Lang.isEmpty(order.getPayAmount())) {
                throw new Exception("需支付金额为空");
            }

            if (Strings.equalsIgnoreCase(order.getOperationType(), Dict.OPERATIONTYPE_OP_APPLY_CANCELLATION)
                    && Lang.isEmpty(order.getOffset())) {
                throw new Exception("需赔付金额为空");
            }
            return null;
        } catch (Exception e) {
            return false;
        }
    }
}
