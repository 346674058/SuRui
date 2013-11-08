package com.myit.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myit.admin.bean.User;
import com.myit.admin.util.Constant;

@Controller
public class MessageAction {

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * ajax查询当前用户的通知信息<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/message/myNewMessages")
	public String myNewMessages(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("myNewMessages in");
		
		Gson gson=new Gson();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", false);
		
		User user=(User)request.getSession().getAttribute(Constant.LOGINUSER);
		
		if (logger.isDebugEnabled()) {
			logger.debug("user="+user);
		}
		
		List<Object> newMessages=new ArrayList<Object>();
		for(int i=0;i<5;i++){
			Map<String, Object> newMessage = new HashMap<String, Object>();
			newMessage.put("id", i);
			newMessage.put("title", "新消息"+i);
			newMessage.put("sendTime", "2012-8-16 20:02:1"+i);
			
			newMessages.add(newMessage);
		}
		
		data.put("success", true);
		data.put("newMessages", newMessages);

		String jsonData = gson.toJson(data);

		if (logger.isDebugEnabled()) {
			logger.debug("jsonData=" + jsonData);
		}

		model.addAttribute("jsonData", jsonData);

		logger.info("myNewMessages out");
		return "common/ajaxResult.ftl";
	}
}
