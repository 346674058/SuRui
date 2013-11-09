package com.myit.intf.bean.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myit.common.beans.BaseModel;

/**
 * 
 * 商品预定请求实体类<br>
 * 〈功能详细描述〉
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class QueryOrderReq extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    // 订单号码
    String orderNo;

    // ------
    // 会员账户
    String memberNo;

    // 订单联系人
    String contact;

    // 联系人手机
    String mobile;

    // ------
    // 配送地址
    String address;

    // ------
    // 订单金额
    BigDecimal totalPrice;

    // 订单状态
    String status;

    // 下单时间
    Date bookingTime;

    // ------
    // 订单行列表
    List<BookOrderReqItem> orderItems;

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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public List<BookOrderReqItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<BookOrderReqItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        int size = 0;
        if (orderItems != null) {
            size = orderItems.size();
        }

        return "QueryOrderReq [orderNo=" + orderNo + ", memberNo=" + memberNo + ", contact=" + contact + ", mobile="
                + mobile + ", address=" + address + ", totalPrice=" + totalPrice + ", status=" + status
                + ", bookingTime=" + bookingTime + ", orderItems.size=" + size + ", appCode=" + getAppCode() + "]";
    }

}
