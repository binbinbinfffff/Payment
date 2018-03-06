package com.OrderPay.controller;

import com.Util.CommonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/aliPayQuery")
public class aliPayQuery {
    @RequestMapping(path = "/query", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject Query(HttpServletRequest httpRequest) {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "app_id", "your private_key", "json", "GBK", "alipay_public_key", "RSA");
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        JSONObject object = JSON.parseObject(httpRequest.getParameter("data"));
        String trade_no = CommonUtil.transStringToJsonString(object.getString("trade_no"));
        String out_trade_no = CommonUtil.transStringToJsonString(object.getString("out_trade_no"));
        String operator_id = CommonUtil.transStringToJsonString(object.getString("operator_id"));
        request.setBizContent("{" +
                "\"trade_no\":" + trade_no + "," +
                "\"out_trade_no\":" + out_trade_no + "," +
                "\"operator_id\":" + operator_id +
                "  }");
        AlipayTradeCloseResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response.isSuccess()) {
            return CommonUtil.constructResponse(1, "查询成功", null);
        }
        return CommonUtil.constructResponse(-1, "查询失败", null);
    }
}

