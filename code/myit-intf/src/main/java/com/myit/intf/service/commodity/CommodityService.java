package com.myit.intf.service.commodity;

import com.myit.intf.bean.commodity.CommodityReq;
import com.myit.intf.bean.commodity.CommodityResp;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;

/**
 * 商品管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface CommodityService {

    /**
     * 
     * 功能描述: <br>
     * 分页查询商品列表
     * 
     * @param commodityListReq
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    SearchCommodityResp searchCommodities(SearchCommodityReq searchCommodityReq) throws Exception;

    /**
     * 功能描述: <br>
     * 查询商品实体
     * 
     * @param commodityReq
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CommodityResp getCommodity(CommodityReq commodityReq) throws Exception;
}
