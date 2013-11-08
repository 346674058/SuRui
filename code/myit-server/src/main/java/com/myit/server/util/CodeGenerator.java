package com.myit.server.util;

import java.util.Date;

import org.apache.log4j.Logger;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;

public class CodeGenerator {

	private Logger logger = Logger.getLogger(this.getClass());

	private int curValue;
	private Date dateTime;
	private String pattern;

	public CodeGenerator() {
		dateTime = new Date();
		curValue = 1;
		this.pattern = "T@DATE{yyyyMM}@FLOW{6}";
	}

	public CodeGenerator(int curValue, String pattern) {
		this.curValue = curValue+1;
		dateTime = new Date();
		this.pattern = pattern;
	}

	public int getCurValue() {
		return curValue;
	}

	public void setCurValue(int curValue) {
		this.curValue = curValue+1;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * 按'pattern'格式生成新编码<br>
	 * 
	 * @author created by LiuCongwen at 2012-5-4
	 * @return
	 */
	public String generator() {
		logger.info("generator in");

		// 解析日期
		int start = pattern.indexOf("@DATE{");
		int end = pattern.indexOf("}", start);

		DateConvert convert = new DateConvert();
		convert.setPattern(pattern.substring(start + 6, end));

		// 解析流水号
		int start2 = pattern.indexOf("@FLOW{");
		int end2 = pattern.indexOf("}", start2);

		StringConvert convert2 = new StringConvert();
		int length = Integer.parseInt(pattern.substring(start2 + 6, end2));
		convert2.setLength(length);

		String retStr = pattern
				.replace("@DATE{" + convert.getPattern() + "}", convert.convert(dateTime))
				.replace( "@FLOW{" + pattern.substring(start2 + 6, end2) + "}", convert2.convert(curValue));

		if (logger.isDebugEnabled()) {
			logger.debug("retStr=" + retStr);
		}

		logger.info("generator out");
		return retStr;
	}

	public static void main(String args[]) {
		// 测试代码生成器
		int curValue = 100;
		String pattern = "O@DATE{yyyyMM}@FLOW{6}";
		CodeGenerator codeGenerator = new CodeGenerator(curValue, pattern);
		System.out.println(codeGenerator.generator());
	}
}
