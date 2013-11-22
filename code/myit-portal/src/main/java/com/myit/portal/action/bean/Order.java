package com.myit.portal.action.bean;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    /**
     */
    private static final long serialVersionUID = -2559485756552235905L;

    // 订单id
    Long id;

    // 订单号码
    String orderNo;

    // 会员账户
    String memberNo;

    // 订单联系人
    String contact;

    // 联系人手机
    String mobile;

    // 配送地址
    String address;

    // 订单金额
    Double totalPrice;

    // 订单状态
    String status;

    // 订单行列表
    List<OrderItem> orderItems;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
