package com.myit.server.service.bill.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.beans.PageQueryParam;
import com.myit.common.beans.PageQueryResult;
import com.myit.common.util.RetCode;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.order.BookOrderReq;
import com.myit.intf.bean.order.BookOrderResp;
import com.myit.intf.bean.order.OrderInfoReq;
import com.myit.intf.bean.order.OrderInfoResp;
import com.myit.intf.bean.order.QueryOrderReq;
import com.myit.intf.service.bill.OrderInfoService;
import com.myit.server.dao.baseData.CodeGenDao;
import com.myit.server.dao.bill.OrderCommoDao;
import com.myit.server.dao.bill.OrderInfoDao;
import com.myit.server.model.baseData.CodeGen;
import com.myit.server.model.bill.OrderCommo;
import com.myit.server.model.bill.OrderInfo;
import com.myit.server.util.CodeGenerator;
import com.myit.server.util.Constant;

@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

    private final static Logger LOGGER = Logger.getLogger(OrderInfoServiceImpl.class);

    @Resource
    private OrderInfoDao orderDao;

    @Resource
    private OrderCommoDao orderGoodsDao;

    @Resource
    private CodeGenDao codeSnapshotDao;

    public OrderInfoResp findOrderInfo(OrderInfoReq orderInfoReq) throws Exception {
        LOGGER.info("findOrderByNo IN");

        LOGGER.debug("orderInfoReq=" + orderInfoReq);

        OrderInfoResp orderInfoResp = new OrderInfoResp();

        // 参数检查
        if (orderInfoReq == null || StringConvert.isEmpty(orderInfoReq.getOrderNo())) {
            LOGGER.warn("orderNo is null");

            orderInfoResp.setRetCode(RetCode.PARAM_UNVALIDE);

            LOGGER.info("findOrderByNo IN");
            return orderInfoResp;
        }

        try {
            // 调用dao查询订单
            LOGGER.info("invoke orderDao.findOrderByNo");
            OrderInfo order = orderDao.findOrderByNo(orderInfoReq.getOrderNo());

            // 查询到订单信息
            if (order != null && order.getId() != null) {

                // 判断是否需要鉴权
                if (orderInfoReq.isAuthValid() && !StringConvert.isEmpty(order.getMemberNo())) {
                    if (!(order.getMemberNo().equals(orderInfoReq.getMemberNo()))) {
                        LOGGER.warn("order auth valida failed");

                        orderInfoResp.setRetCode(RetCode.AUTH_UNVALIDE);
                        return orderInfoResp;
                    }
                }

                // 初始化订单信息
                initOrderInfoResp(orderInfoResp, order);

                // 查询订单商品列表
                List<OrderCommo> orderCommos = orderGoodsDao.findOrderGoodsByOId(order.getId());

                // 初始化订单商品列表
                setOrderInfoRespItems(orderInfoResp, orderCommos);
            } else {
                // 查询订单失败
                LOGGER.warn("findOrderInfo failed");
                orderInfoResp.setRetCode(RetCode.FAILED);
            }

        } catch (Exception e) {
            LOGGER.warn("findOrderInfo failed", e);

            // 查询订单失败
            orderInfoResp.setRetCode(RetCode.FAILED);
        }

        LOGGER.debug("orderInfoResp=" + orderInfoResp);

        LOGGER.info("findOrderInfo OUT");
        return orderInfoResp;
    }

    /**
     * 
     * 功能描述: <br>
     * 初始化订单信息
     * 
     * @param orderInfoResp
     * @param orderCommos
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void setOrderInfoRespItems(OrderInfoResp orderInfoResp, List<OrderCommo> orderCommos) {
        // TODO Auto-generated method stub

    }

    /**
     * 
     * 功能描述: <br>
     * 初始化订单商品列表
     * 
     * @param orderInfoResp
     * @param order
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private void initOrderInfoResp(OrderInfoResp orderInfoResp, OrderInfo order) {
        // TODO Auto-generated method stub

    }

    public int getOrdersCount(OrderInfo order) throws Exception {
        LOGGER.info("getOrdersCount in.");

        int ordersCount = 0;

        try {
            // 调用dao查询订单记录数
            ordersCount = orderDao.getOrdersCount(order);
        } catch (Exception e) {
            LOGGER.warn("Exception occured", e);

            throw e;
        }

        LOGGER.info("getOrdersCount out.");
        return ordersCount;
    }

    public PageQueryResult<QueryOrderReq> findOrders(PageQueryParam<QueryOrderReq> pageQueryParam) throws Exception {
        LOGGER.info("findOrders in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("pageQueryParam=" + pageQueryParam);
        }

        int total = 0;
        PageQueryResult<QueryOrderReq> pageQueryResult = null;

        try {
            // 调用dao查询订单总数
            total = orderDao.getOrdersCount(null);

            pageQueryResult = new PageQueryResult<QueryOrderReq>(total, pageQueryParam.getPageNo(),
                    pageQueryParam.getPageSize());

            if (total > 0) {
                // 调用dao分页查询订单
                List<OrderInfo> orders = orderDao.findOrders(pageQueryResult.getStart(), pageQueryResult.getPageSize(),
                        null);

                pageQueryResult.setRows(null);
            }
        } catch (Exception e) {
            LOGGER.warn("Exception occured", e);

            throw e;
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("pageQueryResult=" + pageQueryResult);
        }

        LOGGER.info("findOrders out.");
        return pageQueryResult;
    }

    public BookOrderResp bookOrder(BookOrderReq bookOrderReq) throws Exception {
        LOGGER.info("bookOrder IN");

        LOGGER.debug("bookOrderReq=" + bookOrderReq);

        BookOrderResp bookOrderResp = new BookOrderResp();

        // 检查参数
        if (bookOrderReq == null || !StringConvert.isEmpty(bookOrderReq.getMemberNo())
                || !StringConvert.isEmpty(bookOrderReq.getContact()) || bookOrderReq.getOrderItems() == null
                || bookOrderReq.getOrderItems().size() == 0) {
            LOGGER.warn("bookOrderReq unvalid");

            bookOrderResp.setRetCode(RetCode.PARAM_UNVALIDE);

            LOGGER.info("bookOrder OUT");
            return bookOrderResp;
        }

        try {
            // 获取订单号快照,
            CodeGen codeSnapshot = codeSnapshotDao.findCodeSnapshotByCodeType(Constant.orderCode);

            // 调用号码生成器生成订单号
            int curValue = codeSnapshot.getCurValue();
            CodeGenerator codeGenerator = new CodeGenerator(curValue, codeSnapshot.getGenTpl());
            String orderNo = codeGenerator.generator();

            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderNo(orderNo);

            // 调用dao保存订单信息
            orderDao.persistOrder(orderInfo);
        } catch (Exception e) {
            LOGGER.warn("bookOrder failed", e);
            bookOrderResp.setRetCode(RetCode.FAILED);
        }

        LOGGER.debug("bookOrderResp=" + bookOrderResp);

        LOGGER.info("saveOrder OUT");
        return bookOrderResp;
    }

}
