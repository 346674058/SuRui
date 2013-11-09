package com.myit.portal.action.bean;

import java.io.Serializable;

public class CommodityCategory implements Serializable {

    /**
     */
    private static final long serialVersionUID = 9166253118509092887L;

    // 商品分类编码
    String categoryCode;

    // 商品分类名称
    String categoryName;

    public CommodityCategory() {
    }

    /**
     * 带参数构造函数
     * 
     * @param categoryCode 分类代码
     * @param categoryName 分类名称
     */
    public CommodityCategory(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

}
