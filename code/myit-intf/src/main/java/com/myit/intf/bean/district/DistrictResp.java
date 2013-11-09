package com.myit.intf.bean.district;

import java.util.List;

import com.myit.common.beans.BaseModel;

public class DistrictResp extends BaseModel {

    /**
     */
    private static final long serialVersionUID = -332611695602071846L;

    List<DistrictItem> districtItems;

    public DistrictResp() {
    }

    public List<DistrictItem> getDistrictItems() {
        return districtItems;
    }

    public void setDistrictItems(List<DistrictItem> districtItems) {
        this.districtItems = districtItems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((districtItems == null) ? 0 : districtItems.hashCode());
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
        DistrictResp other = (DistrictResp) obj;
        if (districtItems == null) {
            if (other.districtItems != null)
                return false;
        } else if (!districtItems.equals(other.districtItems))
            return false;
        return true;
    }

    @Override
    public String toString() {
        int size = 0;
        if (districtItems != null) {
            size = districtItems.size();
        }

        return "CommCategoryResp [retCode=" + getRetCode() + ", categoryItems.size=" + size + "]";
    }
}
