package com.myit.portal.action.bean;

import java.io.Serializable;

/**
 * 
 * 银联支付接口参数<br>
 * 跳转到银联支付页面
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QuickPayReq implements Serializable {

    /**
     */
    private static final long serialVersionUID = 861600681927755548L;

    // 交易类型
    String transType;

    // 原始交易流水号
    String origQid;

    // 商品URL
    String commodityUrl;

    // 商品名称
    String commodityName;

    // 商品单价 单位：分
    String commodityUnitPrice;

    // 商品数量
    String commodityQuantity;

    // 折扣 单位：分
    String commodityDiscount;

    // 运费 单位：分
    String transferFee;

    // 订单号（需要商户自己生成）
    String orderNumber;

    // 交易金额 单位：分
    String orderAmount;

    // 交易币种
    String orderCurrency;

    // 交易时间
    String orderTime;

    // 用户IP
    String customerIp;

    // 用户真实姓名
    String customerName;

    // 默认支付方式
    String defaultPayType;

    // 默认银行编号
    String defaultBankNumber;

    // 交易超时时间
    String transTimeout;

    // 前台回调商户URL
    String frontEndUrl;

    // 后台回调商户URL
    String backEndUrl;

    // 商户保留域
    String merReserved;

    public QuickPayReq() {
    }

}
