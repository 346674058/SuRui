package com.myit.portal.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myit.intf.bean.admin.LinkMan;
import com.myit.intf.bean.admin.UserEvt;
import com.myit.intf.service.admin.LinkManService;
import com.myit.portal.util.Constant;

/**
 * 用户联系人管理控制类<br>
 * 
 * @author created by LiuCongwen at 2012-4-28
 * @version 1.0.0
 */
@Controller
public class LinkManAction extends BaseAction {

	private Logger logger = Logger.getLogger(this.getClass());

	LinkManService linkManService;

	/**
	 * ajax查询当前用户联系人<br>
	 * 
	 * @author created by LiuCongwen at 2012-6-2
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/linkMan/ajaxSearchLinkMans")
	public String ajaxSearchLinkMans(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("ajaxSearchLinkMans in");

		UserEvt user = (UserEvt) request.getSession().getAttribute(Constant.LOGIN_MEMBER);

		List<LinkMan> linkMans = null;
		try {
			linkMans = linkManService.findLinkMansByUId(user.getId());
		} catch (Exception e) {
			logger.warn("findLinkMansByUId failed", e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("linkMans=" + linkMans);
		}

		Gson gson = new Gson();
		String jsonData=gson.toJson(linkMans);
		
		if (logger.isDebugEnabled()) {
			logger.debug("jsonData=" + jsonData);
		}
		
		model.addAttribute("jsonData", jsonData);
		
		logger.info("ajaxSearchLinkMans out");
		return "common/ajaxResult";
	}

	/**
	 * 查询联系人列表<br>
	 * 
	 * @author created by LiuCongwen at 2012-6-13
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/linkMan/searchLinkMans")
	public String searchLinkMans(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("searchLinkMans in");
		
		UserEvt user = (UserEvt) request.getSession().getAttribute(Constant.LOGIN_MEMBER);

		List<LinkMan> linkMans = null;
		try {
			linkMans = linkManService.findLinkMansByUId(user.getId());
		} catch (Exception e) {
			logger.warn("findLinkMansByUId failed", e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("linkMans=" + linkMans);
		}
		
		model.addAttribute("linkMans", linkMans);
		
		logger.info("searchLinkMans out");
		return "custom/linkMan/linkManList";
	}
}
