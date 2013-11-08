package com.myit.server.service.commodity.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.commodity.CommodityListReq;
import com.myit.intf.bean.commodity.CommodityListResp;
import com.myit.intf.service.commodity.CommodityService;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = Logger.getLogger(CommodityServiceImpl.class);

    public CommodityListResp findCommodities(CommodityListReq commodityListReq) throws Exception {
        LOGGER.info("findCommodities IN");

        LOGGER.debug("commodityListReq=" + commodityListReq);

        CommodityListResp commodityListResp = new CommodityListResp();

        // TODO 从数据库中查询对应的商品

        commodityListResp.setRetCode(RetCode.SUCCESS);

        LOGGER.info("findCommodities OUT");
        return commodityListResp;
    }
}
