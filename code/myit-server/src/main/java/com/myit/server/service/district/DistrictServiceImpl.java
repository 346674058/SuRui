package com.myit.server.service.district;

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
import com.myit.intf.bean.district.DistrictItem;
import com.myit.intf.bean.district.DistrictReq;
import com.myit.intf.bean.district.DistrictResp;
import com.myit.intf.service.cache.RedisService;
import com.myit.intf.service.district.DistrictService;
import com.myit.server.util.Constant;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService {

    private static final Logger LOGGER = Logger.getLogger(DistrictServiceImpl.class);

    // 缓存一天
    private static final int SECOND_DAY = 86400;

    @Resource
    RedisService redisService;

    public DistrictResp getDistricts(DistrictReq req) {
        LOGGER.info("getDistricts IN");

        DistrictResp districtResp = new DistrictResp();

        List<DistrictItem> districtList = null;

        String districtKey = Constant.cacheKey.get("District");

        // 从redis中获取缓存数据
        String cacheDate = redisService.get(districtKey);

        LOGGER.debug("cacheDate=" + cacheDate);

        Gson gson = new Gson();
        Type type = new TypeToken<List<Object>>() {
        }.getType();

        // 有缓存数据
        if (!StringConvert.isEmpty(cacheDate)) {
            LOGGER.debug("find cache data from redis");

            // 转换成对象列表
            districtList = gson.fromJson(cacheDate, type);

            districtResp.setDistrictItems(districtList);
            districtResp.setRetCode(RetCode.SUCCESS);

            LOGGER.debug("districtResp=" + districtResp);

            LOGGER.info("getDistricts OUT");
            return districtResp;
        }

        // 访问数据库，查询行政区列表
        List<DistrictItem> districtListTemp = new ArrayList<DistrictItem>();
        districtListTemp.add(new DistrictItem("001", "鼓楼区"));
        districtListTemp.add(new DistrictItem("002", "玄武区"));
        districtListTemp.add(new DistrictItem("003", "仙林区"));
        districtListTemp.add(new DistrictItem("004", "栖霞区"));
        districtListTemp.add(new DistrictItem("005", "秦淮区"));

        // 如果结果列表长度大于0，转换成gson字符串，存入redis
        if (districtListTemp != null && districtListTemp.size() > 0) {
            // 转换成gson字符串
            cacheDate = gson.toJson(districtListTemp);

            // 添加到redis缓存
            redisService.set(districtKey, cacheDate, SECOND_DAY);

            districtResp.setDistrictItems(districtListTemp);
            districtResp.setRetCode(RetCode.SUCCESS);
        }

        LOGGER.debug("districtResp=" + districtResp);

        LOGGER.info("getCommodityCategorys OUT");
        return districtResp;
    }

}
