package com.moviemarket.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author:NewHongjay
 * @data:2018/4/19 12:26
 */
public class JsonUtil {

        /**
         * 		构造返回json
         */
        public static JSONObject constructResponse(int code, String msg, Object data) {
            JSONObject jo = new JSONObject();
            jo.put("code", code);
            jo.put("msg", msg);
            jo.put("data", data);
            return jo;
        }
}
