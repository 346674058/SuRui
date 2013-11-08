package com.myit.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.myit.admin.bean.User;
import com.myit.admin.util.Constant;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.admin.user.UserLoginReq;
import com.myit.intf.bean.admin.user.UserLoginResp;
import com.myit.intf.service.admin.UserService;

/**
 * 
 * 客户管理控制类<br>
 * 〈功能详细描述〉
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(UserAction.class);

    @Resource
    UserService userService;

    // 成功
    private static final String RETCODE_SUCCESS = "000000000";

    // 用户不存在
    private static final String RETCODE_USER_NOT_EXSIT = "000000001";

    // 密码错误
    private static final String RETCODE_PASSWORD_INCRECT = "000000002";

    // 用户禁用
    private static final String RETCODE_USER_INACTIVE = "000000003";

    /**
     * <b>Function Desc:</b><br>
     * 跳转到登录页面
     * 
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("login IN");

        User user = (User) request.getSession().getAttribute(Constant.LOGINUSER);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("user=" + user);
        }

        // 用户已登录
        if (!StringConvert.isEmpty(user) && !StringConvert.isEmpty(user.getUserName())) {
            LOGGER.info("user has login.");

            model.addAttribute("user", user);

            LOGGER.info("login out");
            return "index.ftl";
        }

        LOGGER.info("login OUT");
        return "admin/user/login.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 用户登录验证
     * 
     * @param user
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
    public String loginValidate(User user, Model model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LOGGER.info("loginValidate IN");

        LOGGER.debug("parameters: userName=" + user.getUserName());

        UserLoginResp loginResp = null;
        Map<String, Object> data = new HashMap<String, Object>();

        try {
            UserLoginReq loginReq = new UserLoginReq();

            loginReq.setAppCode("MYIT-ADMIN");
            loginReq.setUserName(user.getUserName());
            loginReq.setPassword(user.getPassword());

            // 调用登录接口做登录验证
            LOGGER.info("invoke userService.login");
            loginResp = userService.login(loginReq);

            LOGGER.debug(loginResp);

        } catch (Exception e) {
            LOGGER.error("user login failed", e);
        }

        // 转换json输入结果
        Gson gson = new Gson();

        if (loginResp == null) {
            LOGGER.error("loginResp is null");

            data.put("retCode", "-1");
            data.put("msg", "系统异常，请稍后再试。");

            String jsonData = gson.toJson(data);
            LOGGER.debug("jsonData=" + jsonData);

            model.addAttribute("jsonData", jsonData);

            LOGGER.info("loginValidate OUT");
            return "common/ajaxResult.ftl";
        }

        if (RETCODE_SUCCESS.equals(loginResp.getRetCode())) {
            // 登录成功
            // 缓存会话用户
            User loginUser = new User();

            loginUser.setUserName(loginResp.getUserName());
            loginUser.setPassword(loginResp.getPassword());
            loginUser.setRealName(loginResp.getRealName());

            request.getSession().setAttribute(Constant.LOGINUSER, loginUser);

            data.put("retCode", "0");
        } else {

            // 用户不存在 000000001
            if (RETCODE_USER_NOT_EXSIT.equals(loginResp.getRetCode())) {
                LOGGER.error("loginResp is null");

                data.put("retCode", "-1");
                data.put("msg", "用户不存在，请核对您的用户名");
            }

            // 密码错误 000000002
            if (RETCODE_PASSWORD_INCRECT.equals(loginResp.getRetCode())) {
                LOGGER.error("password is increct");

                data.put("retCode", "-1");
                data.put("msg", "密码错误，请核对您的密码");
            }

            // 用户禁用 000000003
            if (RETCODE_USER_INACTIVE.equals(loginResp.getRetCode())) {
                LOGGER.error("user is invalid");

                data.put("retCode", "-1");
                data.put("msg", "用户被禁止登录，请与管理员联系");
            }

        }

        // 转换json输入结果
        String jsonData = gson.toJson(data);
        LOGGER.debug("jsonData=" + jsonData);

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("loginValidate OUT");
        return "common/ajaxResult.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 客户退出登录
     * 
     * @param model
     * @param request
     * @param response
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/logout")
    public void logout(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("logout IN");

        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath());
        LOGGER.info("logout OUT");
    }

    /**
     * ajax修改密码<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/ajaxUpdPwd")
    public String ajaxUpdPwd(Model model, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("ajaxUpdPwd in");

        User user = (User) request.getSession().getAttribute(Constant.LOGINUSER);
        Map<String, Object> data = new HashMap<String, Object>();
        Gson gson = new Gson();

        // 检验原始密码是否正确
        String password1 = StringConvert.md5(getParam("oldPassword", request));
        String password2 = user.getPassword();

        if (!password1.equals(password2)) {
            data.put("retCode", "-1");
            data.put("info", "原始密码错误");
        } else {
            // 检验新密码是否为空
            String newPassword = getParam("newPassword", request);
            if (StringConvert.isEmpty(newPassword)) {
                data.put("retCode", "-1");
                data.put("info", "密码不能为空");

                String jsonData = gson.toJson(data);

                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("jsonData=" + jsonData);
                }

                model.addAttribute("jsonData", jsonData);

                LOGGER.info("ajaxUpdPwd out");
                return "common/ajaxResult";
            }

            // 更新密码 md5加密
            user.setPassword(StringConvert.md5(newPassword));
            boolean isSuccess = false;
            try {
                isSuccess = true;
            } catch (Exception e) {
                LOGGER.warn("saveUser failed", e);
            }

            if (isSuccess == false) {
                data.put("retCode", "-1");
                data.put("info", "修改密码失败，请稍后再试");
            } else {
                data.put("retCode", "0");
                data.put("info", "修改密码成功，请牢记新密码");
            }
        }

        String jsonData = gson.toJson(data);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("jsonData=" + jsonData);
        }

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("ajaxUpdPwd out");
        return "common/ajaxResult.ftl";
    }

    /**
     * 
     * <b>Function Desc:</b><br>
     * 跳转到用户管理页面
     * 
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    @RequestMapping(value = "/users")
    public String users(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("users in");

        LOGGER.info("users out");
        return "admin/user/users.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 查询用户列表
     * 
     * @param model
     * @param request
     * @param response
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("list IN");

        // 初始化查询条件
        // 当前页

        Map<String, Object> queryResult = new HashMap<String, Object>();

        // 测试数据
        queryResult.put("retCode", "0");

        // 用户列表
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User("aa" + i, "aa" + i);

            user.setRealName("zzz" + i);

            users.add(user);
        }

        queryResult.put("pageNo", 7);
        queryResult.put("pageCount", 17);
        queryResult.put("users", users);

        Gson gson = new Gson();

        String jsonData = gson.toJson(queryResult);
        LOGGER.debug("jsonData=" + jsonData);

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("list OUT");
        return "common/ajaxResult.ftl";
    }

}
