package com.myit.intf.bean.commodity;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 
 * 商品查询请求实体类<br>
 * 〈功能详细描述〉
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CommodityReq extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 商品编码
    private String comCode;

    public CommodityReq() {
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comCode == null) ? 0 : comCode.hashCode());
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
        CommodityReq other = (CommodityReq) obj;
        if (comCode == null) {
            if (other.comCode != null)
                return false;
        } else if (!comCode.equals(other.comCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommodityReq [comCode=" + comCode + ", appCode=" + getAppCode() + "]";
    }

}
