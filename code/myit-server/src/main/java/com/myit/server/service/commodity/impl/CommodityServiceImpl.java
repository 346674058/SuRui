package com.myit.server.service.commodity.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.service.commodity.CommodityService;
import com.myit.server.dao.commodity.CommodityDao;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = Logger.getLogger(CommodityServiceImpl.class);

    @Resource
    CommodityDao commodityDao;

    public SearchCommodityResp searchCommodities(SearchCommodityReq req) throws Exception {
        LOGGER.info("searchCommodities IN");

        LOGGER.debug("req=" + req);

        SearchCommodityResp searchCommodityResp = new SearchCommodityResp();

        // TODO 从数据库中查询对应的商品
        int star = 0;
        int end = 0;

        commodityDao.findCommodities(star, end, null, null);

        searchCommodityResp.setRetCode(RetCode.SUCCESS);

        LOGGER.info("searchCommodities OUT");
        return searchCommodityResp;
    }
}
