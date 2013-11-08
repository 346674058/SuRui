package com.myit.portal.converter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
public class DecimalStringConverter implements Converter<BigDecimal, String>{

	/**
	 * 需转换的格式
	 */
    private String pattern="###.000";
    
    public String convert(BigDecimal data) {
        if(data==null){
            return "";
        }
        
        DecimalFormat format=new DecimalFormat(pattern);
        return format.format(data);
    }
    
    /**
     * 
     * 功能描述: <br>
     *  格式化值
     *
     * @param data
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public BigDecimal convert2BigDecimal(BigDecimal data) {
        if(data==null){
            return null ;
        }
        
        DecimalFormat format=new DecimalFormat(pattern);
        return new BigDecimal(format.format(data));
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
