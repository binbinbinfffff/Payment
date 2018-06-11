package com.cn.teamhelper.utils;

import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class CommonUtil {
	/**
	 *构造返回的json数据模版
	 * 
	 */
	public static JSONObject constructResponse(int code, String msg, Object data) {
		JSONObject jo = new JSONObject();
		jo.put("code", code);
		jo.put("msg", msg);
		jo.put("data", data);
		return jo;
	}

	public static Date getSystemTime() throws ParseException {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();

//		dateFormater.parse(dateFormater.format(Long.parseLong(data.getTalkingStartTime())))
		return  dateFormater.parse(dateFormater.format(date));

	}

	public static String getStrSystemTime()  {
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();

//		dateFormater.parse(dateFormater.format(Long.parseLong(data.getTalkingStartTime())))
		return   dateFormater.format(date);

	}

	public static String GUID() {
		String a = null;

		// 产生 5 个 GUID
		for (int i = 0; i < 5; i++) {
			// 创建 GUID 对象
			UUID uuid = UUID.randomUUID();
			// 得到对象产生的ID
			a = uuid.toString();
			// 转换为大写
			a = a.toUpperCase();
			// 替换 -
			a = a.replaceAll("-", "_");
			// System.out.println(a);
		}
		System.out.println(a + "a");
		return a;
	}

	public static boolean isEmpty(String string){
		if (string==null&&"".equals(string)){
			return true;
		}
		return false;
	}
}
