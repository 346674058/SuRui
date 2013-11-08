package com.myit.portal.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myit.common.exception.CommException;
import com.myit.intf.service.admin.OperateLogService;
import com.myit.intf.service.admin.UserService;
import com.myit.portal.util.Constant;

/**
 * 
 * 首页操作流程控制类<br>
 * 跳转到首页
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class ExceptionAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(ExceptionAction.class);

    /**
     * 
     * 功能描述: <br>
     * 跳转到错误页面
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
    @RequestMapping(value = "/error/{errorCode}")
    public String error(@PathVariable String errorCode, Model model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        LOGGER.info("error in");

        LOGGER.debug("errorCode:" + errorCode);

        model.addAttribute("exception", getException(errorCode));

        LOGGER.info("error out");
        return "exception/error-exception.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 根据errorCode 获取异常对象
     * 
     * @param errorCode
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private CommException getException(String errorCode) {

        CommException exception = new CommException();

        exception.setCode(errorCode);
        exception.setMessage("页面不存在");

        List<String> resolves = new ArrayList<String>();

        resolves.add("请检查输入的链接无误");
        resolves.add("请输入其他链接");

        exception.setResolves(resolves);

        return exception;
    }

}
