package com.myit.admin.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.myit.common.CfgMgr;

public class SystemMgrServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        logger.info("init in.");

        logger.info("load the properties.");

        String[] configs = { "conf/setting-web.properties" };

        // 加载propertiesFactoryBean
        try {
            for (int i = 0; i < configs.length; i++) {
                InputStream input = getClass().getClassLoader().getResourceAsStream(configs[i]);

                if (input == null) {
                    throw new IOException("conf/setting-web.properties not exist");
                }
                CfgMgr.sysCfg.load(input);
            }
        } catch (Exception e) {
            logger.error("load properties failed", e);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("CfgMgr.sysCfg=" + CfgMgr.sysCfg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("doGet in");

        String command = getParam("command", request);
        response.setCharacterEncoding("UTF-8");

        if ("showSysCfg".equals(command)) {// 显示系统配置
            Gson gson = new Gson();
            String jsonDate = gson.toJson(CfgMgr.sysCfg);

            logger.info("jsonDate=" + jsonDate);

            response.getWriter().write(jsonDate);
        }

        logger.info("doGet out");
    }

    private String getParam(String param, HttpServletRequest request) {
        return request.getParameter(param);
    }

    public static void main(String[] args) {
        SystemMgrServlet systemMgrServlet = new SystemMgrServlet();
        try {
            systemMgrServlet.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.out.println("systemMgrServlet=" + systemMgrServlet);
    }
}
