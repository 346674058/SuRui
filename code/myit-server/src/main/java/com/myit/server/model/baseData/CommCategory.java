package com.myit.server.model.baseData;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 商品分类实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class CommCategory extends BaseModel implements Serializable {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    // 商品编码：供应商编码+分类编码+5位流水
    String categotyCode;

    // 商品名称
    String categotyName;

    public CommCategory() {
    }

    public CommCategory(String categotyCode, String categotyName) {
        this.categotyCode = categotyCode;
        this.categotyName = categotyName;
    }

    public String getCategotyCode() {
        return categotyCode;
    }

    public void setCategotyCode(String categotyCode) {
        this.categotyCode = categotyCode;
    }

    public String getCategotyName() {
        return categotyName;
    }

    public void setCategotyName(String categotyName) {
        this.categotyName = categotyName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categotyCode == null) ? 0 : categotyCode.hashCode());
        result = prime * result + ((categotyName == null) ? 0 : categotyName.hashCode());
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
        CommCategory other = (CommCategory) obj;
        if (categotyCode == null) {
            if (other.categotyCode != null)
                return false;
        } else if (!categotyCode.equals(other.categotyCode))
            return false;
        if (categotyName == null) {
            if (other.categotyName != null)
                return false;
        } else if (!categotyName.equals(other.categotyName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommCategory [categotyCode=" + categotyCode + ", categotyName=" + categotyName + "]";
    }

}
