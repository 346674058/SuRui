package com.myit.server.service.commodity.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.service.commodity.CommodityService;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = Logger.getLogger(CommodityServiceImpl.class);

    public SearchCommodityResp findCommodities(SearchCommodityReq commodityListReq) throws Exception {
        LOGGER.info("findCommodities IN");

        LOGGER.debug("commodityListReq=" + commodityListReq);

        SearchCommodityResp commodityListResp = new SearchCommodityResp();

        // TODO 从数据库中查询对应的商品

        commodityListResp.setRetCode(RetCode.SUCCESS);

        LOGGER.info("findCommodities OUT");
        return commodityListResp;
    }
}
