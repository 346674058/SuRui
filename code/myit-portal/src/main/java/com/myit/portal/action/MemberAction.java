package com.myit.portal.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.myit.common.util.RetCode;
import com.myit.intf.bean.member.LoginReq;
import com.myit.intf.bean.member.LoginResp;
import com.myit.intf.bean.member.RegistReq;
import com.myit.intf.bean.member.RegistResp;
import com.myit.intf.service.admin.OperateLogService;
import com.myit.intf.service.admin.UserService;
import com.myit.intf.service.member.MemberService;
import com.myit.portal.action.bean.AdvImg;
import com.myit.portal.action.bean.Member;
import com.myit.portal.util.Constant;

/**
 * 
 * 会员操作流程控制类<br>
 * 会员登录、注册、修改密码等
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/member")
public class MemberAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(MemberAction.class);

    @Resource
    UserService userService;

    @Resource
    MemberService memberService;

    @Resource
    OperateLogService operateLogService;

    /**
     * 
     * 功能描述: <br>
     * 跳转到会员登录页面
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/login")
    public String login(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("login IN");

        // 查询广告图片
        AdvImg advImg = new AdvImg("http://www.baidu.com", "img/logo.jpg");
        model.addAttribute("advImg", advImg);

        // 回调链接
        model.addAttribute("_CALLBACK", request.getParameter("_CALLBACK"));

        LOGGER.info("login OUT");
        return "member/login.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 会员登录验证
     * 
     * @param loginReq
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
    public String loginValidate(LoginReq loginReq, Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("loginValidate IN");

        LOGGER.debug(loginReq);

        LoginResp loginResp = new LoginResp();

        Map<String, Object> data = new HashMap<String, Object>();

        try {
            loginReq.setAppCode("MYIT-PORTAL");

            // 调用登录接口做登录验证
            LOGGER.info("invoke memberService.login");
            loginResp = memberService.login(loginReq);

            LOGGER.debug(loginResp);

        } catch (Exception e) {
            LOGGER.error("member login failed", e);
        }

        // 转换json输入结果
        Gson gson = new Gson();

        if (loginResp == null) {
            LOGGER.error("loginResp is null");

            data.put("retCode", Constant.FAILED);
            data.put("msg", "系统忙，请稍后再试。");

            String jsonData = gson.toJson(data);
            LOGGER.debug("jsonData=" + jsonData);

            model.addAttribute("jsonData", jsonData);

            LOGGER.info("loginValidate OUT");
            return "common/ajaxResult.ftl";
        }

        if (RetCode.SUCCESS.equals(loginResp.getRetCode())) {
            // 登录成功
            // 缓存会话会员
            Member member = new Member();

            member.setMemberNo(loginResp.getMemberNo());
            member.setNick(loginResp.getRealName());

            request.getSession().setAttribute(Constant.LOGIN_MEMBER, member);

            data.put("retCode", Constant.SUCCESS);
        } else {

            // 会员不存在 000010001
            if (RetCode.MEMBER_NOT_EXSIT.equals(loginResp.getRetCode())) {
                LOGGER.error("loginResp is null");

                data.put("retCode", RetCode.FAILED);
                data.put("msg", "会员不存在，请核对您的会员帐号");
            }

            // 密码错误 000000002
            if (RetCode.PASSWORD_INCRECT.equals(loginResp.getRetCode())) {
                LOGGER.error("password is increct");

                data.put("retCode", RetCode.FAILED);
                data.put("msg", "密码错误，请核对您的密码");
            }

            // 用户禁用 000001003
            if (RetCode.MEMBER_INACTIVE.equals(loginResp.getRetCode())) {
                LOGGER.error("member is invalid");

                data.put("retCode", RetCode.FAILED);
                data.put("msg", "会员被禁止登录，请与管理员联系");
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
     * 跳转到会员登录页面
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/regist")
    public String regist(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("regist IN");

        // 查询广告图片
        AdvImg advImg = new AdvImg("http://www.baidu.com", "img/logo.jpg");
        model.addAttribute("advImg", advImg);

        // 回调链接
        model.addAttribute("_CALLBACK", request.getParameter("_CALLBACK"));

        LOGGER.info("regist OUT");
        return "member/regist.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 会员登录验证
     * 
     * @param loginReq
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/saveRegist", method = RequestMethod.POST)
    public String saveRegist(RegistReq registReq, Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("saveRegist IN");

        LOGGER.debug(registReq);

        Map<String, Object> data = new HashMap<String, Object>();

        RegistResp registResp = null;
        try {

            registReq.setBirthday(new Date());
            registReq.setMobile("13811111111");

            registReq.setProvinceId("01");
            registReq.setCityId("0101");
            registReq.setAreaId("0101001");

            registReq.setAddress("湖北省实验室");

            registResp = memberService.regist(registReq);
        } catch (Exception e) {
            LOGGER.warn("member regist failed ", e);
        }

        if (registResp == null) {
            LOGGER.warn("registResp is null");

            // 接口调用异常
            data.put("retCode", RetCode.FAILED);
            data.put("msg", "注册失败，请与客服025-111111联系。");
        } else if (!"0".equals(registResp.getRetCode())) {
            LOGGER.warn("member regist failed,retCode=" + registResp.getRetCode());

            // 注册失败
            data.put("retCode", RetCode.FAILED);
            data.put("msg", "注册失败，请与客服025-111111联系。");

        } else { // 注册成功

            // 获取当前登录成功的会员，存入session
            Member member = new Member();

            member.setMemberNo(registResp.getMemberNo());
            member.setNick(registResp.getRealName());
            member.setGender("F");

            request.getSession(true).setAttribute(Constant.LOGIN_MEMBER, member);

            data.put("retCode", RetCode.SUCCESS);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(data);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("jsonData=" + jsonData);
        }

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("saveRegist out");
        return "common/ajaxResult.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param errorCode
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/randomCode")
    public void randomCode(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("randomCode in");

        int width = 60;
        int height = 20;
        // 创建具有可访问图像数据缓冲区的Image
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 创建一个随机数生成器
        Random random = new Random();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 创建字体，字体的大小应该根据图片的高度来定
        Font font = new Font("Times New Roman", Font.PLAIN, 18);
        // 设置字体
        g.setFont(font);

        // 画边框
        // g.setColor(Color.BLACK);
        // g.drawRect(0, 0, width - 1, height - 1);

        // 随机产生160条干扰线
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 160; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        // randomCode 用于保存随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;

        // 随机产生4位数字的验证码
        for (int i = 0; i < 4; i++) {
            // 得到随机产生的验证码数字
            String strRand = String.valueOf(random.nextInt(10));

            // 产生随机的颜色分量来构造颜色值
            red = random.nextInt(110);
            green = random.nextInt(50);
            blue = random.nextInt(50);

            // 用随机产生的颜色将验证码绘制到图像中
            g.setColor(new Color(red, green, blue));
            g.drawString(strRand, 13 * i + 6, 16);

            randomCode.append(strRand);
        }

        // 将四位数字的验证码保存到session中
        HttpSession session = request.getSession(true);
        session.setAttribute(Constant.RANDOM_CODE, randomCode.toString());

        // 禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/jpeg");

        // 将图像输出到servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.flush();
        sos.close();

        LOGGER.info("randomCode out");
    }

    /**
     * 
     * 功能描述: <br>
     * 跳转到会员登录页面
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/logout")
    public String logout(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("logout IN");

        request.getSession(true).invalidate();

        String redirect = "index.htm";

        model.addAttribute("redirect", redirect);

        LOGGER.info("logout OUT");
        return "common/redirect.ftl";
    }

}
