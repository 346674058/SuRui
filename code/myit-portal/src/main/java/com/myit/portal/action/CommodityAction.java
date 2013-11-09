package com.myit.portal.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.commCategory.CommCategoryReq;
import com.myit.intf.bean.commCategory.CommCategoryResp;
import com.myit.intf.bean.commodity.CommodityItem;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.service.commCategory.CommCategoryService;
import com.myit.intf.service.commodity.CommodityService;
import com.myit.portal.action.bean.Commodity;
import com.myit.portal.action.bean.CommodityCategory;

/**
 * 
 * 商品查询控制类<br>
 * 商品查询，添加到购物车
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/commodity")
public class CommodityAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(CommodityAction.class);

    @Resource
    CommodityService commodityService;

    @Resource
    CommCategoryService commCategoryService;

    /**
     * 
     * 功能描述: <br>
     * 跳转到查询列表页面
     * 
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/search")
    public String search(Model model, HttpServletRequest request) {
        LOGGER.info("search IN");

        // 查询参数，返回到页面上，ajax表单提交做数据查询

        // 从缓存中取出所有商品分类列表
        CommCategoryReq commCategoryReq = new CommCategoryReq();
        CommCategoryResp commCategoryResp = commCategoryService.getCommodityCategorys(commCategoryReq);

        LOGGER.info("search OUT");
        return "commodity/search.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 获取缓存数据
     * 
     * @param string
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Object getCacheData(String string) {
        List<CommodityCategory> categories = new ArrayList<CommodityCategory>();

        // TODO 测试数据
        categories.add(new CommodityCategory("001", "商务套餐A"));
        categories.add(new CommodityCategory("002", "商务套餐B"));
        categories.add(new CommodityCategory("003", "商务套餐C"));
        categories.add(new CommodityCategory("004", "商务套餐D"));
        categories.add(new CommodityCategory("005", "商务套餐E"));

        return categories;
    }

    /**
     * 
     * 功能描述: <br>
     * ajax查询商品列表
     * 
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request) {
        LOGGER.info("list IN");

        SearchCommodityReq commodityListReq = new SearchCommodityReq();

        // 初始化请求参数
        initParam(commodityListReq, request);

        SearchCommodityResp commodityListResp = null;
        try {
            // 搜索商品列表
            commodityListResp = commodityService.findCommodities(commodityListReq);
        } catch (Exception e) {
            LOGGER.warn("findCommodities failed", e);
        }

        LOGGER.debug("commodityListResp=" + commodityListResp);

        List<Commodity> commodities = null;

        int pageNo = 0;
        int pageCount = 0;
        int totalCount = 0;

        // 搜索成功
        if (commodityListResp != null && RetCode.SUCCESS.equals(commodityListResp.getRetCode())) {
            // 转换结果集
            if (commodityListResp.getCommodities() != null) {
                commodities = getCommodityList(commodityListResp.getCommodities());
            }

            pageNo = commodityListResp.getPageNo();
            pageCount = commodityListResp.getPageCount();
            totalCount = commodityListResp.getTotal();
        }

        // 搜索无结果
        if (commodities == null) {
            LOGGER.warn("commodities is null");
        }

        model.addAttribute("commodities", commodities);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("totalCount", totalCount);

        LOGGER.info("list OUT");
        return "commodity/list.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 初始化查询参数
     * 
     * @param commodityListReq
     * @param request
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void initParam(SearchCommodityReq commodityListReq, HttpServletRequest request) {
        // 商品分类
        String category = getParam("category", request);
        commodityListReq.setCategory(category);

        // 价格区间
        String priceRange = getParam("priceRange", request);
        commodityListReq.setPriceRange(priceRange);

        // 配送区域
        String dispatchArea = getParam("dispatchArea", request);
        commodityListReq.setDispatchArea(dispatchArea);

        // 关键字
        String keywords = getParam("keywords", request);
        commodityListReq.setKeywords(keywords);

    }

    /**
     * 
     * 功能描述: <br>
     * 转换商品列表结果集
     * 
     * @param commodities
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<Commodity> getCommodityList(List<CommodityItem> commodities) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 跳转到购物车页面
     * 
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/shoppingCart")
    public String shoppingCart(Model model, HttpServletRequest request) {
        LOGGER.info("shoppingCart IN");

        // 查询参数，返回到页面上，ajax表单提交做数据查询

        List<Commodity> commodities = new ArrayList<Commodity>();

        // TODO 演示数据
        for (int commodities_i = 0; commodities_i < 10; commodities_i++) {

            // 商品
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new BigDecimal(9.50), new BigDecimal(0.50));

            // 剩余份数
            commodity.setCountRemain(1);

            commodities.add(commodity);
        }

        model.addAttribute("commodities", commodities);

        LOGGER.info("shoppingCart OUT");
        return "commodity/shoppingCart.ftl";
    }
}
