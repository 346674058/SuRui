package com.myit.portal.action.bean;

import java.io.Serializable;

public class Commodity implements Serializable {

    /**
     */
    private static final long serialVersionUID = 9166253118509092887L;

    // 商品编码
    String comCode;

    // 商品名称
    String comName;

    // 商品图片
    String img;

    // 商品价格
    Double price;

    // 优惠价格
    Double promotionPrice;

    // 剩余份数
    int countRemain;

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

}
