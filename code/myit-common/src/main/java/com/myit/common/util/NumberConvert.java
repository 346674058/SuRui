/**
 * 
 */
package com.myit.common.util;

import org.apache.log4j.Logger;

/**
 * 数值操作工具类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class NumberConvert {

    private static final Logger LOGGER = Logger.getLogger(NumberConvert.class);

    /**
     * 
     * 功能描述: <br>
     * 获取范围内的随机整数
     * 
     * @param min
     * @param max
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * max) + min;
    }

    /**
     * 主函数<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getRandomNumber(1, 10));
    }

}
