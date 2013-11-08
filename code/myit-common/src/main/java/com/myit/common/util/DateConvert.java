/**
 * 
 */
package com.myit.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.myit.common.CfgMgr;

/**
 * 日期格式转换类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class DateConvert {

    private Logger logger = Logger.getLogger(this.getClass());

    private final String format_date = "format.date";

    private String pattern;

    /**
     * spring date格式转换格式
     */
    private String format;

    public DateConvert() {
        this.pattern = CfgMgr.get(format_date);

        if (logger.isDebugEnabled()) {
            logger.debug("DateConvert init, pattern=" + this.pattern);
        }
    }

    /**
     * 转换成字符串<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param date
     * @return
     */
    public String convert(Date date) {
        logger.info("convert in.");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);
        String retDate = simpleDateFormat.format(date);

        if (logger.isDebugEnabled()) {
            logger.debug("retDate=" + retDate);
        }

        logger.info("convert out.");
        return retDate;
    }

    /**
     * 转换成日期<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param date
     * @return
     */
    public Date convert(String date) {
        logger.info("convert in.");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);

        Date retDate = null;
        try {
            retDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.warn("ParseException occured", e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("retDate=" + retDate);
        }

        logger.info("convert out.");
        return retDate;
    }

    /**
     * 获取指定日期的偏移量日期<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param date
     * @param field 对应日期字段,1-year，2-month,5-date,10-hour,12-minute,13-second
     * @param step 偏移量，负数表示向前偏移
     * @return
     * @see Calendar.class
     */
    public Date getDateByStep(Date date, int field, int step) {
        logger.info("getDateByStep in.");

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(field, step);

        Date retDate = c.getTime();

        if (logger.isDebugEnabled()) {
            logger.debug("retDate=" + retDate);
        }

        logger.info("getDateByStep out.");
        return retDate;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 主函数<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param args
     */
    public static void main(String[] args) {
        // 测试日期转换

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2012-05-16 25:00:12");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(date);
    }

}
