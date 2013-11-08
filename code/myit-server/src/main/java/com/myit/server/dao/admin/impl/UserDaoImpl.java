/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.admin.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;
import com.myit.server.dao.admin.UserDao;
import com.myit.server.model.admin.User;

/**
 * 用户数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public User findUserById(Long id) throws Exception {
        LOGGER.info("findUserById in.");

        User user = null;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("id=" + id);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute findById");
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().get(User.class, id);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("user=" + user);
        }

        LOGGER.info("findUserById out.");
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() throws Exception {
        LOGGER.info("findAllUsers in.");

        List<User> users = null;

        String queryHql = "from User";

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("excute query, queryHql=" + queryHql);
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        users = getHibernateTemplate().loadAll(User.class);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("users=" + users);
        }

        LOGGER.info("findAllUsers out.");
        return users;
    }

    public int getUsersCount(User user) throws Exception {
        LOGGER.info("getUsersCount in.");

        StringBuffer queryString = new StringBuffer("select count(ID) from User u where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, user);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(user)) {
            query.setProperties(user);
        }

        @SuppressWarnings("unchecked")
        List<Long> counts = query.list();
        int usersCount = counts.get(0).intValue();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("usersCount=" + usersCount);
        }

        LOGGER.info("getUsersCount out.");
        return usersCount;
    }

    private StringBuffer getQueryString(StringBuffer queryString, User user) {
        LOGGER.info("getQueryString in");
        
        //按用户名查询
        if(!StringConvert.isEmpty(user.getUserName())){
            queryString.append(" and userName = '"+user.getUserName()+"'");
        }
        
        //按用户名查询
        if(!StringConvert.isEmpty(user.getRealName())){
            queryString.append(" and realName like '%"+user.getRealName()+"%'");
        }
        
        //按性别查询
        if(!StringConvert.isEmpty(user.getSex())){
            queryString.append(" and sex = '"+user.getSex()+"'");
        }

        LOGGER.info("getQueryString out");
        return queryString;
    }

    public List<User> findUsers(int start, int pageSize, User user) throws Exception {
        LOGGER.info("findUsers in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("start=" + start + ",pageSize=" + pageSize + ",user=" + user);
        }

        StringBuffer queryString = new StringBuffer("from User as u where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, user);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        // 分页查询
        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(user)) {
            query.setProperties(user);
        }

        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        @SuppressWarnings("unchecked")
        List<User> users = query.list();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("users=" + users);
        }

        LOGGER.info("findUsers out.");
        return users;
    }

    public boolean persistUser(User user) throws Exception {
        LOGGER.info("persistUser in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("user=" + user);
        }

        boolean isSuccess = false;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute persist");
        }

        DateConvert dateConvert = new DateConvert();
        dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");

        user.setLastModified(new Date());

        if (user.getId() == null) {// create
            user.setCreateTime(new Date());
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().saveOrUpdate(user);

        isSuccess = true;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("isSuccess=" + isSuccess);
        }

        LOGGER.info("persistUser out.");
        return isSuccess;
    }

    public User findUserByUserName(String userName) throws Exception {
        LOGGER.info("findUserByUserName in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("userName=" + userName);
        }

        String queryString = "from User where userName='" + userName + "'";

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute query, queryString=" + queryString);
        }
        // 调用HibernateDaoSupport实现类方法执行查询
        @SuppressWarnings("unchecked")
        List<User> users = getHibernateTemplate().find(queryString);

        User user = null;

        if (users != null && users.size() > 0) {
            user = users.get(0);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("user=" + user);
        }

        LOGGER.info("findUserById out.");
        return user;
    }

}
