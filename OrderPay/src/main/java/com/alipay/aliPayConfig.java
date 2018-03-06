package com.alipay;

import java.io.FileWriter;
import java.io.IOException;

public class aliPayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091100486034";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC5teC4yv9J1ateeivmjU9OQ2AfQIDNbS3SBH6PfY69dJ0yKxNg3jtYIkyR1FZIUs8JfTQGJ3hF9v17uH+XcrKwamRTcI8pFlSrqaaC6AQlsYFK22J71DXAWR4xkjx1G1AfArKbcHSCHRQWNIsm28/beWkL0ZBeQDjP3pWOIk+RguqwLt8o4fmoGxqffka6q4hMNvJlxqXZCMi0ZbQ8zFuALg+R+FGHY9SqLPhC3e8QRLAger+s9lJ00DpRWuWCiDYmG7CxKncdiexBEdFaDYhCJvOcEbVS8fKM1K1SgzUQ1iV51anyvA4YyqOE9gP+PYmzmVemIpiTRhf0z+IL21yXAgMBAAECggEASvZFjZIzVkRvdiVujxO/TWIY7MSGuWU2t62kwJr4ATWPNm741YMfBUZjDgJeCbeTZsspMsq/284FJ+mjZyifRGLNuHiY8QbYiqpiUjkBY42xGNxRdpaEU+4lJ/FVghfSUZIvMltETDkcoJH5EWhtELSDWIfw9HqL9Cxuxf7Hi35SsFBihCpMnZvFDP7pzmNn0cbsNxtQpwabidSyFIFwitlLKEAXpTt1yKuRbT/uHipSpIccG+RgXfGSnmIrH6E87JUQMq9x7CqLOmRojHPewCiEJVUoILfP6ROh4+6jiXSyPgs61jzIrd/uAKzzL4mPvN19g2Br1YnSVV4mJWE9cQKBgQDkkrAm2PgA3+85t0Zquw5wHRbVrGDoKiiHl9iLiVQg7fDVbsLAQXrWT17npXn81ig/zS9jNpaWLHa2/9GkcpYl/cnrWvKvqP2+n4MLsKehoVTDy4WJXxaBpC55HSbML7fl7j96DszRMI4Xur0lMa4F/jTf0SSZdnHFC727EltxxQKBgQDP/ol5E4BKHBuEim1ntHfktZyUggxsRoFQ16XMRbww7hPAK7uAJqlYvP7vBu+YDdzfCxrkSBLbhHcA6Mhkj2P1RqrLFmQEbNwAXx4j2dt3iLF5mEqL2sZH2X/LqRNVMfCONqo11ln34hhksDNgAQXkiMTPdcnr7s7d/6cbqCjGqwKBgGzCn67cbqV76Ii9/HOsriIKtWLWswXFiaN7TT6YCb/heEcWfPSeM6Tl/3KZ+oGkJWK2b2X2A5FRdut8rnRhUbCiIgIrNG8BKjwaCnD1jc4KxhqkLNZAuKTXSoW2qU9fJVHzG6EoiazAPdxsrrOUAAo5+07EZXXgNiJcg9sP0RNBAoGAGoDlxZ7dhxQD0aTOAhv19xfJRwc3TAjD66g/AUOVkmqT67Xm45KJm7whhBXPLAIANg+1MoeYl45Ol7gR6PZ4l0WU9+H3hrTUZ9u2/HyDQb0SWFs2jJGpGHi3lx0JUJ7Xd1ex4sBYoISX9SSat04KES/4XDM3MrAwfgtYoOaRo5cCgYEAhFN7YoZUBN1W8zjCudQVIiAH8FqPdItW3zDMd6haiJJh/iIbDZf19BVH4YVDScSR4tz7cIcNRD8lg1DO5zpK0jWu1HU8JOPG9RGVu9Ylqwrn4GrG+UsaUAmZSVv+LXqx41w1PQRuptssqCkhZ+NmBkImzTDMvoRxYLWrNlSmq7w=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwtTI+UPE9a7KVQdBSZrsuPNBN/k2j8k8kBNFbJBqdgC0u+Wve7wCEYbEcfXn8Ts/f7+2ftRFZrXjgvDam9/iLM6o/Qo2QGOdS42wZ2ydXm1EwfeGN003H5Un7yZXEw+z8VNG+b8rkPuDYCA/rRV16y9gpKvu8bQySkiZjTJ3jYfU4zakww5o1ZLbgTE0K4vmzMsNep2VAiASG+H0VeC4NDjliKzJfmk9+AM75UlhI1OepyOIYF64Na9IDXWIXz6XEZrNoyMqxtcQBEZB2zRYHJyHUSdASj8XiYatw86kB+DKQ8isXFtoAq5rHgI2uMyHQHB//+aFKo/CW4OIFfhPCQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.binbinbinfffff.win/notify/getAliPayNotify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://www.binbinbinfffff.win/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/Users/binbinbinfffff/";

    public static String FORMAT = "json";

    public static String partner = "2088121886888675";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
