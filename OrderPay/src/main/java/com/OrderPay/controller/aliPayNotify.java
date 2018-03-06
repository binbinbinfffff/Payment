package com.OrderPay.controller;

import com.Util.CommonUtil;
import com.alibaba.fastjson.JSONObject;
import com.alipay.AliPayNotify;
import com.alipay.aliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.qiniu.util.Json;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/notify")
public class aliPayNotify {

    @RequestMapping(path = "/getAliPayNotify", method = RequestMethod.POST)
    @ResponseBody()
    public JSONObject getAliPayNotify(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Map allParams = request.getParameterMap();
        String out_trade_no = null;
        String trade_no = null;
        String trade_status = null;
        //迭代器遍历所有参数的key值
        for (Iterator iterator = allParams.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            String[] values = (String[]) allParams.get(key);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                return CommonUtil.constructResponse(-1,"参数value值转码失败",null);
            }
            params.put(key, valueStr);
        }
        //商户订单号
        try {
            out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return CommonUtil.constructResponse(-1, "获取商户订单号错误", null);
        }
        //支付宝交易号
        try {
            trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return CommonUtil.constructResponse(-1, "获取支付宝交易号错误", null);
        }
        //交易状态
        try {
            trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return CommonUtil.constructResponse(-1, "获取交易状态错误", null);
        }

        //异步通知ID
        String notify_id = request.getParameter("notify_id");

        //sign
        String sign = request.getParameter("sign");
        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, aliPayConfig.alipay_public_key, aliPayConfig.charset, aliPayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (signVerified) {
            if (trade_status.equals("TRADE_FINISHED")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
            if (trade_status.equals("TRADE_SUCCESS")) {
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
        }else {
            return CommonUtil.constructResponse(-1,"验证签名失败",null);
        }
        return CommonUtil.constructResponse(1,"验证签名成功",null);
    }
}

