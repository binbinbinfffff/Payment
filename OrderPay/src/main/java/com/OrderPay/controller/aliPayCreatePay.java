package com.OrderPay.controller;

import com.Util.CommonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.aliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  made by binbinbinfffff
 *  订单创建接口
 *   订单需要支付前调用此接口创建支付订单
 */
@Controller
@RequestMapping("/aliPayCreatePay")
public class aliPayCreatePay {
    /**
     *  订单创建
     *  使用POST请求 附带参数data 具体参数参考接口文档
     *  此接口会自动转义为json数据
     * @param Request
     * @param httpServletResponse
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(path = "/createPay",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject createPay(HttpServletRequest Request,
                                HttpServletResponse httpServletResponse)throws ServletException,IOException{
        JSONObject object  = JSONObject.parseObject(Request.getParameter("data"));
        String out_trade_no = CommonUtil.transStringToJsonString(object.getString("out_trade_no"));
        String seller_id = CommonUtil.transStringToJsonString(object.getString("seller_id"));
        String total_amount = CommonUtil.transStringToJsonString(object.getString("total_amount"));
        String discountable_amount = CommonUtil.transStringToJsonString(object.getString("discountable_amount"));
        String subject = CommonUtil.transStringToJsonString(object.getString("subject"));
        String body = CommonUtil.transStringToJsonString(object.getString("body"));
        String buyer_id = CommonUtil.transStringToJsonString(object.getString("buyer_id"));
        String goods_id = CommonUtil.transStringToJsonString(object.getString("goods_id"));
        String goods_name = CommonUtil.transStringToJsonString(object.getString("goods_name"));
        Integer quantity = CommonUtil.transStringToJsonInteger(object.getString("quantity"));
        Integer price = CommonUtil.transStringToJsonInteger(object.getString("price"));
        String goods_category = CommonUtil.transStringToJsonString(object.getString("goods_category"));
        String show_url = CommonUtil.transStringToJsonString(object.getString("show_url"));
        String goods_body = CommonUtil.transStringToJsonString(object.getString("goods_body"));
        String operator_id = CommonUtil.transStringToJsonString(object.getString("operator_id"));
        String store_id = CommonUtil.transStringToJsonString(object.getString("store_id"));
        String terminal_id = CommonUtil.transStringToJsonString(object.getString("terminal_id"));
        String timeout_express = CommonUtil.transStringToJsonString(object.getString("timeout_express"));
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", aliPayConfig.app_id,aliPayConfig.merchant_private_key,
                aliPayConfig.FORMAT,aliPayConfig.charset,aliPayConfig.alipay_public_key,aliPayConfig.sign_type);
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":"+out_trade_no+"," +
                "\"seller_id\":"+seller_id+"," +
                "\"total_amount\":"+total_amount+"," +
                "\"discountable_amount\":"+discountable_amount+"," +
                "\"subject\":"+subject+"," +
                "\"body\":"+body+"," +
                "\"buyer_id\":"+buyer_id+"," +
                "\"goods_detail\":[{" +
                "\"goods_id\":"+goods_id+"," +
                "\"goods_name\":"+goods_name+"," +
                "\"quantity\":"+quantity+"," +
                "\"price\":"+price+"," +
                "\"goods_category\":"+goods_category+"," +
                "\"body\":"+goods_body+"," +
                "\"show_url\":"+show_url+
                "}]," +
                "\"operator_id\":"+operator_id+"," +
                "\"store_id\":"+store_id+"," +
                "\"terminal_id\":"+terminal_id+"," +
                "\"extend_params\":{" +
                "\"sys_service_provider_id\":\"2088511833207846\"" +
                "}," +
                "\"timeout_express\":"+timeout_express+"," +
                "\"business_params\":\"{\\\"data\\\":\\\"123\\\"}\"" +
                "}");
        AlipayTradeCreateResponse response = null;
        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            return CommonUtil.constructResponse(1,"创建支付订单成功",null);
        } else {
            return CommonUtil.constructResponse(0,"创建支付订单失败",null);
        }

    }
}
