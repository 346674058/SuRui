/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.admin.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.server.dao.admin.LinkManDao;
import com.myit.server.model.admin.LinkMan;

/**
 * 用户联系人数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("linkManDao")
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

    private static final Logger logger = Logger.getLogger(LinkManDaoImpl.class);
	
	@Autowired
	 public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
	
	public LinkMan findLinkManById(Long id) throws Exception {
		logger.info("findLinkManById in.");

		LinkMan linkMan = null;

		if (logger.isDebugEnabled()) {
			logger.debug("id=" + id);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("execute findById");
		}

		// 调用HibernateDaoSupport实现类方法执行查询
		getHibernateTemplate().load(LinkMan.class, id);

		if (logger.isDebugEnabled()) {
			logger.debug("linkMan=" + linkMan);
		}

		logger.info("findLinkManById out.");
		return linkMan;
	}

	public List<LinkMan> findAllLinkMans() throws Exception {
		logger.info("findAllLinkMans in.");

		List<LinkMan> linkMans = null;

		String queryHql = "from LinkMan";

		if (logger.isDebugEnabled()) {
			logger.debug("excute query, queryHql=" + queryHql);
		}

		// TODO 调用HibernateDaoSupport实现类方法执行查询

		if (logger.isDebugEnabled()) {
			logger.debug("linkMans=" + linkMans);
		}

		logger.info("findAllLinkMans out.");
		return linkMans;
	}

	public int getLinkMansCount(LinkMan linkMan, Map<String, Object> param)
			throws Exception {
		logger.info("getLinkMansCount in.");

		int linkMansCount = 0;

		String queryHql = "select count(*) from LinkMan";

		if (logger.isDebugEnabled()) {
			logger.debug("excute query, queryHql=" + queryHql);
		}

		// TODO 调用HibernateDaoSupport实现类方法执行查询

		if (logger.isDebugEnabled()) {
			logger.debug("linkMansCount=" + linkMansCount);
		}

		logger.info("getLinkMansCount out.");
		return linkMansCount;
	}

	public List<LinkMan> findLinkMans(int start, int end, LinkMan linkMan,
			Map<String, Object> param) throws Exception {
		logger.info("findLinkMans in.");

		List<LinkMan> linkMans = new ArrayList<LinkMan>();

		if (logger.isDebugEnabled()) {
			logger.debug("start=" + start + ",end=" + end + ",linkMan="
					+ linkMan + ",param=" + param);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("execute query");
		}

		// TODO 调用HibernateDaoSupport实现类方法执行查询

		if (logger.isDebugEnabled()) {
			logger.debug("linkMans=" + linkMans);
		}

		logger.info("findLinkMans out.");
		return linkMans;
	}

	public boolean persistLinkMan(LinkMan linkMan) throws Exception {
		logger.info("persistLinkMan in.");

		if (logger.isDebugEnabled()) {
			logger.debug("linkMan=" + linkMan);
		}

		boolean isSuccess = false;

		if (logger.isDebugEnabled()) {
			logger.debug("execute persist");
		}
		
		DateConvert dateConvert=new DateConvert();
		dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");
		
		linkMan.setLastModified(new Date());
		
		if(linkMan.getId()==null){//create
			linkMan.setCreateTime(new Date());
		}
		
		// 调用HibernateDaoSupport实现类方法执行查询
		getHibernateTemplate().saveOrUpdate(linkMan);

		isSuccess = true;

		if (logger.isDebugEnabled()) {
			logger.debug("isSuccess=" + isSuccess);
		}

		logger.info("persistLinkMan out.");
		return isSuccess;
	}

	public List<LinkMan> findLinkMansByUId(Long uId) throws Exception {
		logger.info("findLinkMansByUId in.");

		if (logger.isDebugEnabled()) {
			logger.debug("uId=" + uId);
		}

		//用户id不能为null
		if (uId == null) {
			logger.warn("uId is null");
			return null;
		}

		String queryString = "from LinkMan where uId='" + uId + "'";

		if (logger.isDebugEnabled()) {
			logger.debug("execute query, queryString=" + queryString);
		}
		// 调用HibernateDaoSupport实现类方法执行查询
		@SuppressWarnings("unchecked")
        List<LinkMan> linkMans =getHibernateTemplate().find(queryString);

		if (logger.isDebugEnabled()) {
			logger.debug("linkMans=" + linkMans);
		}

		logger.info("findLinkMansByUId out.");
		return linkMans;
	}

}
