package com.myit.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myit.admin.bean.Menu;
import com.myit.admin.bean.Modual;
import com.myit.admin.bean.User;
import com.myit.admin.util.Constant;
import com.myit.intf.bean.admin.UserEvt;

@Controller
public class IndexAction extends BaseAction {

    private final static Logger LOGGER = Logger.getLogger(IndexAction.class);

    /**
     * <b>Function Desc:</b><br>
     * 跳转到首页
     * 
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("index in");

        User user = (User) request.getSession().getAttribute(Constant.LOGINUSER);
        LOGGER.debug("user=" + user);

        LOGGER.info("index out");
        return "index.ftl";
    }

    /**
     * 获取登录用户的菜单列表<br>
     * 
     * @author created by LiuCongwen at 2012-6-2
     * @param plateId
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/myMenus")
    public String myMenus(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("myMenus IN");

        User user = (User) request.getSession().getAttribute(Constant.LOGINUSER);
        LOGGER.debug("user=" + user);

        // 演示数据
        List<Modual> moduals = new ArrayList<Modual>();

        for (int i = 0; i < 4; i++) {
            Modual modual = new Modual();

            modual.setId(Long.valueOf(i));
            
            modual.setName("模块0" + i);
            modual.setIcon("edit");
            modual.setExtInfo("+" + i);

            // 菜单信息
            List<Menu> menus = new ArrayList<Menu>();
            for (int j = 0; j < 5; j++) {
                Menu menu = new Menu();

                menu.setName("菜单" + i + j);
                menu.setIcon("home");
                menu.setHref("http://www.baidu.com");
                menu.setTitle("操作功能" + i + j);

                menus.add(menu);
            }

            // 添加菜单列表
            modual.setMenus(menus);

            // 添加模块
            moduals.add(modual);
        }

        model.addAttribute("moduals", moduals);

        LOGGER.info("myMenus OUT");
        return "admin/myMenus.ftl";
    }

    /**
     * <b>Function Desc:</b><br>
     * 跳转到欢迎页
     * 
     * @param model
     * @param request
     * @param response
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    @RequestMapping(value = "/portal")
    public String portal(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("portal IN");

        UserEvt user = (UserEvt) request.getSession().getAttribute(Constant.LOGINUSER);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("user=" + user);
        }

        model.addAttribute("user", user);

        LOGGER.info("portal OUT");
        return "portal.ftl";
    }
}
