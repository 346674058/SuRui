package com.myit.intf.bean.commCategory;

import java.util.List;

import com.myit.common.beans.BaseModel;

public class CommCategoryResp extends BaseModel {

    /**
     */
    private static final long serialVersionUID = -332611695602071846L;

    List<CategoryItem> categoryItems;

    public CommCategoryResp() {
    }

    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryItems == null) ? 0 : categoryItems.hashCode());
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
        CommCategoryResp other = (CommCategoryResp) obj;
        if (categoryItems == null) {
            if (other.categoryItems != null)
                return false;
        } else if (!categoryItems.equals(other.categoryItems))
            return false;
        return true;
    }

    @Override
    public String toString() {
        int size = 0;
        if (categoryItems != null) {
            size = categoryItems.size();
        }

        return "CommCategoryResp [retCode=" + getRetCode() + ", categoryItems.size=" + size + "]";
    }
}
