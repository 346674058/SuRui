package com.myit.server.service.admin.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myit.intf.bean.admin.LinkMan;
import com.myit.intf.service.admin.LinkManService;
import com.myit.server.dao.admin.LinkManDao;

@Service("linkManService")
public class LinkManServiceImpl implements LinkManService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private LinkManDao linkManDao;

	public LinkMan findLinkManById(Long id) throws Exception {
		logger.info("findLinkManById in.");
		
		LinkMan linkMan=null;

		if (logger.isDebugEnabled()) {
			logger.debug("parameters: id=" + id);
		}

		com.myit.server.model.admin.LinkMan linkManBean = null;

		try {
			// 调用dao查询用户联系人
			logger.info("invoke linkManDao.findLinkManById");
			linkManBean = linkManDao.findLinkManById(id);
			
			//TODO 转换输出参数
			
		} catch (Exception e) {
			logger.warn("findLinkManById failed", e);
		}

		logger.info("findLinkManById out.");
		return linkMan;
	}

	public List<LinkMan> findAllLinkMans() throws Exception {
		logger.info("method in.");

		// TODO 调用dao查询所有用户联系人

		logger.info("method out.");
		return null;
	}

	public int getLinkMansCount(LinkMan linkMan, Map<String, Object> param)
			throws Exception {
		logger.info("method in.");

		// TODO 调用dao查询用户联系人记录数

		logger.info("method out.");
		return 0;
	}

	public List<LinkMan> findLinkMans(int start, int pageSize, LinkMan linkMan,
			Map<String, Object> param) throws Exception {
		logger.info("method in.");

		// TODO 调用dao分页查询用户联系人

		logger.info("method out.");
		return null;
	}

	public List<LinkMan> findLinkMansByUId(Long uId) throws Exception {
		logger.info("findLinkMansByUId in.");
		
		List<LinkMan> linkMans=null;

		if (logger.isDebugEnabled()) {
			logger.debug("parameters: uId=" + uId);
		}
		
		//用户id不能为null
		if (uId == null) {
			logger.warn("uId is null");
			return null;
		}
		
		List<com.myit.server.model.admin.LinkMan> linkManBeans = null;

		try {
			// 调用dao查询用户联系人
			logger.info("invoke linkManDao.findLinkMansByUId");
			linkManBeans = linkManDao.findLinkMansByUId(uId);
			
			//TODO 转换输出参数
			
		} catch (Exception e) {
			logger.warn("findLinkMansByUId failed", e);
			
			throw e;
		}

		logger.info("findLinkMansByUId out.");
		return linkMans;
	}
}
