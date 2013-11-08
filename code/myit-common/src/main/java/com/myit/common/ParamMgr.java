package com.myit.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统配置类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 * @see sysCfg.properties
 */
public class ParamMgr {
	
	private static Map<String, Object> param_MAP=new HashMap<String, Object>();
	
	/**
	 * 获取参数配置<br>
	 * @author created by LiuCongwen at 2012-4-24
	 * @param paramName
	 * @return
	 */
	public static Object get(String paramName) {
		return param_MAP.get(paramName);
	}
	
	/**
	 * 设置参数配置<br>
	 * @author created by LiuCongwen at 2012-4-24
	 * @param paramName
	 * @return
	 */
	public static void put(String paramType,Object params) {
		param_MAP.put(paramType,params);
	}

	/**
	 * 主函数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param args
	 */
	public static void main(String[] args) {
		// 测试系统配置加载

	}

}
