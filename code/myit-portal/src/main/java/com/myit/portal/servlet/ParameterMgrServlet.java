package com.myit.portal.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ParameterMgrServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 获取验证码
	 * 
	 * @author LiuCongwen
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		logger.info("showMemParam in");

		String param = request.getParameter("param");

		if (logger.isDebugEnabled()) {
			logger.debug("param=" + param);
		}

		try {
			response.sendRedirect(request.getContextPath()
					+ "/page/common/ajaxResult.jsp");
		} catch (IOException e) {
			logger.warn("IOException occured", e);
		}
	}
}
