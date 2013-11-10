package com.myit.server.model.commodity;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

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
    String comId;

    // 商品名称
    String comName;

    // 供应商id
    Long providerId;

    // 商品分类id
    Long categoryId;

    // 商品描述
    String comDescribe;

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

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCatagoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getComDescribe() {
        return comDescribe;
    }

    public void setComDescribe(String comDescribe) {
        this.comDescribe = comDescribe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
        result = prime * result + ((comDescribe == null) ? 0 : comDescribe.hashCode());
        result = prime * result + ((comId == null) ? 0 : comId.hashCode());
        result = prime * result + ((comName == null) ? 0 : comName.hashCode());
        result = prime * result + ((providerId == null) ? 0 : providerId.hashCode());
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
        if (categoryId == null) {
            if (other.categoryId != null)
                return false;
        } else if (!categoryId.equals(other.categoryId))
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
        if (providerId == null) {
            if (other.providerId != null)
                return false;
        } else if (!providerId.equals(other.providerId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Commodity [comId=" + comId + ", comName=" + comName + ", providerId=" + providerId + ", categoryId="
                + categoryId + ", comDescribe=" + comDescribe + "]";
    }

}
