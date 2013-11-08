/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.baseData.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;
import com.myit.server.dao.baseData.CodeGenDao;
import com.myit.server.model.baseData.CodeGen;

/**
 * 代码快照数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("codeSnapshotDao")
public class CodeGenDaoImpl extends HibernateDaoSupport implements CodeGenDao {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public CodeGen findCodeSnapshotById(Long id) throws Exception {
        logger.info("findCodeSnapshotById in.");

        if (logger.isDebugEnabled()) {
            logger.debug("id=" + id);
        }

        if (StringConvert.isEmpty(id)) {
            logger.warn("id is null");

            logger.info("findCodeSnapshotById out.");
            return null;
        }

        CodeGen codeSnapshot = (CodeGen) getHibernateTemplate().load(CodeGen.class, id);

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshot=" + codeSnapshot);
        }

        logger.info("findCodeSnapshotById out.");
        return null;
    }

    public List<CodeGen> findAllCodeSnapshots() throws Exception {
        logger.info("method in.");

        // TODO Auto-generated method stub

        logger.info("method out.");
        return null;
    }

    public int getCodeSnapshotsCount(CodeGen codeSnapshot, Map<String, Object> param) throws Exception {
        logger.info("getCodeSnapshotsCount in.");

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshot=" + codeSnapshot);
        }

        StringBuffer queryString = new StringBuffer("select count(o) from CodeSnapshot o where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, codeSnapshot, param);

        List<Long> counts = getHibernateTemplate().find(queryString.toString());

        int count = counts.get(0).intValue();

        if (logger.isDebugEnabled()) {
            logger.debug("count=" + count);
        }

        logger.info("getCodeSnapshotsCount out.");
        return count;
    }

    /**
     * 动态拼接sql<br>
     * 
     * @author created by LiuCongwen at 2012-6-8
     * @param queryString
     * @param codeSnapshot
     * @param param
     * @return
     */
    private StringBuffer getQueryString(StringBuffer queryString, CodeGen codeSnapshot, Map<String, Object> param) {
        logger.info("getQueryString in.");

        // TODO Auto-generated method stub

        logger.info("getQueryString out.");
        return queryString;
    }

    public List<CodeGen> findCodeSnapshots(int start, int pageSize, CodeGen codeSnapshot, Map<String, Object> param)
            throws Exception {
        logger.info("findCodeSnapshots in.");

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshot=" + codeSnapshot);
        }

        StringBuffer queryString = new StringBuffer("from CodeSnapshot o where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, codeSnapshot, param);

        // 分页查询
        Query query = getSession().createQuery(queryString.toString());
        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        List<CodeGen> codeSnapshots = query.list();

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshots=" + codeSnapshots);
        }

        logger.info("findCodeSnapshots out.");
        return codeSnapshots;
    }

    public boolean persistCodeSnapshot(CodeGen codeSnapshot) throws Exception {
        logger.info("persistCodeSnapshot in.");

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshot=" + codeSnapshot);
        }

        if (StringConvert.isEmpty(codeSnapshot)) {
            logger.warn("codeSnapshot is null");

            logger.info("saveCodeSnapshot out.");
            return false;
        }

        DateConvert dateConvert = new DateConvert();
        dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");

        codeSnapshot.setLastModified(new Date());

        if (codeSnapshot.getId() == null) {// create
            codeSnapshot.setCreateTime(new Date());
        }

        getHibernateTemplate().saveOrUpdate(codeSnapshot);

        logger.info("persistCodeSnapshot out.");
        return true;
    }

    public CodeGen findCodeSnapshotByCodeType(String codeType) throws Exception {
        logger.info("findCodeSnapshotByCodeType in.");

        if (logger.isDebugEnabled()) {
            logger.debug("codeType=" + codeType);
        }

        if (StringConvert.isEmpty(codeType)) {
            logger.warn("codeType is null");

            logger.info("findCodeSnapshotByCodeType out.");
            return null;
        }

        String queryString = "from CodeSnapshot where codeType='" + codeType + "'";

        if (logger.isDebugEnabled()) {
            logger.debug("queryString=" + queryString);
        }

        CodeGen codeSnapshot = null;

        List<CodeGen> codeSnapshots = getHibernateTemplate().find(queryString);
        if (codeSnapshots != null && codeSnapshots.size() > 0) {
            codeSnapshot = codeSnapshots.get(0);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("codeSnapshot=" + codeSnapshot);
        }

        logger.info("findCodeSnapshotByCodeType out.");
        return codeSnapshot;
    }

}
