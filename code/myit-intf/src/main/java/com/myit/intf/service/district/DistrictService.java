package com.myit.intf.service.district;

import com.myit.intf.bean.district.DistrictReq;
import com.myit.intf.bean.district.DistrictResp;

public interface DistrictService {
    /**
     * 
     * 功能描述: <br>
     * 获取商品分类列表
     * 
     * @param req
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    DistrictResp getDistricts(DistrictReq req);
}
