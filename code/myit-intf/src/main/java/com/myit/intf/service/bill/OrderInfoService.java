package com.myit.intf.service.bill;

import com.myit.common.beans.PageQueryParam;
import com.myit.common.beans.PageQueryResult;
import com.myit.intf.bean.order.BookOrderReq;
import com.myit.intf.bean.order.BookOrderResp;
import com.myit.intf.bean.order.OrderInfoReq;
import com.myit.intf.bean.order.OrderInfoResp;
import com.myit.intf.bean.order.QueryOrderReq;

/**
 * 订单管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface OrderInfoService {
    /**
     * 
     * 功能描述: <br>
     * 根据订单号查询订单详情
     * 
     * @param orderNo
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public OrderInfoResp findOrderInfo(OrderInfoReq orderInfoReq) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 分页查询订单
     * 
     * @param pageQueryParam
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public PageQueryResult<QueryOrderReq> findOrders(PageQueryParam<QueryOrderReq> pageQueryParam) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 保存订单
     * 
     * @param bookOrderReq
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public BookOrderResp bookOrder(BookOrderReq bookOrderReq) throws Exception;

}
