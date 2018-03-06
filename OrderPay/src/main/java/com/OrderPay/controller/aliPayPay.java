package com.OrderPay.controller;

import com.Util.CommonUtil;
import com.alibaba.fastjson.JSONObject;
import com.alipay.aliPayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.alipay.api.AlipayConstants.CHARSET;

/**
 * 支付接口
 * made by binbinbinfffff
 * 说明： 调用此接口 发送post请求 参数  out_trade_no 订单号
 *                                 amount       订单价格
 *                                 subject      订单标题
 *                                 body         订单描述
 */
@Controller
@RequestMapping("/aliPayPay")
public class aliPayPay {
    @RequestMapping(path = "/pay",method = RequestMethod.POST)
    @ResponseBody
    public void Pay(HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse) throws ServletException, IOException {
        JSONObject object = JSONObject.parseObject("data");
        String out_trade_no = CommonUtil.transStringToJsonString(object.getString("out_data_no"));
        Integer total_amount = CommonUtil.transStringToJsonInteger(object.getString("total_amount"));
        String subject = CommonUtil.transStringToJsonString(object.getString("subject"));
        String body = CommonUtil.transStringToJsonString(object.getString("body"));
        //请求支付宝支付接口
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.gatewayUrl, aliPayConfig.app_id, aliPayConfig.merchant_private_key,
                aliPayConfig.FORMAT, aliPayConfig.charset, aliPayConfig.alipay_public_key, aliPayConfig.sign_type); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://www.binbinbinfffff.win/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://www.binbinbinfffff.win/notify/getAliPayNotify");//在公共参数中设置回跳和通知地址
                        //填充业务参数
        alipayRequest.setBizContent("{" +
                        //订单号
                "    \"out_trade_no\":"+out_trade_no+"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                        //订单价格
                "    \"total_amount\":"+total_amount+"," +
                        //订单标题
                "    \"subject\":"+subject+"," +
                        //订单描述
                "    \"body\":"+body+"," +
                        //公共回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                        //业务扩展参数 说明见https://docs.open.alipay.com/270/alipay.trade.page.pay
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
