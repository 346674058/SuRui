/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.bill.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.StringConvert;
import com.myit.server.dao.bill.OrderInfoDao;
import com.myit.server.model.bill.OrderInfo;

/**
 * 订单数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("orderDao")
public class OrderInfoDaoImpl extends HibernateDaoSupport implements OrderInfoDao {
    private static final Logger LOGGER = Logger.getLogger(OrderInfoDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public OrderInfo findOrderById(Long id) throws Exception {
        LOGGER.info("findOrderById in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("id=" + id);
        }

        if (StringConvert.isEmpty(id)) {
            LOGGER.warn("id is null");

            LOGGER.info("findOrderById out.");
            return null;
        }

        OrderInfo order = (OrderInfo) getHibernateTemplate().get(OrderInfo.class, id);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("order=" + order);
        }

        LOGGER.info("findOrderById out.");
        return order;
    }

    public OrderInfo findOrderByNo(String orderNo) throws Exception {
        LOGGER.info("findOrderByNo IN");

        LOGGER.debug("orderNo=" + orderNo);

        String queryString = "from OrderInfo o where orderNo=?";
        String[] param = { orderNo };

        LOGGER.debug("queryString=" + queryString);

        OrderInfo orderInfo = null;
        try {
            orderInfo = (OrderInfo) getHibernateTemplate().findByNamedQuery(queryString, param);
        } catch (Exception e) {
            LOGGER.warn("find orderInfo failed", e);
        }

        LOGGER.info("getOrdersCount out.");
        return orderInfo;
    }

    public List<OrderInfo> findAllOrders() throws Exception {
        LOGGER.info("findAllOrders in.");

        // TODO Auto-generated method stub

        LOGGER.info("findAllOrders out.");
        return null;
    }

    public int getOrdersCount(OrderInfo order) throws Exception {
        LOGGER.info("getOrdersCount IN");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("order=" + order);
        }

        StringBuffer queryString = new StringBuffer("select count(ID) from Order o where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, order);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(order)) {
            query.setProperties(order);
        }

        List<Long> counts = query.list();
        int ordersCount = counts.get(0).intValue();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("ordersCount=" + ordersCount);
        }

        LOGGER.info("getOrdersCount OUT");
        return ordersCount;
    }

    /**
     * 动态拼接hql<br>
     * 
     * @author created by LiuCongwen at 2012-6-8
     * @param queryString
     * @param order
     * @param param
     * @return
     */
    private StringBuffer getQueryString(StringBuffer queryString, OrderInfo order) {
        LOGGER.info("getQueryString IN");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString + ", order=" + order);
        }

        if (!StringConvert.isEmpty(order)) {
            // 订单号码
            if (!StringConvert.isEmpty(order.getOrderNo())) {
                queryString.append(" and o.orderNo =:orderNo");
            }
            // 订单状态
            if (!StringConvert.isEmpty(order.getStatus())) {
                queryString.append(" and o.statu=:status");
            }
            // 客户
            if (!StringConvert.isEmpty(order.getMemberNo())) {
                queryString.append(" and o.memberId=:memberId");
            }
            // 接收人
            if (!StringConvert.isEmpty(order.getContactName())) {
                queryString.append(" and o.contactName like '%" + order.getContactName() + "%'");
            }
            // 起始下单时间
            if (!StringConvert.isEmpty(order.getStartTime())) {
                queryString.append(" and o.bookTime>=:startTime");
            }
            // 起始下单时间
            if (!StringConvert.isEmpty(order.getEndTime())) {
                queryString.append(" and o.bookTime<=:endTime");
            }
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        LOGGER.info("getQueryString OUT");
        return queryString;
    }

    public List<OrderInfo> findOrders(int start, int pageSize, OrderInfo order) throws Exception {
        LOGGER.info("findOrders in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("order=" + order);
        }

        StringBuffer queryString = new StringBuffer("from Order as o where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, order);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        // 分页查询
        Query query = getSession().createQuery(queryString.toString());

        if (!StringConvert.isEmpty(order)) {
            query.setProperties(order);
        }

        query.setFirstResult(start);
        query.setMaxResults(pageSize);

        List<OrderInfo> orders = query.list();

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("orders=" + orders);
        }

        LOGGER.info("findOrders out.");
        return orders;
    }

    public boolean persistOrder(OrderInfo order) throws Exception {
        LOGGER.info("persistOrder IN");

        LOGGER.debug("order=" + order);

        boolean success = false;

        if (StringConvert.isEmpty(order)) {
            LOGGER.warn("order is null");

            LOGGER.info("persistOrder OUT");
            return success;
        }

        order.setLastModified(new Date());

        if (order.getId() == null) {// create
            order.setCreateTime(new Date());
        }

        try {
            getHibernateTemplate().saveOrUpdate(order);

            success = true;
        } catch (Exception e) {
            LOGGER.warn("saveOrUpdate failed", e);
        }

        LOGGER.info("persistOrder OUT");
        return success;
    }
}
