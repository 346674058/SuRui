package com.myit.portal.action.bean;

import java.io.Serializable;

public class Supplier implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8491761251624784266L;

    /** 会员编号 **/
    private String supplierNo;

    // 会员昵称
    String name;

    // 手机
    String mobile;

    // 地址
    String address;

    public Supplier() {
    }

    /**
     * 对象实例化
     * 
     * @param name
     * @param mobile
     * @param address
     */
    public Supplier(String name, String mobile, String address) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
    }

    public String getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(String supplierNo) {
        this.supplierNo = supplierNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
