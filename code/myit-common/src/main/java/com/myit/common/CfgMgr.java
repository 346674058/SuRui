package com.myit.common;

import java.util.Iterator;
import java.util.Properties;

/**
 * 管理所有配置项<br>
 * 
 * @author created by LiuCongwen at 2012-5-4
 * @version 1.0.0
 */
public class CfgMgr {

	public static Properties sysCfg = new Properties();

	public static String get(String key) {
		String[] paramNames=key.split("#");
		StringBuffer paramValue=new StringBuffer();
		
		for(String paramName_i: paramNames){
			paramValue.append(sysCfg.get(paramName_i));
		}
		
		return paramValue.toString();
	}

	public static void put(Object key, Object value) {
		sysCfg.put(key, value);
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer=new StringBuffer();
		
		Iterator<Object> iterator=sysCfg.keySet().iterator();
		while (iterator.hasNext()) {
			String key=iterator.next().toString();
			String value=sysCfg.get(key).toString();
			stringBuffer.append(", {key: '"+key+"', value: '"+value+"'}");
		}
		String retStr=stringBuffer.toString();
		if(retStr.length()>0){
			retStr=retStr.substring(1);
		}
			
		return retStr;
	}
}
