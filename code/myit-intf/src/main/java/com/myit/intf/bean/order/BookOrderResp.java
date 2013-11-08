package com.myit.intf.bean.order;

import java.io.Serializable;

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
public class BookOrderResp extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 订单编号 **/
    private String orderNo;

    /** 会员编号 **/
    private String memberNo;

    /** 是否需要校验用户 **/
    private boolean authValid;

    public BookOrderResp() {
    }

    /**
     * 查询参数初始化
     * 
     * @param orderNo
     * @param authValid
     * @param memberNo
     */
    public BookOrderResp(String orderNo, boolean authValid, String memberNo) {
        this.orderNo = orderNo;
        this.authValid = authValid;
        this.memberNo = memberNo;
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

    public boolean isAuthValid() {
        return authValid;
    }

    public void setAuthValid(boolean authValid) {
        this.authValid = authValid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getId() ^ (this.getId() >>> 32));
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
        BookOrderResp other = (BookOrderResp) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OrderInfoReq [orderNo=" + orderNo + ", authValid=" + authValid + ", appCode=" + this.getAppCode() + "]";
    }

}
