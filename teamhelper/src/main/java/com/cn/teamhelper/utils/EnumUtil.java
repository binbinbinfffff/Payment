package com.cn.teamhelper.utils;

public class EnumUtil {
	public enum OrderStatus{

	}
	/**
	 * 请求成功
	 */
	public static final int OK = 1;
	/**
	 * 参数错误
	 */
	public static final int ARG_ERROR = 0;
	/**
	 * 数据库错误
	 */
	public static final int DB_ERROR = -5;
	/**
	 * 未登录
	 */
	public static final int NOT_LOGIN = -1;

	/**
	 * 未知错误
	 */
	public static final int UNKNOW_ERROR = -4;
	/**
	 * 属性为空
	 */
	public static final int CANNOT_NULL = -2;
	/**
	 * 权限过低
	 */
	public static final int NOT_ADMIN = -3;
}
