package com.myit.server.model.commodity;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;
import com.myit.server.model.baseData.CommCategory;
import com.myit.server.model.provider.Provider;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class Commodity extends BaseModel implements Serializable {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    // 商品编码：供应商编码+分类编码+5位流水
    private String comId;

    // 商品名称
    private String comName;

    // 供应商id
    private Provider provider;

    // 商品分类id
    private CommCategory commCategory;

    // 商品描述
    private String comDescribe;

    // 商品底价
    private Double basePrice;
    // 商品售价
    private Double salePrice;

    public Commodity() {
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public CommCategory getCommCategory() {
        return commCategory;
    }

    public void setCommCategory(CommCategory commCategory) {
        this.commCategory = commCategory;
    }

    public String getComDescribe() {
        return comDescribe;
    }

    public void setComDescribe(String comDescribe) {
        this.comDescribe = comDescribe;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((commCategory == null) ? 0 : commCategory.hashCode());
        result = prime * result + ((comDescribe == null) ? 0 : comDescribe.hashCode());
        result = prime * result + ((comId == null) ? 0 : comId.hashCode());
        result = prime * result + ((comName == null) ? 0 : comName.hashCode());
        result = prime * result + ((provider == null) ? 0 : provider.hashCode());
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
        Commodity other = (Commodity) obj;
        if (commCategory == null) {
            if (other.commCategory != null)
                return false;
        } else if (!commCategory.equals(other.commCategory))
            return false;
        if (comDescribe == null) {
            if (other.comDescribe != null)
                return false;
        } else if (!comDescribe.equals(other.comDescribe))
            return false;
        if (comId == null) {
            if (other.comId != null)
                return false;
        } else if (!comId.equals(other.comId))
            return false;
        if (comName == null) {
            if (other.comName != null)
                return false;
        } else if (!comName.equals(other.comName))
            return false;
        if (provider == null) {
            if (other.provider != null)
                return false;
        } else if (!provider.equals(other.provider))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Commodity [comId=" + comId + ", comName=" + comName + ", provider=" + provider + ", commCategory="
                + commCategory + ", comDescribe=" + comDescribe + ", basePrice=" + basePrice + ", salePrice="
                + salePrice + "]";
    }

}
