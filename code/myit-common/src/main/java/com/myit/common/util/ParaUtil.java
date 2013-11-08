package com.myit.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParaUtil {
	public static String getPara(String key) {
		try {
			Properties pro = new Properties();
			InputStream input = ParaUtil.class.getClassLoader()
					.getResourceAsStream("conf/sysCfg.properties");
			pro.load(input);
			return ((String) pro.get(key)).trim();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
