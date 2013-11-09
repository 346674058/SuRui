package com.myit.server.service.commodityCategory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.commCategory.CommCategoryReq;
import com.myit.intf.bean.commCategory.CommCategoryResp;
import com.myit.intf.service.cache.RedisService;
import com.myit.intf.service.commCategory.CommCategoryService;
import com.myit.server.util.Constant;

@Service("CommodityCategoryService")
public class CommodityCategoryServiceImpl implements CommCategoryService {

    private static final Logger LOGGER = Logger.getLogger(CommodityCategoryServiceImpl.class);

    // 缓存一天
    private static final int SECOND_DAY = 86400;

    @Resource
    RedisService redisService;

    public CommCategoryResp getCommodityCategorys(CommCategoryReq req) {
        LOGGER.info("getCommodityCategorys IN");

        CommCategoryResp categoryResp = null;

        List<Object> categoryList = null;

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

            LOGGER.info("getCommodityCategorys OUT");
            return categoryResp;
        }

        // 访问数据库，查询商品分类列表
        List<Object> categoryListTemp = new ArrayList<Object>();

        // 如果结果列表长度大于0，转换成gson字符串，存入redis
        if (categoryListTemp != null && categoryListTemp.size() > 0) {
            // 转换成gson字符串
            cacheDate = gson.toJson(categoryListTemp);

            // 添加到redis缓存
            redisService.set(commCateKey, cacheDate, SECOND_DAY);
        }

        categoryList = categoryListTemp;

        LOGGER.info("getCommodityCategorys OUT");
        return categoryResp;
    }

}
