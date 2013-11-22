package com.myit.portal.action.bean;

import java.io.Serializable;

public class Commodity implements Serializable {

    /**
     */
    private static final long serialVersionUID = 9166253118509092887L;

    // 商品编码
    private String comCode;

    // 商品名称
    private String comName;

    // 商品图片
    private String img;

    // 商品价格
    private Double price;

    // 优惠价格
    private Double promotionPrice;

    // 小计金额
    private Double subTotalPrice;

    // 剩余份数
    private int countRemain;

    // 预订份数
    private int bookCount;

    Supplier supplier;

    public Commodity() {
        // TODO Auto-generated constructor stub
    }

    public Commodity(String comCode, String comName, String img, Double price, Double promotionPrice) {
        this.comCode = comCode;
        this.comName = comName;
        this.img = img;
        this.price = price;
        this.promotionPrice = promotionPrice;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public Double getSubTotalPrice() {
        subTotalPrice = getPrice() * getBookCount();

        return subTotalPrice;
    }

    public void setSubTotalPrice(Double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public int getCountRemain() {
        return countRemain;
    }

    public void setCountRemain(int countRemain) {
        this.countRemain = countRemain;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comCode == null) ? 0 : comCode.hashCode());
        result = prime * result + ((comName == null) ? 0 : comName.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
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
        Commodity other = (Commodity) obj;
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
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

}
