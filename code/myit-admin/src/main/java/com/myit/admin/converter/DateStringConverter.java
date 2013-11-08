package com.myit.admin.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author SuQiong
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateStringConverter extends DateConverterBase implements Converter<Date, String> {

    /**
     * 转换格式
     */
    private String pattern = "yyyy-MM-dd";

    public String convert(Date source) {
        if (source == null)
            return "";
        return getDateFormat().format(source);
    }

    /**
     * 
     * 功能描述: <br>
     * 将时间类型转成string类型
     * 
     * @param date
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String format(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 
     * 功能描述: <br>
     * 是否时间格式
     * 
     * @param sDate
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public boolean isValidDate(String sDate) {
        try {
            getDateFormat().parse(sDate);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
