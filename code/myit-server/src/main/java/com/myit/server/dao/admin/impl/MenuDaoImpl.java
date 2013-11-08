/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.admin.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.StringConvert;
import com.myit.server.dao.admin.MenuDao;
import com.myit.server.model.admin.Menu;

/**
 * 菜单数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("menuDao")
public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao {

    private static final Logger logger = Logger.getLogger(MenuDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Menu findMenuById(Long id) throws Exception {
        logger.info("findMenuById in.");

        Menu plate = null;

        if (logger.isDebugEnabled()) {
            logger.debug("id=" + id);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("execute findById");
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().get(Menu.class, id);

        if (logger.isDebugEnabled()) {
            logger.debug("plate=" + plate);
        }

        logger.info("findMenuById out.");
        return plate;
    }

    @SuppressWarnings("unchecked")
    public List<Menu> findAllMenus() throws Exception {
        logger.info("findAllMenus in.");

        List<Menu> plates = null;

        String queryHql = "from Menu";

        if (logger.isDebugEnabled()) {
            logger.debug("excute query, queryHql=" + queryHql);
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        plates = getHibernateTemplate().loadAll(Menu.class);

        if (logger.isDebugEnabled()) {
            logger.debug("plates=" + plates);
        }

        logger.info("findAllMenus out.");
        return plates;
    }

    @SuppressWarnings("unchecked")
    public int getMenusCount(Menu plate) throws Exception {
        logger.info("getMenusCount in.");

        StringBuffer queryString = new StringBuffer("select count(ID) from Menu p where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, plate);

        if (logger.isDebugEnabled()) {
            logger.debug("queryString=" + queryString);
        }

        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(plate)) {
            query.setProperties(plate);
        }

        List<Long> counts = query.list();
        int platesCount = counts.get(0).intValue();

        if (logger.isDebugEnabled()) {
            logger.debug("platesCount=" + platesCount);
        }

        logger.info("getMenusCount out.");
        return platesCount;
    }

    private StringBuffer getQueryString(StringBuffer queryString, Menu plate) {
        logger.info("getQueryString in");

        logger.info("getQueryString out");
        return queryString;
    }

    @SuppressWarnings("unchecked")
    public List<Menu> findMenus(int start, int pageSize, Menu plate) throws Exception {
        logger.info("findMenus in.");

        if (logger.isDebugEnabled()) {
            logger.debug("start=" + start + ",pageSize=" + pageSize + ",plate=" + plate);
        }

        StringBuffer queryString = new StringBuffer("from Menu as p where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, plate);

        if (logger.isDebugEnabled()) {
            logger.debug("queryString=" + queryString);
        }

        // 分页查询
        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(plate)) {
            query.setProperties(plate);
        }

        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        List<Menu> plates = query.list();

        if (logger.isDebugEnabled()) {
            logger.debug("plates=" + plates);
        }

        logger.info("findMenus out.");
        return plates;
    }

    public boolean persistMenu(Menu plate) throws Exception {
        logger.info("persistMenu in.");

        if (logger.isDebugEnabled()) {
            logger.debug("plate=" + plate);
        }

        boolean isSuccess = false;

        if (logger.isDebugEnabled()) {
            logger.debug("execute persist");
        }

        plate.setLastModified(new Date());

        if (plate.getId() == null) {// create
            plate.setCreateTime(new Date());
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().saveOrUpdate(plate);

        isSuccess = true;

        if (logger.isDebugEnabled()) {
            logger.debug("isSuccess=" + isSuccess);
        }

        logger.info("persistMenu out.");
        return isSuccess;
    }

    @SuppressWarnings("unchecked")
    public List<Menu> findMenusByUId(Long uId) throws Exception {
        logger.info("findMenusByUId in");

        if (uId == null) {
            logger.warn("uId is null");

            logger.info("findMenusByUId out");
            return null;
        }
        
        // 查询指定角色的模块列表
        StringBuffer queryString = new StringBuffer("FROM Menu AS m WHERE m.statu='0' AND m.pId IN (SELECT id FROM Menu WHERE level='0') AND m.id IN(" 
                + " SELECT rm.mId FROM RoleMenu AS rm, Role AS r, UserRole AS ur,User AS u"
                + " WHERE rm.rId=r.id AND r.id=ur.rId AND ur.rId=u.id AND u.id='" 
                + uId
                +"') ORDER BY m.pId ASC, m.id ASC");

        List<Menu> menus = getHibernateTemplate().find(queryString.toString());

        logger.info("findMenusByUId out");
        return menus;
    }

    @SuppressWarnings("unchecked")
    public List<Menu> findChildMenus(Map<String, Object> queryParam) throws Exception {
        logger.info("findChildMenus in");

        if (queryParam.get("pId") == null) {
            logger.warn("pId is null");

            logger.info("findChildMenus out");
            return null;
        }

        StringBuffer queryString = new StringBuffer("from Menu as m where m.pId='" + queryParam.get("pId") + "' ");// 父菜单id

        if (queryParam.get("statu") != null) {
            queryString.append(" and m.statu='" + queryParam.get("statu") + "' ");
        }

        queryString.append(" order by orderIndex asc");
        List<Menu> menus = getHibernateTemplate().find(queryString.toString());

        logger.info("findChildMenus out");
        return menus;
    }

}
