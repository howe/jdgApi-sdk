package com.jiedangou.api.sdk.util;

import org.nutz.lang.Encoding;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.util.NutMap;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.apache.commons.codec.binary.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

/**
 * Created on 2017/11/25
 *
 * @author Jianghao(howechiang@gmail.com)
 */
public class JdgUtil {

    protected static final Log log = Logs.get();

    /**
     * Map排序
     *
     * @param params 待排序对象
     * @param order  排序后的对象
     * @return
     */
    public static Map<String, Object> sorting(Map<String, Object> params, String order) {

        if (Lang.isEmpty(params)) {
            return null;
        } else {
            Map<String, Object> map = new LinkedHashMap<>();
            if (Strings.equalsIgnoreCase(order, "desc")) {
                params.entrySet().stream()
                        .sorted(Map.Entry.<String, Object>comparingByKey().reversed())
                        .forEachOrdered(x -> map.put(x.getKey(), x.getValue()));
            } else {
                params.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEachOrdered(x -> map.put(x.getKey(), x.getValue()));
            }
            return map;
        }
    }

    /**
     * 构建参数
     *
     * @param params 代构建的map
     * @param f      过滤字段
     * @return 构建过的字符串
     */
    public static String buildParmas(Map<String, Object> params, String[] f) {

        if (Lang.isEmpty(f)) {
            return buildParmas(params);
        } else {
            Arrays.asList(f).stream().forEach(params::remove);
            return buildParmas(params);
        }
    }

    /**
     * 构建参数
     *
     * @param params 代构建的map
     * @return 构建过的字符串
     */
    public static String buildParmas(Map<String, Object> params) {

        if (Lang.isEmpty(params)) {
            return null;
        } else {
            params = sorting(params, "asc");
            StringBuffer sb = new StringBuffer();
            params.forEach((k, v) -> {
                if (!Lang.isEmpty(v)) {
                    sb.append(k + "=" + v + "&");
                }
            });
            return Strings.removeLast(sb.toString().replaceAll(" , ", ",").replaceAll(" ,", ",").replaceAll(", ", ","), '&');
        }
    }

    /**
     * URL转解码
     */
    public static class Url {

        /**
         * 加密
         *
         * @param s
         * @return
         */
        public static String encode(String s) {

            if (Strings.isBlank(s)) {
                return "";
            } else {
                try {
                    return URLEncoder.encode(s, Encoding.UTF8);
                } catch (UnsupportedEncodingException e) {
                    log.error(e.getMessage());
                    return "";
                }
            }
        }

        /**
         * 解密
         *
         * @param s
         * @return
         */
        public static String decode(String s) {

            if (Strings.isBlank(s)) {
                return "";
            } else {
                try {
                    return URLDecoder.decode(s, Encoding.UTF8);
                } catch (UnsupportedEncodingException e) {
                    log.error(e.getMessage());
                    return "";
                }
            }
        }
    }

    /**
     * BASE64加解密
     */
    public static class Base64 {

        /**
         * 加密
         *
         * @param s
         * @return
         */
        public static String encode(String s) {

            if (Strings.isBlank(s)) {
                return "";
            } else {
                return encodeBase64String(s.getBytes(Encoding.CHARSET_UTF8));
            }
        }

        /**
         * 解密
         *
         * @param s
         * @return
         */
        public static String decode(String s) {
            if (Strings.isBlank(s)) {
                return "";
            } else {
                return StringUtils.newStringUtf8(decodeBase64(s));
            }
        }
    }

    /**
     * 校验签名
     *
     * @param params
     * @param key
     * @return
     */
    public static Boolean checkSign(NutMap params, String key) {

        String sign = params.getString("sign");
        System.out.println(Lang.md5(Url.encode(buildParmas(params, new String[]{"sign"})) + key));
        if (Lang.isEmpty(params) || Strings.isBlank(key)) {
            return false;
        } else {
            if (Strings.equalsIgnoreCase(Lang.md5(Url.encode(buildParmas(params, new String[]{"sign"})) + key), sign)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 构建签名
     *
     * @param obj
     * @param key
     * @return
     */
    public static String buildSign(NutMap obj, String key) {
        if (Lang.isEmpty(obj)) {
            log.error("加密对象为空");
            return null;
        } else if (Strings.isEmpty(key)) {
            log.error("密钥key为空");
            return null;
        } else {
            return Lang.md5(buildParmas(obj, new String[]{"sign"}) + key);
        }
    }
}
