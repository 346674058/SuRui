package com.myit.server.model.bill;

import java.io.Serializable;
import java.math.BigDecimal;

import com.myit.common.beans.BaseModel;

/**
 * 订单物品实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class OrderCommo extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 订单Id
     */
    private Long orderId;
    /**
     * 订单Id
     */
    private Long commoId;

    /**
     * 商品名称
     */
    private String commoName;

    /** 单价 **/
    private BigDecimal sellPrice;

    /** 结算价 **/
    private BigDecimal settlePrice;

    /** 商品数量 **/
    private Integer commoAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCommoId() {
        return commoId;
    }

    public void setCommoId(Long commoId) {
        this.commoId = commoId;
    }

    public String getCommoName() {
        return commoName;
    }

    public void setCommoName(String commoName) {
        this.commoName = commoName;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getSettlePrice() {
        return settlePrice;
    }

    public void setSettlePrice(BigDecimal settlePrice) {
        this.settlePrice = settlePrice;
    }

    public Integer getCommoAmount() {
        return commoAmount;
    }

    public void setCommoAmount(Integer commoAmount) {
        this.commoAmount = commoAmount;
    }

    @Override
    public String toString() {
        return "OrderCommo [orderId=" + orderId + ", commoId=" + commoId + ", commoName=" + commoName + ", sellPrice="
                + sellPrice + ", settlePrice=" + settlePrice + ", commoAmount=" + commoAmount + "]";
    }
}
