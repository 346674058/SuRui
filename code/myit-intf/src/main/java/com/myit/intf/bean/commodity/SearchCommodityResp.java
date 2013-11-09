package com.myit.intf.bean.commodity;

import java.io.Serializable;
import java.util.List;

import com.myit.common.beans.BaseModel;

/**
 * 
 * 订单详情查询请求类<br>
 * 记录订单详情查询请求参数，如订单号，是否需要鉴权等。
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SearchCommodityResp extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 当前页数
    private int pageNo;

    // 页面大小
    private int pageSize;

    // 总页数
    private int pageCount;

    // 总数
    private int total;

    // 结果集
    private List<CommodityItem> commodities;

    public SearchCommodityResp() {
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<CommodityItem> getCommodities() {
        return commodities;
    }

    public void setCommodities(List<CommodityItem> commodities) {
        this.commodities = commodities;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getId() ^ (this.getId() >>> 32));
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
        SearchCommodityResp other = (SearchCommodityResp) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommodityListResp [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageCount=" + pageCount
                + ", total=" + total + ", commodities.size=" + commodities.size() + "]";
    }

}
