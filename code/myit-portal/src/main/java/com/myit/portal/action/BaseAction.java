package com.myit.portal.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;

/**
 * 基础流程控制类<br>
 * 
 * @author created by LiuCongwen at 2012-4-28
 * @version 1.0.0
 */
public class BaseAction {

	private static final Logger LOGGER = Logger.getLogger(BaseAction.class);

	/**
	 * 获取请求参数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-28
	 * @param param
	 *            参数名
	 * @param request
	 * @return
	 */
	public String getParam(String param, HttpServletRequest request) {
		return request.getParameter(param);
	}
	
	/**
	 * 返回到操作结果页面<br>
	 * @author created by LiuCongwen at 2012-5-30
	 * @param timer
	 * @param info
	 * @param taget
	 * @param tagetName
	 * @param model
	 * @return
	 */
	public String resultPage(String timer,String info,String taget,String tagetName,Model model){
		Map<String, String> result=new HashMap<String, String>();
		
		result.put("timer", timer);
		
		result.put("info", info);
		
		result.put("taget", taget);
		result.put("pageName", tagetName);
		
		model.addAttribute("result", result);
		LOGGER.info("saveRegist out");
		return "common/result";
	}
	

	/**
	 * 返回ajax请求结果<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-28
	 * @param message
	 *            ajax请求结果（json）
	 * @param response
	 */
	public void sendAjaxResponse(String message, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(message);
		} catch (IOException e) {
		    LOGGER.warn("sendResponse failed", e);
		}
	}
}
