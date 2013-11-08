package com.myit.admin.action;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础流程控制类<br>
 * 
 * @author created by LiuCongwen at 2012-4-28
 * @version 1.0.0
 */
public class BaseAction {

    /**
     * <b>Function Desc:</b><br>
     * 获取请求参数
     * 
     * @param param
     * @param request
     * @return
     * @see <需要参见的其它内容>
     */
    public String getParam(String param, HttpServletRequest request) {
        return request.getParameter(param);
    }

}
