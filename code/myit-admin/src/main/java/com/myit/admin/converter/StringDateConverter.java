package com.myit.admin.converter;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDateConverter extends DateConverterBase implements Converter<String, Date>{

	public Date convert(String source) {
		if (source == null) return null;
		String trim = source.trim();
		if ( trim.length() == 0) return null;
		try {
			return source.contains(":") ? getDateTimeFormat().parse(trim) : getDateFormat().parse(trim);
		} catch (ParseException e) {
		}
		
		return null;
	}
	
	/**
	 * 获取指定日期的偏移量日期
	 * 
	 * @param date
	 * @param field 对应日期字段,1-year，2-month,5-date,10-hour,12-minute,13-second
	 * @param 偏移量，负数表示向前偏移
	 * 返回值:  类型 <说明> 
	 * @return 返回值
	 * @throw 异常描述
	 * @see Calendar.class
	 */
	public static Date getDateByStep(Date date,int field,int step){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, step);
        return c.getTime();
    }

	
}
