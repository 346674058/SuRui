package com.myit.server.dao.bill;

import java.util.List;

import com.myit.server.model.bill.OrderInfo;

/**
 * 订单数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface OrderInfoDao {

    /**
     * 查询订单<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param id 订单id
     * @return
     * @throws Exception
     */
    public OrderInfo findOrderById(Long id) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 根据订单号查询订单
     * 
     * @param orderNo 订单号
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public OrderInfo findOrderByNo(String orderNo) throws Exception;

    /**
     * 查询所有订单<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @return
     * @throws Exception
     */
    public List<OrderInfo> findAllOrders() throws Exception;

    /**
     * 获取订单总数<br>
     * 
     * @author created by LiuCongwen at 2012-4-29
     * @param order
     * @return
     * @throws Exception
     */
    public int getOrdersCount(OrderInfo order) throws Exception;

    /**
     * 分页查询订单<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param start 起始记录数
     * @param pageSize 页面大小
     * @param order 查询实体
     * @return
     * @throws Exception
     */
    public List<OrderInfo> findOrders(int start, int pageSize, OrderInfo order) throws Exception;

    /**
     * 保存/更新订单基本信息<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param order 保存(id = null), 更新(id != null)
     * @return
     * @throws Exception
     */
    public boolean persistOrder(OrderInfo order) throws Exception;
}
