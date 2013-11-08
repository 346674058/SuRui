/**
 * 
 */
package com.myit.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.myit.common.CfgMgr;

/**
 * 字符串格式转换类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class StringConvert {

    private static final Logger LOGGER = Logger.getLogger(StringConvert.class);

    private int length;

    public StringConvert() {
        if (StringConvert.isEmpty(CfgMgr.get("format.lenght"))) {
            this.length = 0;
        } else {
            this.length = Integer.parseInt(CfgMgr.get("format.lenght"));
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("StringConvert init, length=" + this.length);
        }
    }

    /**
     * 将数字转换成对应长度的字符串，长度不足数字前面补0，长度溢出，数字截取后几位<br>
     * 
     * @author created by LiuCongwen at 2012-5-24
     * @param number
     * @return
     */
    public String convert(int number) {
        LOGGER.info("convert in");

        String retStr = "";

        String numberStr = String.valueOf(number);

        if (numberStr.length() == this.length) {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("numberStr=" + numberStr);
            }

            return numberStr;
        }

        // 数字长度溢出，截取后N位
        if (numberStr.length() >= this.length) {

            retStr = numberStr.substring(numberStr.length() - length);

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("retStr=" + retStr);
            }

            return retStr;
        }

        for (int i = 0; i < length - numberStr.length(); i++) {
            retStr += "0";
        }
        retStr += numberStr;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("retStr=" + retStr);
        }
        LOGGER.info("convert out");
        return retStr;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /**
     * 检查字符串或者对象是否为空<br>
     * 
     * @author created by LiuCongwen at 2012-5-4
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String && ("".equals(object) || "null".equals(object))) {
            return true;
        }
        return false;
    }

    /**
     * MD5加密
     * 
     * @param str
     * @return
     */
    public static String md5(String str) {

        if (str == null) {
            return null;
        }

        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("md5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            return str;
        } catch (UnsupportedEncodingException e) {
            return str;
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }

        return md5StrBuff.toString();
    }

    /**
     * 
     * 功能描述: <br>
     * 会员密码MD5+key加密
     * 
     * @param password
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String passwordMD5(String password, String key) {
        LOGGER.info("passwordMD5 IN");

        String retString = null;

        try {
            retString = StringConvert.md5(StringConvert.md5(password) + key);
        } catch (Exception e) {
            LOGGER.warn("passwordMD5 failed", e);
        }

        LOGGER.info("passwordMD5 OUT");
        return retString;
    }

    /**
     * 主函数<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param args
     */
    public static void main(String[] args) {
        // 测试字符串转换

        System.out.println(md5("passw0rd") + "," + md5("888888"));// bed128365216c019988915ed3add75fb,21218cca77804d2ba1922c33e0151105

    }

}
