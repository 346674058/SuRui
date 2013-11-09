package com.myit.intf.bean.district;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class DistrictItem extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 行政区编码
    String districtCode;

    // 行政区名称
    String districtName;

    public DistrictItem() {
    }

    public DistrictItem(String districtCode, String districtName) {
        this.districtCode = districtCode;
        this.districtName = districtName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

}
