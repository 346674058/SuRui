package com.myit.portal.action.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {

    /**
     */
    private static final long serialVersionUID = 747744742795506671L;

    // 订单行id
    Long id;

    // 商品
    Commodity commodity;

    // 预定数量
    int count;

    // 金额小计
    BigDecimal subTotal;

    public OrderItem() {
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
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

}
