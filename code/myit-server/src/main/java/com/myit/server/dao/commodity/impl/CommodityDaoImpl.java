/**
 * @describe <功能描述>
 * create by LiuCongwen at 2012-4-24
 */
package com.myit.server.dao.commodity.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.myit.common.util.StringConvert;
import com.myit.server.dao.commodity.CommodityDao;
import com.myit.server.model.commodity.Commodity;

/**
 * 客户数据访问接口实现类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
@Service("commodityDao")
public class CommodityDaoImpl extends HibernateDaoSupport implements CommodityDao {

    private final static Logger LOGGER = Logger.getLogger(CommodityDaoImpl.class);

    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public Commodity findCommodityById(Long id) throws Exception {
        LOGGER.info("findCommodityById IN");

        Commodity commodity = null;
        try {
            // 调用HibernateDaoSupport实现类方法执行查询
            commodity = (Commodity) getHibernateTemplate().load(Commodity.class, id);
        } catch (Exception e) {
            LOGGER.warn("load entity failed, id=" + id, e);
        }

        LOGGER.info("findCommodityById OUT");
        return commodity;
    }

    public int getCommoditysCount(Commodity commodity, Map<String, Object> param) throws Exception {
        LOGGER.info("getCommoditysCount IN");

        StringBuffer queryString = new StringBuffer("select count(ID) from Commodity o where 1=1");

        // 动态拼接sql
        queryString = getQueryString(queryString, commodity);

        Query query = getSession().createQuery(queryString.toString());

        if (commodity != null) {
            query.setProperties(commodity);
        }

        List<Long> counts = query.list();
        int count = counts.get(0).intValue();

        LOGGER.info("getCommoditysCount OUT");
        return count;
    }

    /**
     * 
     * 功能描述: <br>
     * 动态组装查询语句
     * 
     * @param queryString
     * @param order
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private StringBuffer getQueryString(StringBuffer queryString, Commodity commodity) {
        LOGGER.info("getQueryString IN");

        LOGGER.debug("queryString=" + queryString + ", commodity=" + commodity);

        if (commodity != null) {
            // 商品分类
            if (!StringConvert.isEmpty(commodity.getCategoryId())) {
                queryString.append(" and o.categoryId =:categoryId");
            }
            // 商品状态
            if (!StringConvert.isEmpty(commodity.getStatus())) {
                queryString.append(" and o.statu=:status");
            }
            // 商品名称
            if (!StringConvert.isEmpty(commodity.getComName())) {
                queryString.append(" and o.comName like '%:comName%'");
            }
            // 起始创建时间
            if (!StringConvert.isEmpty(commodity.getStartTime())) {
                queryString.append(" and o.createTime>=:startTime");
            }
            // 截至创建时间
            if (!StringConvert.isEmpty(commodity.getEndTime())) {
                queryString.append(" and o.createTime<=:endTime");
            }
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("queryString=" + queryString);
        }

        LOGGER.info("getQueryString OUT");
        return queryString;
    }

    public List<Commodity> findCommodities(int start, int end, Commodity commodity, Map<String, Object> param)
            throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean persistCommodity(Commodity commodity) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
