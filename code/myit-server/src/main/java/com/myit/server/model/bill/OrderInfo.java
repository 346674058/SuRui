package com.myit.server.model.bill;

import java.io.Serializable;
import java.math.BigDecimal;

import com.myit.common.beans.BaseModel;

/**
 * 订单实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class OrderInfo extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 会员编号 **/
    private String memberNo;

    /** 订单编号 **/
    private String orderNo;

    /** 联系人 **/
    private String contactName;

    /** 联系人 手机 **/
    private String mobile;

    /** 联系人 手机 **/
    private String email;

    /** 省份ID **/
    private Long provinceId;

    /** 城市ID **/
    private Long cityId;

    /** 区县ID **/
    private Long countyId;

    /** 详细地址 **/
    private String address;

    /** 订单总金额 **/
    private BigDecimal sellAmount;

    /** 订单结算金额 **/
    private BigDecimal settleAmount;

    public OrderInfo() {
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(BigDecimal sellAmount) {
        this.sellAmount = sellAmount;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    @Override
    public String toString() {
        return "OrderInfo [memberNo=" + memberNo + ", orderNo=" + orderNo + ", contactName=" + contactName
                + ", mobile=" + mobile + ", email=" + email + ", provinceId=" + provinceId + ", cityId=" + cityId
                + ", countyId=" + countyId + ", address=" + address + ", sellAmount=" + sellAmount + ", settleAmount="
                + settleAmount + ", createTime" + getCreateTime() + "]";
    }

}
