/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.commodity.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;
import com.myit.server.dao.member.MemberInfoDao;
import com.myit.server.model.member.MemberInfo;

/**
 * 客户数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("customDao")
public class CommodityDaoImpl extends HibernateDaoSupport implements MemberInfoDao {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public MemberInfo findMemberInfoById(String id) throws Exception {
        logger.info("method in.");

        MemberInfo memberInfo = null;

        if (logger.isDebugEnabled()) {
            logger.debug("id=" + id);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("execute findById");
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().get(MemberInfo.class, id);

        if (logger.isDebugEnabled()) {
            logger.debug("memberInfo=" + memberInfo);
        }
        logger.info("method out.");
        return null;
    }

    public List<MemberInfo> findAllMemberInfos() throws Exception {
        logger.info("method in.");

        // TODO Auto-generated method stub

        logger.info("method out.");
        return null;
    }

    public int getMemberInfosCount(MemberInfo memberInfo, Map<String, Object> param) throws Exception {
        logger.info("method in.");

        // TODO Auto-generated method stub

        logger.info("method out.");
        return 0;
    }

    public List<MemberInfo> findMemberInfos(int start, int end, MemberInfo memberInfo, Map<String, Object> param)
            throws Exception {
        logger.info("method in.");

        // TODO Auto-generated method stub

        logger.info("method out.");
        return null;
    }

    public boolean persistMemberInfo(MemberInfo memberInfo) throws Exception {
        logger.info("persistMemberInfo in.");

        if (logger.isDebugEnabled()) {
            logger.debug("memberInfo=" + memberInfo);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("execute persist");
        }

        DateConvert dateConvert = new DateConvert();
        dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");

        memberInfo.setLastModified(new Date());

        if (memberInfo.getId() == null) {// create
            memberInfo.setCreateTime(new Date());
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().saveOrUpdate(memberInfo);

        if (logger.isDebugEnabled()) {
            logger.debug("memberInfo=" + memberInfo);
        }

        logger.info("persistMemberInfo out.");
        return true;
    }

    public MemberInfo findMemberInfosByAccount(String account) throws Exception {
        logger.info("findMemberInfosByAccount IN");

        if (logger.isDebugEnabled()) {
            logger.debug("account=" + account);
        }

        if (StringConvert.isEmpty(account)) {
            logger.warn("account is null");

            logger.info("findMemberInfosByAccount OUT");
            return null;
        }

        String queryString = "from MemberInfo where account='" + account + "'";

        if (logger.isDebugEnabled()) {
            logger.debug("execute query, queryString=" + queryString);
        }
        // 调用HibernateDaoSupport实现类方法执行查询
        @SuppressWarnings("unchecked")
        List<MemberInfo> memberInfos = getHibernateTemplate().find(queryString);

        MemberInfo memberInfo = null;

        if (memberInfos != null && memberInfos.size() > 0) {
            memberInfo = memberInfos.get(0);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("memberInfo=" + memberInfo);
        }

        logger.info("findMemberInfosByUId out");
        return memberInfo;
    }

}
