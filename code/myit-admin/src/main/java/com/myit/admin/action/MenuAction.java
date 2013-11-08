package com.myit.admin.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单管理控制类<br>
 * 
 * @author created by LiuCongwen at 2012-4-28
 * @version 1.0.0
 */
@Controller
@RequestMapping("/menu")
public class MenuAction extends BaseAction {

    private Logger logger = Logger.getLogger(MenuAction.class);

}
