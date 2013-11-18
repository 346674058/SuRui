package com.myit.intf.bean.commodity;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class CommodityResp extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 商品编码
    String comCode;

    // 商品名称
    String comName;

    // 商品图片
    String img;

    // 商品价格
    Double price;

    // 预定数量
    int count;

    // ------
    // 金额小计
    BigDecimal subTotal;

    // 优惠金额
    BigDecimal promotionPrice;

    // ------
    // 供应商编码
    String supplierNo;

    // 供应商名称
    String supplyName;

    // 供应商手机
    String mobile;

    // 供应商地址
    String address;

    public CommodityResp() {
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((comCode == null) ? 0 : comCode.hashCode());
        result = prime * result + ((comName == null) ? 0 : comName.hashCode());
        result = prime * result + count;
        result = prime * result + ((img == null) ? 0 : img.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((promotionPrice == null) ? 0 : promotionPrice.hashCode());
        result = prime * result + ((subTotal == null) ? 0 : subTotal.hashCode());
        result = prime * result + ((supplierNo == null) ? 0 : supplierNo.hashCode());
        result = prime * result + ((supplyName == null) ? 0 : supplyName.hashCode());
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
        CommodityResp other = (CommodityResp) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (comCode == null) {
            if (other.comCode != null)
                return false;
        } else if (!comCode.equals(other.comCode))
            return false;
        if (comName == null) {
            if (other.comName != null)
                return false;
        } else if (!comName.equals(other.comName))
            return false;
        if (count != other.count)
            return false;
        if (img == null) {
            if (other.img != null)
                return false;
        } else if (!img.equals(other.img))
            return false;
        if (mobile == null) {
            if (other.mobile != null)
                return false;
        } else if (!mobile.equals(other.mobile))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (promotionPrice == null) {
            if (other.promotionPrice != null)
                return false;
        } else if (!promotionPrice.equals(other.promotionPrice))
            return false;
        if (subTotal == null) {
            if (other.subTotal != null)
                return false;
        } else if (!subTotal.equals(other.subTotal))
            return false;
        if (supplierNo == null) {
            if (other.supplierNo != null)
                return false;
        } else if (!supplierNo.equals(other.supplierNo))
            return false;
        if (supplyName == null) {
            if (other.supplyName != null)
                return false;
        } else if (!supplyName.equals(other.supplyName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CommodityResp [comCode=" + comCode + ", comName=" + comName + ", img=" + img + ", price=" + price
                + ", count=" + count + ", subTotal=" + subTotal + ", promotionPrice=" + promotionPrice
                + ", supplierNo=" + supplierNo + ", supplyName=" + supplyName + ", mobile=" + mobile + ", address="
                + address + "]";
    }

}
