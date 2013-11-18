package com.myit.portal.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myit.common.util.RetCode;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.commCategory.CommCategoryReq;
import com.myit.intf.bean.commCategory.CommCategoryResp;
import com.myit.intf.bean.commodity.CommodityItem;
import com.myit.intf.bean.commodity.CommodityReq;
import com.myit.intf.bean.commodity.CommodityResp;
import com.myit.intf.bean.commodity.SearchCommodityReq;
import com.myit.intf.bean.commodity.SearchCommodityResp;
import com.myit.intf.bean.district.DistrictReq;
import com.myit.intf.bean.district.DistrictResp;
import com.myit.intf.service.commCategory.CommCategoryService;
import com.myit.intf.service.commodity.CommodityService;
import com.myit.intf.service.district.DistrictService;
import com.myit.portal.action.bean.Commodity;
import com.myit.portal.action.bean.Supplier;
import com.myit.portal.util.Constant;

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

    @Resource
    DistrictService districtService;

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

        // 从缓存中取出所有商品分类列表
        CommCategoryReq commCategoryReq = new CommCategoryReq();

        CommCategoryResp commCategoryResp = null;
        try {
            commCategoryResp = commCategoryService.getCommCategories(commCategoryReq);
        } catch (Exception e) {
            LOGGER.warn("getCommCategories failed,commCategoryReq=" + commCategoryReq, e);
        }

        LOGGER.debug("commCategoryResp=" + commCategoryResp);

        // 查询成功
        if (commCategoryResp != null && RetCode.SUCCESS.equals(commCategoryResp.getRetCode())) {
            model.addAttribute("categories", commCategoryResp.getCategoryItems());
        }

        // 从缓存中取出当前城市区域列表
        DistrictReq districtReq = new DistrictReq();
        DistrictResp districtResp = null;
        try {
            districtResp = districtService.getDistricts(districtReq);
        } catch (Exception e) {
            LOGGER.warn("getDistricts failed,districtReq=" + districtReq, e);
        }

        LOGGER.debug("districtResp=" + districtResp);

        // 查询成功
        if (districtResp != null && RetCode.SUCCESS.equals(districtResp.getRetCode())) {
            model.addAttribute("districts", districtResp.getDistrictItems());
        }

        LOGGER.info("search OUT");
        return "commodity/search.ftl";
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

        SearchCommodityReq searchCommodityReq = new SearchCommodityReq();

        // 初始化请求参数
        initParam(searchCommodityReq, request);

        SearchCommodityResp searchCommodityResp = null;
        try {
            // 搜索商品列表
            searchCommodityResp = commodityService.searchCommodities(searchCommodityReq);
        } catch (Exception e) {
            LOGGER.warn("searchCommodities failed", e);
        }

        LOGGER.debug("searchCommodityResp=" + searchCommodityResp);

        List<Commodity> commodities = null;

        int pageNo = 0;
        int pageCount = 0;
        int totalCount = 0;

        // 搜索成功
        if (searchCommodityResp != null && RetCode.SUCCESS.equals(searchCommodityResp.getRetCode())) {
            // 转换结果集
            if (searchCommodityResp.getCommodities() != null) {
                commodities = getCommodityList(searchCommodityResp.getCommodities());
            }

            pageNo = searchCommodityResp.getPageNo();
            pageCount = searchCommodityResp.getPageCount();
            totalCount = searchCommodityResp.getTotal();
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
    private void initParam(SearchCommodityReq searchCommodityReq, HttpServletRequest request) {
        // 商品分类
        String category = getParam("category", request);
        searchCommodityReq.setCategory(category);

        // 价格区间
        String priceRange = getParam("priceRange", request);
        searchCommodityReq.setPriceRange(priceRange);

        // 配送区域
        String dispatchArea = getParam("dispatchArea", request);
        searchCommodityReq.setDispatchArea(dispatchArea);

        // 关键字
        String keywords = getParam("keywords", request);
        searchCommodityReq.setKeywords(keywords);

        // 页面大小
        searchCommodityReq.setPageSize(10);

        // 当前页号
        int pageNo = 0;
        String pageNoStr = getParam("pageNo", request);
        if (!StringConvert.isEmpty(pageNoStr)) {
            try {
                pageNo = Integer.parseInt(pageNoStr);
            } catch (Exception e) {
                LOGGER.warn("parseInt failed,pageNoStr=" + pageNoStr, e);
            }
        }

        searchCommodityReq.setPageNo(pageNo);
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
    private List<Commodity> getCommodityList(List<CommodityItem> commodityItems) {
        LOGGER.info("getcommodityList IN");

        // 检查入参
        if (commodityItems == null) {
            LOGGER.warn("commodities is null");

            LOGGER.info("getcommodityList IN");
            return null;
        }

        List<Commodity> commodities = new ArrayList<Commodity>();

        for (CommodityItem commodityItem : commodityItems) {
            Commodity commodity = new Commodity();

            // 商品基本信息
            commodity.setComCode(commodityItem.getComCode());
            commodity.setComName(commodityItem.getComName());

            // 供应商信息
            Supplier supplier = new Supplier(commodityItem.getSupplyName(), commodityItem.getMobile(),
                    commodityItem.getAddress());
            commodity.setSupplier(supplier);

            // 商品价格和促销信息
            commodity.setPrice(commodityItem.getPrice());

            // 库存信息
            commodity.setCountRemain(100);

            commodities.add(commodity);
        }

        LOGGER.info("getcommodityList OUT");
        return commodities;
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
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/shoppingCart")
    public String shoppingCart(Model model, HttpServletRequest request) {
        LOGGER.info("shoppingCart IN");

        // 从session中获取购物车内容
        List<Commodity> commodities = null;
        try {
            commodities = (List<Commodity>) request.getSession().getAttribute(Constant.SHOPPING_CART);

            // 是否有新商品需要添加到购物车
            String comCode = getParam("comCode", request);
            if (!StringConvert.isEmpty(comCode)) {
                // 根据商品编码查询商品，添加到购物车列表
                CommodityReq commodityReq = new CommodityReq();
                commodityReq.setComCode(comCode);

                CommodityResp commodityResp = commodityService.getCommodity(commodityReq);

                // 转换成购物车商品
                Commodity commodity = getCommodity(commodityResp);
                // 初始化列表
                if (commodities == null) {
                    commodities = new ArrayList<Commodity>();
                }

                // 新商品添加到购物车
                add2ShoppingCart(commodities, commodity);
            }
        } catch (Exception e) {
            LOGGER.warn("shopping cart is null", e);
        }

        model.addAttribute("commodities", commodities);

        LOGGER.info("shoppingCart OUT");
        return "commodity/shoppingCart.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 添加商品到购物车，同种商品数量做+1处理
     * 
     * @param commodity
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void add2ShoppingCart(List<Commodity> commodities, Commodity commodity) {
        LOGGER.info("add2ShoppingCart IN");
        
        if (commodities==null) {
            commodities=new ArrayList<Commodity>();
            
            commodities.add(commodity);
            LOGGER.info("add2ShoppingCart OUT");
            
            return;
        }

        LOGGER.info("add2ShoppingCart OUT");
    }

    /**
     * 
     * 功能描述: <br>
     * 转换查询结果为购物车商品
     * 
     * @param commodityResp
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Commodity getCommodity(CommodityResp commodityResp) {
        // TODO Auto-generated method stub
        return null;
    }
}
