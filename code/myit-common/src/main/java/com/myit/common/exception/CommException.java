/*
 * Copyright (C), 2002-2013, 苏宁易购电子商务有限公司
 * FileName: Exception.java
 * Author:   LiuCongwen
 * Date:     2013-2-5 上午10:45:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.myit.common.exception;

import java.util.List;

/**
 * 系统异常类<br> 
 * 描述系统异常信息
 *
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommException {
    private static final String CODE_UNKOWN="000000000";
    private static final String CODE_FILE_NOTFOUND="000000001";
    
    private static final String CODE_NULL_POINTER="999999998";
    private static final String CODE_SYSTEM_ERROR="999999999";
    
    
    private String code;    //异常代码
    private String message;     //异常描述
    
    private List<String> resolves;     //解决方案列表
    
    public CommException(){
        
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getResolves() {
        return resolves;
    }

    public void setResolves(List<String> resolves) {
        this.resolves = resolves;
    }
}
