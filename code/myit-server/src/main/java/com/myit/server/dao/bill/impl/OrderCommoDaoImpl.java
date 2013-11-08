/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.bill.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.DateConvert;
import com.myit.common.util.StringConvert;
import com.myit.server.dao.bill.OrderCommoDao;
import com.myit.server.model.bill.OrderCommo;

/**
 * 订单数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("orderGoodsDao")
public class OrderCommoDaoImpl extends HibernateDaoSupport implements
		OrderCommoDao {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
       super.setSessionFactory(sessionFactory);
   }
	
	public OrderCommo findOrderGoodsById(String id) throws Exception {
		logger.info("method in.");

		// TODO Auto-generated method stub

		logger.info("method out.");
		return null;
	}

	public List<OrderCommo> findOrderGoodsByOId(Long oId) throws Exception {
		logger.info("findOrderGoodsByOId in.");

		if (logger.isDebugEnabled()) {
			logger.debug("oId=" + oId);
		}

		if (StringConvert.isEmpty(oId)) {
			logger.warn("oId is null");

			logger.info("findOrderGoodsByOId out.");
			return null;
		}

		String queryString = "from OrderGoods where oId=" + oId;

		if (logger.isDebugEnabled()) {
			logger.debug("queryString=" + queryString);
		}

		List<OrderCommo> orderGoodsList = getHibernateTemplate().find(queryString);

		if (logger.isDebugEnabled()) {
			logger.debug("orderGoodsList=" + orderGoodsList);
		}

		if (orderGoodsList != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("orderGoodsList.size=" + orderGoodsList.size());
			}
		}

		logger.info("findOrderGoodsByOId out.");
		return orderGoodsList;
	}
	
	public boolean persistOrderGoods(OrderCommo orderGoods) throws Exception {
		logger.info("persistOrderGoods in.");

		if (logger.isDebugEnabled()) {
			logger.debug("orderGood=" + orderGoods);
		}

		if (StringConvert.isEmpty(orderGoods)) {
			logger.warn("orderGood is null");

			logger.info("persistOrderGoods out.");
			return false;
		}
		
		DateConvert dateConvert=new DateConvert();
		dateConvert.setPattern("yyyy-MM-dd hh:mm:ss");
		
		orderGoods.setLastModified(new Date());
		
		if(orderGoods.getId()==null){//create
			orderGoods.setCreateTime(new Date());
		}

		getHibernateTemplate().saveOrUpdate(orderGoods);

		logger.info("persistOrderGoods out.");
		return true;
	}

	public boolean deleteOrderGoods(OrderCommo orderGoods) throws Exception {
		logger.info("deleteOrderGoods in.");

		if (logger.isDebugEnabled()) {
			logger.debug("orderGood=" + orderGoods);
		}

		if (StringConvert.isEmpty(orderGoods)) {
			logger.warn("orderGood is null");

			logger.info("persistOrderGoods out.");
			return false;
		}

		getHibernateTemplate().delete(orderGoods);

		logger.info("persistOrderGoods out.");
		return true;
	}

	public boolean deleteOrderGoodsByOId(Long oId) throws Exception {
		logger.info("deleteOrderGoods in.");

		if (logger.isDebugEnabled()) {
			logger.debug("oId=" + oId);
		}

		if (StringConvert.isEmpty(oId)) {
			logger.warn("oId is null");

			logger.info("persistOrderGoods out.");
			return false;
		}

		String queryString = "delete from OrderGoods where oId=" + oId;

		if (logger.isDebugEnabled()) {
			logger.debug("queryString=" + queryString);
		}

		getHibernateTemplate().bulkUpdate(queryString);

		logger.info("persistOrderGoods out.");
		return true;
	}

}
