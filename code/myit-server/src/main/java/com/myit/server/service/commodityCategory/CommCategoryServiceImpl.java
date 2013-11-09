package com.myit.server.service.commCategory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myit.common.util.RetCode;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.commCategory.CategoryItem;
import com.myit.intf.bean.commCategory.CommCategoryReq;
import com.myit.intf.bean.commCategory.CommCategoryResp;
import com.myit.intf.service.cache.RedisService;
import com.myit.intf.service.commCategory.CommCategoryService;
import com.myit.server.util.Constant;

@Service("commCategoryService")
public class CommCategoryServiceImpl implements CommCategoryService {

    private static final Logger LOGGER = Logger.getLogger(CommCategoryServiceImpl.class);

    // 缓存一天
    private static final int SECOND_DAY = 86400;

    @Resource
    RedisService redisService;

    public CommCategoryResp getCommCategories(CommCategoryReq commCategoryReq) {
        LOGGER.info("getCommCategories IN");

        LOGGER.debug("commCategoryReq=" + commCategoryReq);

        CommCategoryResp categoryResp = new CommCategoryResp();

        List<CategoryItem> categoryList = null;

        String commCateKey = Constant.cacheKey.get("CommodityCategory");

        // 从redis中获取缓存数据
        String cacheDate = redisService.get(commCateKey);

        LOGGER.debug("cacheDate=" + cacheDate);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();

        // 有缓存数据
        if (!StringConvert.isEmpty(cacheDate)) {
            LOGGER.debug("find cache data from redis");

            // 转换成对象列表
            categoryList = gson.fromJson(cacheDate, type);

            categoryResp.setCategoryItems(categoryList);
            categoryResp.setRetCode(RetCode.SUCCESS);

            LOGGER.debug("categoryResp=" + categoryResp);

            LOGGER.info("getCommCategories OUT");
            return categoryResp;
        }

        // 访问数据库，查询商品分类列表
        List<CategoryItem> categoryListTemp = new ArrayList<CategoryItem>();
        categoryListTemp.add(new CategoryItem("001", "商务套餐A"));
        categoryListTemp.add(new CategoryItem("002", "商务套餐B"));
        categoryListTemp.add(new CategoryItem("003", "商务套餐C"));
        categoryListTemp.add(new CategoryItem("004", "商务套餐D"));
        categoryListTemp.add(new CategoryItem("005", "商务套餐E"));

        // 如果结果列表长度大于0，转换成gson字符串，存入redis
        if (categoryListTemp != null && categoryListTemp.size() > 0) {
            // 转换成gson字符串
            cacheDate = gson.toJson(categoryListTemp);

            // 添加到redis缓存
            redisService.set(commCateKey, cacheDate, SECOND_DAY);

            categoryResp.setCategoryItems(categoryListTemp);
            categoryResp.setRetCode(RetCode.SUCCESS);
        }

        LOGGER.debug("categoryResp=" + categoryResp);

        LOGGER.info("getCommCategories OUT");
        return categoryResp;
    }

}
