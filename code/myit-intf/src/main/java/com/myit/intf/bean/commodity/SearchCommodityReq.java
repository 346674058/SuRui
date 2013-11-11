package com.myit.intf.bean.commodity;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 
 * 商品预定请求实体类<br>
 * 〈功能详细描述〉
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SearchCommodityReq extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 商品分类
    private String category;

    // 价格区间
    private String priceRange;

    // 配送区域
    private String dispatchArea;

    // 关键字
    private String keywords;

    // 当前页数
    private int pageNo;

    // 页面大小
    private int pageSize;

    public SearchCommodityReq() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getDispatchArea() {
        return dispatchArea;
    }

    public void setDispatchArea(String dispatchArea) {
        this.dispatchArea = dispatchArea;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getPageNo() {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }

    public int getStart() {
        return (getPageNo() - 1) * getPageSize();
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((dispatchArea == null) ? 0 : dispatchArea.hashCode());
        result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
        result = prime * result + pageNo;
        result = prime * result + pageSize;
        result = prime * result + ((priceRange == null) ? 0 : priceRange.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SearchCommodityReq other = (SearchCommodityReq) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (dispatchArea == null) {
            if (other.dispatchArea != null)
                return false;
        } else if (!dispatchArea.equals(other.dispatchArea))
            return false;
        if (keywords == null) {
            if (other.keywords != null)
                return false;
        } else if (!keywords.equals(other.keywords))
            return false;
        if (pageNo != other.pageNo)
            return false;
        if (pageSize != other.pageSize)
            return false;
        if (priceRange == null) {
            if (other.priceRange != null)
                return false;
        } else if (!priceRange.equals(other.priceRange))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommodityListReq [category=" + category + ", priceRange=" + priceRange + ", dispatchArea="
                + dispatchArea + ", keywords=" + keywords + ", pageNo=" + pageNo + ", pageSize=" + pageSize
                + ", appCode=" + getAppCode() + "]";
    }

}
