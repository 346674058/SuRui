package com.myit.admin.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	/**
	 * 登录用户session标识符
	 */
	public static final String LOGINUSER="loginUser";
	
	/**
	 * 分隔符
	 */
	public static final String SPLITCHAR="`";
	
	/**
	 * 订单状态
	 */
	public static final Map<String, String> orderStatus;
	
	/**
	 * 性别
	 */
	public static final Map<String, String> sex;
	
	static {
		orderStatus=new HashMap<String, String>();
		
		orderStatus.put("0", "保存");
		orderStatus.put("1","提交");
		orderStatus.put("2","审批");
		orderStatus.put("3","受理");
		orderStatus.put("4","发运");
		orderStatus.put("5","验收");
		orderStatus.put("6","结算");
		
		sex=new HashMap<String, String>();
		
		sex.put("M", "男");
		sex.put("F","女");
	}

}
