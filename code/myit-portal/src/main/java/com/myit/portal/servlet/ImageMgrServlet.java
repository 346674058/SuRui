package com.myit.portal.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ImageMgrServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 获取验证码
	 * @author LiuCongwen
	 */
	public String getRandCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try {
			logger.info("Method=getRandCode");
			
			request.getRequestDispatcher("common/image.jsp").forward(request, response);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
