package com.Util;

import com.OrderPay.model.aliPayPay;
import com.OrderPay.model.aliPayClose;
import com.OrderPay.model.aliPayCreatePay;
import com.OrderPay.model.aliPayQuery;
import com.OrderPay.model.aliPayRefundQuery;
import com.OrderPay.model.aliPayRefund;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * 常用工具类
 * made by binbinbinfffff
 */
public class CommonUtil {
    /**
     * 构造接口返回值
     *
     * @param code    错误代码
     * @param message 错误信息
     * @param data    返回值
     * @return
     */
    private aliPayPay aliPayPay;

    private aliPayClose aliPayClose;

    private aliPayRefund aliPayRefund;

    private aliPayRefundQuery aliPayRefundQuery;

    private aliPayQuery aliPayQuery;

    private aliPayCreatePay aliPayCreatePay;

    public static JSONObject constructResponse(int code, String message, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("msg", message);
        jsonObject.put("data", data);
        return jsonObject;
    }

    public static String transStringToJsonString(String string) {
        return "\"" + string + "\"";
    }
    public static Integer transStringToJsonInteger(String string){
        return Integer.parseInt("\"" +string+ "\"");
    }
}
