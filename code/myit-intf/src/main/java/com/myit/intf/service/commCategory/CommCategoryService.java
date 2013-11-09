package com.myit.intf.service.commCategory;

import com.myit.intf.bean.commCategory.CommCategoryReq;
import com.myit.intf.bean.commCategory.CommCategoryResp;

public interface CommCategoryService {
    /**
     * 
     * 功能描述: <br>
     * 获取城市行政区列表
     * 
     * @param req
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CommCategoryResp getCommCategories(CommCategoryReq req);
}
