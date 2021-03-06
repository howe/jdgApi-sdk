package com.jiedangou.api.sdk.util.api;

import com.jiedangou.api.sdk.bean.dict.Dict;
import com.jiedangou.api.sdk.bean.param.biz.Game;
import com.jiedangou.api.sdk.bean.param.req.BaseReq;
import com.jiedangou.api.sdk.bean.param.req.biz.QueryGame;
import com.jiedangou.api.sdk.bean.param.resp.BaseResp;
import com.jiedangou.api.sdk.util.HttpUtil;
import com.jiedangou.api.sdk.util.JdgUtil;
import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.lang.Times;

import java.util.List;

/**
 * Created on 2017/11/25
 *
 * @author Jianghao(howechiang @ gmail.com)
 */
public class GameUtil {

    /**
     * 4.1 获取游戏列表
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @return
     */
    public static List<Game> queryGameList(Integer partnerId, String key) {

        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("合作商ID为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else {
                BaseReq req = new BaseReq();
                req.setPartnerId(partnerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMELIST, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    throw new Exception("返回值异常");
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    List<Game> games = resp.getData().getAsList("games", Game.class);
                    return games;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 4.2 获取游戏区服详情
     *
     * @param partnerId 合作商ID
     * @param key       密钥key
     * @return
     */
    public static Game queryGame(Integer partnerId, String key, QueryGame biz) {

        try {
            if (Lang.isEmpty(partnerId)) {
                throw new Exception("合作商ID为空");
            } else if (Strings.isBlank(key)) {
                throw new Exception("key为空");
            } else if (Lang.isEmpty(biz.getGameId())) {
                throw new Exception("gameId为空");
            } else {
                BaseReq req = new BaseReq();
                req.setPartnerId(partnerId);
                req.setTimestamp(Times.getTS());
                req.setVersion(Dict.JDG_API_VERSION);
                req.setBizData(Lang.obj2nutmap(biz));
                req.setSign(JdgUtil.getSign(Lang.obj2nutmap(req), key));
                String json = HttpUtil.post(Dict.JDG_DEV_API_HOST + Dict.JDG_API_ACTION_GAME_QUERYGAMEDETAIL, Json.toJson(req));
                if (Strings.isEmpty(json)) {
                    throw new Exception("返回值异常");
                } else {
                    BaseResp resp = Json.fromJson(BaseResp.class, json);
                    Game game = resp.getData().getAs("game", Game.class);
                    return game;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
