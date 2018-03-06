package com.OrderPay.model;

import com.alipay.aliPayConfig;

public class aliPayPay {
    //公共请求参数
    private static final String app_id = aliPayConfig.app_id;

    private static final String method = "alipay.trade.page.pay";

    private static final String format = aliPayConfig.FORMAT;

    private static final String charset = aliPayConfig.charset;

    private static final String version = "1.0";

    private static final String sing_type = aliPayConfig.sign_type;

    private static final String product_code = "FAST_INSTANT_TRADE_PAY";

    private String sing;                          //商户请求参数签名串

    private String timestamp;                     //发送请求的时间

    private String return_url;                    //同步返回地址，HTTP/HTTPS开头字符串

    private String notify_url;                    //异步返回地址，HTTP/HTTPS开头字符串

    private String biz_content;                   //业务请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递

    //请求参数
    private String out_trade_no;                  //商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复

    private Integer total_amount;                 //订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
                                                  //如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】

    private Integer discountable_amount;          //可打折金额.参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]  (可选)
                                                  // 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】

    private String seller_id;                     //卖家支付宝用户ID。如果该值为空，则默认为商户签约账号对应的支付宝用户ID (可选)

    private String subject;                       //订单标题

    private String body;                          //对交易或商品的描述 (可选)

    private String goods_detail;                  //订单包含的商品列表信息.Json格式. (可选)

    private String buyer_id;                      //买家的支付宝唯一用户号，2088开头的16位纯数字）,和buyer_logon_id不能同时为空

    private String passback_params;               //公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。 (可选)
                                                  // 支付宝只会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝

    private String goods_style;                   //商品主类型   0:虚拟累商品 (可选)
                                                  //            1：实物类商品

    private String timeout_express;               //该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天 (可选)
                                                  // （1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点，
                                                  //如 1.5h，可转换为 90m。该参数在请求到支付宝时开始计时。

    private String enable_pay_channels;

    private String disable_pay_channls;

    private String auth_token;                     //获取用户授权信息，可实现如免登功能。

                                                    //qr_pay_mode 规则详解
    private String qr_pay_mode;                     //0：订单码-简约前置模式，对应iframe宽度不能小于600px，高度不能小于300px；
                                                    //1：订单码-前置模式，对应iframe宽度不能小于300px，高度不能小于600px；
    private String qrcode_width;                    //2：订单码-跳转模式
                                                    //3：订单码-迷你前置模式，对应iframe宽度不能小于75px，高度不能小于75px；
                                                    //4：订单码-可定义宽度的嵌入式二维码，商户可根据需要设定二维码的大小。
                                                    //跳转模式下，用户的扫码界面是由支付宝生成的，不在商户的域名下。


    // extend_params 业务拓展参数说
    private String extend_params;

    private String sys_service_provider_id;

    private String hb_fq_num;

    private String hb_fq_seller_percent;


    public Integer getTotal_amount() {
        return total_amount;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public String getBiz_content() {
        return biz_content;
    }

    public String getBody() {
        return body;
    }

    public String getDisable_pay_channls() {
        return disable_pay_channls;
    }

    public String getEnable_pay_channels() {
        return enable_pay_channels;
    }

    public String getExtend_params() {
        return extend_params;
    }

    public String getGoods_detail() {
        return goods_detail;
    }

    public String getGoods_style() {
        return goods_style;
    }

    public String getHb_fq_num() {
        return hb_fq_num;
    }

    public String getHb_fq_seller_percent() {
        return hb_fq_seller_percent;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public String getPassback_params() {
        return passback_params;
    }

    public static String getProduct_code() {
        return product_code;
    }

    public String getQr_pay_mode() {
        return qr_pay_mode;
    }

    public String getQrcode_width() {
        return qrcode_width;
    }

    public String getReturn_url() {
        return return_url;
    }

    public String getSing() {
        return sing;
    }

    public String getSubject() {
        return subject;
    }

    public String getSys_service_provider_id() {
        return sys_service_provider_id;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public void setBiz_content(String biz_content) {
        this.biz_content = biz_content;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDisable_pay_channls(String disable_pay_channls) {
        this.disable_pay_channls = disable_pay_channls;
    }

    public void setEnable_pay_channels(String enable_pay_channels) {
        this.enable_pay_channels = enable_pay_channels;
    }

    public void setExtend_params(String extend_params) {
        this.extend_params = extend_params;
    }

    public void setGoods_detail(String goods_detail) {
        this.goods_detail = goods_detail;
    }

    public void setGoods_style(String goods_style) {
        this.goods_style = goods_style;
    }

    public void setHb_fq_num(String hb_fq_num) {
        this.hb_fq_num = hb_fq_num;
    }

    public void setHb_fq_seller_percent(String hb_fq_seller_percent) {
        this.hb_fq_seller_percent = hb_fq_seller_percent;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setPassback_params(String passback_params) {
        this.passback_params = passback_params;
    }

    public void setQr_pay_mode(String qr_pay_mode) {
        this.qr_pay_mode = qr_pay_mode;
    }

    public void setQrcode_width(String qrcode_width) {
        this.qrcode_width = qrcode_width;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public void setSing(String sing) {
        this.sing = sing;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setSys_service_provider_id(String sys_service_provider_id) {
        this.sys_service_provider_id = sys_service_provider_id;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setTotal_amount(Integer total_amount) {
        this.total_amount = total_amount;
    }

    public Integer getDiscountable_amount() {
        return discountable_amount;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public void setDiscountable_amount(Integer discountable_amount) {
        this.discountable_amount = discountable_amount;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }
}

