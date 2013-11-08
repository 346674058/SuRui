package com.myit.portal.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.myit.common.util.StringConvert;
import com.myit.intf.bean.admin.UserEvt;
import com.myit.portal.util.Constant;

/**
 * 
 * 用户操作权限过滤器<br>
 * 过滤用户操作，如系统白名单、登录用户鉴权等
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AuthFilter implements Filter {
    public FilterConfig filterConfig = null;

    private final static Logger LOGGER = Logger.getLogger(AuthFilter.class);

    private final static String LOGIN_URL = "/member/login.htm";

    // 白名单列表
    private List<String> whiteList;

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException,
            ServletException {
        LOGGER.info("doFilter in.");

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;

        try {
            // 设置请求参数
            // setParameters(WebUtils.getParametersStartingWith(request, ""));
            // 获取根目录所对应的绝对路径:
            String currentURI = request.getRequestURI();
            LOGGER.debug("currentURI: " + currentURI + ",contextPath:" + request.getContextPath());

            // 截取命名空间、action、路径参数
            String targerURI = "";
            if ("".equals(request.getContextPath())) {
                targerURI = currentURI.substring(currentURI.indexOf("/", 0), currentURI.length());
            } else {
                targerURI = currentURI.substring(currentURI.indexOf("/", 1), currentURI.length());
            }
            LOGGER.debug("targerURI: " + targerURI);

            if ("/".equals(targerURI) || (!targerURI.endsWith(".htm"))) {
                filterChain.doFilter(request, response);

                LOGGER.info("doFilter out.");
                return;
            }

            // 如果属于白名单，直接返回
            if (checkWhiteList(targerURI)) {
                filterChain.doFilter(request, response);

                LOGGER.info("doFilter out.");
                return;
            }

            HttpSession session = request.getSession(true);
            UserEvt user = (UserEvt) session.getAttribute(Constant.LOGIN_MEMBER);

            // 用户为空或者用户id为空，表示用户未登录或登录超时
            if (StringConvert.isEmpty(user) || StringConvert.isEmpty(user.getId())) {
                LOGGER.warn("login user is empty.");

                response.sendRedirect(request.getContextPath() + LOGIN_URL + "?_CALLBACK=" + targerURI);

                LOGGER.info("doFilter out.");
                return;
            }

            LOGGER.debug("user=" + user.getUserName() + ",targerURI:" + targerURI);

            // 判断操作权限是否合法
            if (!checkPermission(user, targerURI)) {
                LOGGER.error("has no permisssion,user:" + user.getUserName());

                response.sendRedirect(request.getContextPath() + LOGIN_URL);

                LOGGER.info("doFilter out.");
                return;
            }
        } catch (Exception e) {
            LOGGER.error("doFilter failed", e);
        }

        LOGGER.info("doFilter out.");
        filterChain.doFilter(arg0, arg1);
    }

    /**
     * 
     * 功能描述: <br>
     * 检查用户权限
     * 
     * @param user
     * @param action
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private boolean checkPermission(UserEvt user, String targerURI) {
        LOGGER.info("checkPermission in.");

        // TODO 通过用户角色-菜单关联表判断用户对菜单的操作权限

        LOGGER.info("checkPermission out.");
        return true;
    }

    /**
     * 
     * 功能描述: <br>
     * 验证系统白名单
     * 
     * @param targerURI
     * @return false：非例外，true：例外
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private boolean checkWhiteList(String targerURI) {
        LOGGER.info("checkWhiteList in.");

        LOGGER.debug("targerURI:" + targerURI);

        if (null == whiteList || whiteList.size() == 0) {
            LOGGER.warn("whiteList is null.");

            LOGGER.info("checkWhiteList out.");
            return false;
        } else {
            for (int i = 0; i < whiteList.size(); i++) {
                if (targerURI.startsWith(whiteList.get(i))) {
                    LOGGER.debug("targerURI in whiteList.");

                    LOGGER.info("checkWhiteList out.");
                    return true;
                }
            }
        }

        LOGGER.info("checkWhiteList out.");
        return false;
    }

    /**
     * 功能描述: <br>
     * 获取系统请求白名单
     * 
     * @param servletContext
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<String> getWhiteList(ServletContext servletContext) {
        List<String> blank = new ArrayList<String>();
        try {
            String whiteListSrc = filterConfig.getInitParameter("whiteList");

            ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            InputStream is = ctx.getResource(whiteListSrc).getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                blank.add(line);
            }
            if (null != br) {
                br.close();
            }
        } catch (IOException e) {
            LOGGER.error("getWhiteList failed", e);
        }
        return blank;
    }

    public void init(FilterConfig config) throws ServletException {
        LOGGER.info("init in.");

        this.filterConfig = config;

        // 加载系统请求白名单
        if (whiteList == null) {
            whiteList = getWhiteList(config.getServletContext());
        }

        LOGGER.debug("filterConfig:" + filterConfig);

        LOGGER.info("init out.");
    }

    public void destroy() {
        LOGGER.info("destroy in.");

        filterConfig = null;
        whiteList = null;

        LOGGER.info("destroy out.");
    }
}
