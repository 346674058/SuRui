/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.member.impl;

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
@Service("memberInfoDao")
public class MemberInfoDaoImpl extends HibernateDaoSupport implements MemberInfoDao {

    private final static Logger LOGGER = Logger.getLogger(MemberInfoDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public MemberInfo findMemberInfoById(String id) throws Exception {
        LOGGER.info("findMemberInfoById IN");

        MemberInfo memberInfo = null;

        try {
            // 调用HibernateDaoSupport实现类方法执行查询
            memberInfo = (MemberInfo) getHibernateTemplate().load(MemberInfo.class, id);
        } catch (Exception e) {
            LOGGER.warn("load entity failed,id=" + id, e);
        }

        LOGGER.info("findMemberInfoById OUT");
        return memberInfo;
    }

    public List<MemberInfo> findAllMemberInfos() throws Exception {
        LOGGER.info("method in.");

        // TODO Auto-generated method stub

        LOGGER.info("method out.");
        return null;
    }

    public int getMemberInfosCount(MemberInfo memberInfo, Map<String, Object> param) throws Exception {
        LOGGER.info("method in.");

        // TODO Auto-generated method stub

        LOGGER.info("method out.");
        return 0;
    }

    public List<MemberInfo> findMemberInfos(int start, int end, MemberInfo memberInfo, Map<String, Object> param)
            throws Exception {
        LOGGER.info("method in.");

        // TODO Auto-generated method stub

        LOGGER.info("method out.");
        return null;
    }

    public boolean persistMemberInfo(MemberInfo memberInfo) throws Exception {
        LOGGER.info("persistMemberInfo in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("memberInfo=" + memberInfo);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute persist");
        }

        DateConvert dateConvert = new DateConvert();
        dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");

        memberInfo.setLastModified(new Date());

        if (memberInfo.getId() == null) {// create
            memberInfo.setCreateTime(new Date());
        }

        // 调用HibernateDaoSupport实现类方法执行查询
        getHibernateTemplate().saveOrUpdate(memberInfo);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("memberInfo=" + memberInfo);
        }

        LOGGER.info("persistMemberInfo out.");
        return true;
    }

    public MemberInfo findMemberInfosByAccount(String account) throws Exception {
        LOGGER.info("findMemberInfosByAccount IN");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("account=" + account);
        }

        if (StringConvert.isEmpty(account)) {
            LOGGER.warn("account is null");

            LOGGER.info("findMemberInfosByAccount OUT");
            return null;
        }

        String queryString = "from MemberInfo where account='" + account + "'";

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("execute query, queryString=" + queryString);
        }
        // 调用HibernateDaoSupport实现类方法执行查询
        @SuppressWarnings("unchecked")
        List<MemberInfo> memberInfos = getHibernateTemplate().find(queryString);

        MemberInfo memberInfo = null;

        if (memberInfos != null && memberInfos.size() > 0) {
            memberInfo = memberInfos.get(0);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("memberInfo=" + memberInfo);
        }

        LOGGER.info("findMemberInfosByUId out");
        return memberInfo;
    }

}
