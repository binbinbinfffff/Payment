package com.OrderPay.controller;

import com.alipay.aliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class aliPayClose {
    public void close(String tradeNo,String outTradeNo,String operatorId) throws ServletException,IOException{
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.gatewayUrl, aliPayConfig.app_id, aliPayConfig.merchant_private_key,
                "json", aliPayConfig.charset, aliPayConfig.alipay_public_key, aliPayConfig.sign_type);
        //设置请求参数
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent("{" +
                "\"trade_no\":"+tradeNo+"," +
                "\"out_trade_no\":"+outTradeNo+"," +
                "\"operator_id\":"+operatorId +
                "  }");
        AlipayTradeCloseResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
}}
