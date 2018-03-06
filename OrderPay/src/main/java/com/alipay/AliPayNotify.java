package com.alipay;

import com.Util.EnumUtil;
import com.Util.RSA;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class AliPayNotify {
    /**
     * 支付宝消息验证地址
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 验证消息是否是支付宝发出的合法消息
     * @param params 通知返回来的参数数组
     * @return 验证结果
     */
    public static boolean verify(Map<String, String> params, String sigin_type) {

        //判断responsetTxt是否为true，isSign是否为true
        //responsetTxt的结果不是true，与服务器设置问题、合作身份者ID、notify_id一分钟失效有关
        //isSign不是true，与安全校验码、请求时的参数格式（如：带自定义参数等）、编码格式有关
        String responseTxt = "false";
        if(params.get("notify_id") != null) {
            String notify_id = params.get("notify_id");
            responseTxt = verifyResponse(notify_id);
        }
        String sign = "";
        if(params.get("sign") != null) {sign = params.get("sign");}
        // String sigin_type="";
        // if(params.get("sigin_type") != null) {sigin_type = params.get("sigin_type");}

        System.out.println("这个sigin_type＝"+sigin_type);
        boolean isSign=false;
        if("RSA".equals(sigin_type)){
            isSign = getRSASignVeryfy(params, sign, EnumUtil.PUBLIC_KEY);
        }else{
            isSign = getSignVeryfy(params, sign);

        }

        //写日志记录（若要调试，请取消下面两行注释）
        String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 返回回来的参数：" + aliPayCore.createLinkString(params);
//	    AlipayCore.logResult(sWord);
        System.out.println(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
    public static boolean getSignVeryfy(Map<String, String> Params, String sign) {
        Map<String, String> sParaNew = aliPayCore.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = aliPayCore.createLinkString(sParaNew);
        //获得签名验证结果
        boolean isSign = false;
        if(aliPayConfig.sign_type.equals("RSA")){
            isSign = RSA.verify(preSignStr, sign, aliPayConfig.alipay_public_key, aliPayConfig.charset);
        }
        return isSign;
    }

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     *
     * @Title: getRSASignVeryfy
     * @Description: 校验rsa签名
     * @param Params
     * @param sign
     * @param publicKey
     * @return
     * @return: boolean
     */
    public static boolean getRSASignVeryfy(Map<String, String> Params, String sign, String publicKey) {
        try {
            System.out.println("进入rsa");
            //过滤空值、sign与sign_type参数
            Map<String, String> sParaNew = aliPayCore.paraFilter(Params);
            //获取待签名字符串
            String content = aliPayCore.createLinkString(sParaNew);

            System.out.println("签名字符串："+content);
            System.out.println("sigin:"+sign);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory
                    .generatePublic(new X509EncodedKeySpec(encodedKey));

            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes("utf-8"));

            boolean bverify = signature.verify(Base64.decode(sign));
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 获取远程服务器ATN结果,验证返回URL
     * @param notify_id 通知校验ID
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    public static String verifyResponse(String notify_id) {
        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求

        String partner = aliPayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }

    /**
     * 获取远程服务器ATN结果
     * @param urlvalue 指定URL路径地址
     * @return 服务器ATN结果
     * 验证结果集：
     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空
     * true 返回正确信息
     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
     */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                    .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
}
