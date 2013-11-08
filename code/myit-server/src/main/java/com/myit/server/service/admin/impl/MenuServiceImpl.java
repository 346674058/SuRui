package com.myit.server.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myit.common.beans.PageQueryParam;
import com.myit.common.beans.PageQueryResult;
import com.myit.intf.bean.admin.Menu;
import com.myit.intf.service.admin.MenuService;
import com.myit.server.dao.admin.MenuDao;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private MenuDao menuDao;

    public Menu findMenuById(Long id) throws Exception {
        logger.info("findMenuById in.");

        Menu menu = null;

        if (logger.isDebugEnabled()) {
            logger.debug("parameters: id=" + id);
        }

        // 调用dao查询板块
        logger.info("invoke plateDao.findMenuById");
        com.myit.server.model.admin.Menu plate = menuDao.findMenuById(id);

        logger.info("findMenuById out.");
        return menu;
    }

    public List<Menu> findAllMenus() throws Exception {
        logger.info("findAllMenus in.");

        List<Menu> menus = null;

        List<com.myit.server.model.admin.Menu> plates = menuDao.findAllMenus();

        logger.info("findAllMenus out.");
        return menus;
    }

    public int getMenusCount(Menu menu) throws Exception {
        logger.info("getMenusCount in.");

        // 调用dao查询板块记录数
        com.myit.server.model.admin.Menu menuBean = null;

        int platesCount = menuDao.getMenusCount(menuBean);

        logger.info("getMenusCount out.");
        return platesCount;
    }

    public PageQueryResult<Menu> findMenus(PageQueryParam<Menu> pageQueryParam) throws Exception {
        logger.info("findMenus in.");

        if (logger.isDebugEnabled()) {
            logger.debug("pageQueryParam=" + pageQueryParam);
        }

        int total = 0;
        PageQueryResult<Menu> pageQueryResult = null;

        try {
            com.myit.server.model.admin.Menu menuBean = null;

            // 调用dao查询板块总数
            total = menuDao.getMenusCount(menuBean);

            PageQueryResult<com.myit.server.model.admin.Menu> pageQueryResultTemp = new PageQueryResult<com.myit.server.model.admin.Menu>(total, pageQueryParam.getPageNo(), pageQueryParam.getPageSize());

            if (total > 0) {
                // 调用dao分页查询板块
                List<com.myit.server.model.admin.Menu> menus = menuDao.findMenus(pageQueryResult.getStart(), pageQueryResult.getPageSize(),
                        menuBean);

                pageQueryResultTemp.setRows(menus);
            }
        } catch (Exception e) {
            logger.warn("Exception occured", e);

            throw e;
        }

        if (logger.isDebugEnabled()) {
            logger.debug("pageQueryResult=" + pageQueryResult);
        }

        logger.info("findMenus out.");
        return pageQueryResult;
    }

    public boolean saveMenu(Menu menu) throws Exception {
        logger.info("saveMenu in.");

        // 调用dao保存板块信息
        com.myit.server.model.admin.Menu menuBean = null;

        boolean isSuccess = menuDao.persistMenu(menuBean);

        if (logger.isDebugEnabled()) {
            logger.debug("isSuccess=" + isSuccess);
        }

        logger.info("saveMenu out.");
        return isSuccess;
    }

    public List<Menu> getLoginMenus(Long uId) throws Exception {
        logger.info("getLoginMenus in.");

        List<Menu> menus = null;

        // 调用dao查询板块信息
        List<com.myit.server.model.admin.Menu> menuBeans = menuDao.findMenusByUId(uId);

        if (menus != null) {
            logger.debug("menus.size=" + menus.size());
        }

        logger.info("getLoginMenus out.");
        return menus;
    }

    public List<Menu> findChildMenus(Long mId) throws Exception {
        logger.info("findPlatesByRId in.");

        List<Menu> menus = null;

        Map<String, Object> queryParam = new HashMap<String, Object>();
        queryParam.put("pId", mId);

        // 调用dao查询板块信息
        List<com.myit.server.model.admin.Menu> menuBeans = menuDao.findChildMenus(queryParam);

        if (menus != null) {
            logger.debug("menus.size=" + menus.size());
        }

        logger.info("findPlatesByRId out.");
        return menus;
    }
}
