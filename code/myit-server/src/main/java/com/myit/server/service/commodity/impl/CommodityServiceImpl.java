package com.myit.server.service.commodity.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.commodity.CommodityItem;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.service.commodity.CommodityService;
import com.myit.server.dao.commodity.CommodityDao;
import com.myit.server.model.commodity.Commodity;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = Logger.getLogger(CommodityServiceImpl.class);

    @Resource
    CommodityDao commodityDao;

    public SearchCommodityResp searchCommodities(SearchCommodityReq req) throws Exception {
        LOGGER.info("searchCommodities IN");

        LOGGER.debug("req=" + req);

        SearchCommodityResp searchCommodityResp = new SearchCommodityResp(req);

        int star = req.getStart();
        int pageSize = req.getPageSize();

        // TODO 从数据库中查询对应的商品
        List<Commodity> commodities = commodityDao.findCommodities(star, pageSize, null, null);

        List<CommodityItem> commoditiesTemp = getcommodityList(commodities);

        searchCommodityResp.setRetCode(RetCode.SUCCESS);
        searchCommodityResp.setCommodities(commoditiesTemp);
        

        LOGGER.info("searchCommodities OUT");
        return searchCommodityResp;
    }

    /**
     * 
     * 功能描述: <br>
     * 转换商品列表对象
     * 
     * @param commodities
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<CommodityItem> getcommodityList(List<Commodity> commodities) {
        // TODO Auto-generated method stub
        return null;
    }
}
