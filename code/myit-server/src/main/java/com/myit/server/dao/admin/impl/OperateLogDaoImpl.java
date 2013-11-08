package com.myit.server.dao.admin.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;
import com.myit.server.dao.admin.OperateLogDao;
import com.myit.server.model.admin.OperateLog;
import com.myit.server.model.admin.User;
import com.myit.server.util.Constant;

@Service("OperateLogDao")
public class OperateLogDaoImpl extends HibernateDaoSupport implements OperateLogDao {

    private static final Logger LOGGER = Logger.getLogger(OperateLogDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public OperateLog findOperateLogById(Long id) throws Exception {
        LOGGER.info("findOperateLogById in.");

        OperateLog operateLog = null;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("id=" + id);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute findById");
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().get(OperateLog.class, id);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLog=" + operateLog);
        }

        LOGGER.info("findOperateLogById out.");
        return operateLog;
    }

    @SuppressWarnings("unchecked")
    public List<OperateLog> findAllOperateLogs() throws Exception {
        LOGGER.info("findAllOperateLogs in.");

        List<OperateLog> operateLogs = null;

        String queryHql = "from User";

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("excute query, queryHql=" + queryHql);
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        operateLogs = getHibernateTemplate().loadAll(User.class);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLogs=" + operateLogs);
        }

        LOGGER.info("findAllOperateLogs out.");
        return operateLogs;
    }

    public int getOperateLogsCount(OperateLog operateLog, String[] sortParams) throws Exception {
        LOGGER.info("getOperateLogsCount in.");

        StringBuffer queryString = new StringBuffer("select count(ID) from OperateLog op where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, operateLog, sortParams);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(operateLog)) {
            query.setProperties(operateLog);
        }

        @SuppressWarnings("unchecked")
        List<Long> counts = query.list();
        int operateLogsCount = counts.get(0).intValue();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLogsCount=" + operateLogsCount);
        }

        LOGGER.info("getOperateLogsCount out.");
        return operateLogsCount;
    }

    private StringBuffer getQueryString(StringBuffer queryString, OperateLog operateLog, String[] sortParams) {
        LOGGER.info("getQueryString in");

        // 追加过滤sql
        if (operateLog != null && !StringConvert.isEmpty(operateLog.getOpType())) {
            queryString.append(" and opType='" + operateLog.getOpType() + "'");
        }
        if (operateLog != null && !StringConvert.isEmpty(operateLog.getUserName())) {
            queryString.append(" and userName='" + operateLog.getUserName() + "'");
        }

        // 追加排序sql
        if (sortParams != null && sortParams.length > 0) {
            for (int i = 0; i < sortParams.length; i++) {
                queryString.append(" order by " + sortParams[i]);
            }
        }

        LOGGER.info("getQueryString out");
        return queryString;
    }

    public List<OperateLog> findOperateLogs(int start, int pageSize, OperateLog operateLog, String[] sortParams) throws Exception {
        LOGGER.info("findOperateLogs in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("start=" + start + ",pageSize=" + pageSize + ",operateLog=" + operateLog);
        }

        StringBuffer queryString = new StringBuffer("from OperateLog as p where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, operateLog, sortParams);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        // 分页查询
        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(operateLog)) {
            query.setProperties(operateLog);
        }

        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        @SuppressWarnings("unchecked")
        List<OperateLog> operateLogs = query.list();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLogs=" + operateLogs);
        }

        LOGGER.info("findOperateLogs out.");
        return operateLogs;
    }

    public boolean persistOperateLog(OperateLog operateLog) throws Exception {
        LOGGER.info("persistOperateLog in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLog=" + operateLog);
        }

        boolean isSuccess = false;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute persist");
        }

        DateConvert dateConvert = new DateConvert();
        dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");

        operateLog.setLastModified(new Date());

        if (operateLog.getId() == null) {// create
            operateLog.setCreateTime(new Date());
            operateLog.setStatus(Constant.ACTIVE); // 启用
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().saveOrUpdate(operateLog);

        isSuccess = true;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("isSuccess=" + isSuccess);
        }

        LOGGER.info("persistOperateLog out.");
        return isSuccess;
    }

}
