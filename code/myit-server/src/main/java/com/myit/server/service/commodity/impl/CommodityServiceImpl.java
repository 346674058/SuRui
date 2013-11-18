package com.myit.server.service.commodity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.NumberConvert;
import com.myit.common.util.RetCode;
import com.myit.intf.bean.commodity.CommodityItem;
import com.myit.intf.bean.commodity.CommodityReq;
import com.myit.intf.bean.commodity.CommodityResp;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.service.commodity.CommodityService;
import com.myit.server.dao.commodity.CommodityDao;
import com.myit.server.model.commodity.Commodity;
import com.myit.server.model.provider.Provider;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = Logger.getLogger(CommodityServiceImpl.class);

    @Resource
    CommodityDao commodityDao;

    public SearchCommodityResp searchCommodities(SearchCommodityReq req) throws Exception {
        LOGGER.info("searchCommodities IN");

        LOGGER.debug("req=" + req);

        SearchCommodityResp searchCommodityResp = new SearchCommodityResp(req);

        // 查询总记录数
        int total = 0;
        try {
            total = commodityDao.getCommoditysCount(null, null);
            searchCommodityResp.setTotal(total);
        } catch (Exception e) {
            LOGGER.warn("getCommoditysCount failed", e);
        }

        if (total == 0) {
            LOGGER.warn("searchCommodities failed,total=" + total);

            searchCommodityResp.setRetCode(RetCode.SUCCESS);

            LOGGER.info("searchCommodities OUT");
            return searchCommodityResp;
        }

        // 查询当前页数据
        int star = req.getStart();
        int pageSize = req.getPageSize();

        // 从数据库中查询对应的商品
        List<CommodityItem> commoditiesTemp = null;
        try {
            List<Commodity> commodities = commodityDao.findCommodities(star, pageSize, null, null);

            // 转换结果
            if (commodities != null && commodities.size() > 0) {
                commoditiesTemp = getcommodityList(commodities);
            }
        } catch (Exception e) {
            LOGGER.warn("findCommodities failed", e);
        }

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
        LOGGER.info("getcommodityList IN");

        // 检查入参
        if (commodities == null) {
            LOGGER.warn("commodities is null");

            LOGGER.info("getcommodityList IN");
            return null;
        }

        List<CommodityItem> commodityItems = new ArrayList<CommodityItem>();

        for (Commodity commodity : commodities) {
            CommodityItem commodityItem = new CommodityItem();

            // 商品基本信息
            commodityItem.setComCode(commodity.getComId());
            commodityItem.setComName(commodity.getComName());

            // 供应商信息
            Provider provider = commodity.getProvider();

            // 无供应商商品不能售卖
            if (provider == null) {
                LOGGER.warn("provider is null, comId=" + commodity.getComId());

                continue;
            }

            commodityItem.setSupplierNo(provider.getProviderCode());
            commodityItem.setSupplyName(provider.getProviderName());
            commodityItem.setMobile(provider.getMobile());
            commodityItem.setAddress(provider.getAddress());

            // TODO 商品图片中取列表图片
            String imgUrl = null;
            commodityItem.setImg(imgUrl);

            // 商品价格和促销信息
            int price = NumberConvert.getRandomNumber(5, 20);
            commodityItem.setPrice(new Double(price));

            commodityItems.add(commodityItem);
        }

        LOGGER.info("getcommodityList IN");
        return commodityItems;
    }

    public CommodityResp getCommodity(CommodityReq commodityReq) throws Exception {
        LOGGER.info("getCommodity IN");
        
        LOGGER.debug("commodityReq="+commodityReq);
        
        //根据商品编码查询商品
       Commodity commodity= commodityDao.findCommodityByComCode(commodityReq.getComCode());
        
       CommodityResp commodityResp= initCommodityResp(commodity);
       
        // TODO Auto-generated method stub
        LOGGER.info("getCommodity OUT");
        return commodityResp;
    }

    private CommodityResp initCommodityResp(Commodity commodity) {
        // TODO Auto-generated method stub
        return null;
    }
}
