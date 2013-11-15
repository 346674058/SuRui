package com.myit.portal.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.myit.common.util.RetCode;
import com.myit.intf.bean.order.BookOrderReq;
import com.myit.intf.bean.order.BookOrderResp;
import com.myit.intf.bean.order.OrderInfoReq;
import com.myit.intf.bean.order.OrderInfoResp;
import com.myit.intf.bean.order.OrderInfoRespItem;
import com.myit.intf.service.bill.OrderInfoService;
import com.myit.portal.action.bean.Commodity;
import com.myit.portal.action.bean.Member;
import com.myit.portal.action.bean.Order;
import com.myit.portal.action.bean.OrderItem;
import com.myit.portal.util.Constant;

/**
 * 
 * 订单管理控制类<br>
 * 商品预订、订单查询、订单详情等功能
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/order")
public class OrderAction extends BaseAction {

    private static final Logger LOGGER = Logger.getLogger(OrderAction.class);

    // 商品查询页面
    private static final String SEARCH_URL = "/commodity/search.htm";

    @Resource
    OrderInfoService orderInfoService;

    /**
     * 
     * 功能描述: <br>
     * 跳转到订单填写页面
     * 
     * @param model
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/bookOrder")
    public String bookOrder(Model model, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("bookOrder IN");

        // 取出当前会员的昵称、手机和常用配送地址信息，展示到页面上。
        Member member = (Member) request.getSession().getAttribute(Constant.LOGIN_MEMBER);
        LOGGER.debug("member=" + member);

        Order order = new Order();

        order.setMemberNo(member.getMemberNo());
        order.setContact(member.getNick());
        order.setMobile(member.getMobile());
        order.setAddress(member.getAddress());

        List<OrderItem> orderItems = getCheckedItems(request);

        // 没有选择商品，跳转到商品搜索页面
        if (orderItems == null || orderItems.size() == 0) {
            LOGGER.warn("ordreItems is empty");

            LOGGER.info("bookOrder OUT");
            return "redirect:" + request.getContextPath() + SEARCH_URL;
        }

        LOGGER.debug("checked orderItems,size=" + orderItems.size());

        order.setOrderItems(orderItems);

        model.addAttribute("order", order);

        LOGGER.info("bookOrder OUT");
        return "order/bookOrder.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 获取选择的物品列表
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private List<OrderItem> getCheckedItems(HttpServletRequest request) {

        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        // 获取从购物车里面选择的的商品信息，包括各类商品的数量，展示在页面上。
        // TODO 演示数据
        for (int commodities_i = 0; commodities_i < 10; commodities_i++) {

            // 商品
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new BigDecimal(9.50), new BigDecimal(0.50));

            OrderItem orderItem = new OrderItem();

            orderItem.setCommodity(commodity);

            // 预订份数
            orderItem.setCount(1);

            orderItems.add(orderItem);
        }

        return orderItems;
    }

    /**
     * 
     * 功能描述: <br>
     * 提交订单
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/submitOrder")
    public String submitOrder(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("submitOrder IN");

        // 获取当前登录会员
        Member member = (Member) request.getSession().getAttribute(Constant.LOGIN_MEMBER);
        LOGGER.debug("member=" + member);

        // 初始化商品预定请求参数
        BookOrderReq bookOrderReq = new BookOrderReq();
        initBookOrderReq(bookOrderReq, request);

        Map<String, Object> data = new HashMap<String, Object>();

        // 调用订单保存接口
        BookOrderResp bookOrderResp = null;
        try {
            bookOrderResp = orderInfoService.bookOrder(bookOrderReq);
        } catch (Exception e) {
            LOGGER.warn("bookOrder failed", e);
        }

        // 转换json输入结果
        Gson gson = new Gson();

        // 预定失败
        if (bookOrderResp == null || !RetCode.SUCCESS.equals(bookOrderResp.getRetCode())) {
            LOGGER.error("bookOrderResp is null");

            data.put("retCode", Constant.FAILED);
            data.put("msg", "系统忙，请稍后再试。");

            String jsonData = gson.toJson(data);
            LOGGER.debug("jsonData=" + jsonData);

            model.addAttribute("jsonData", jsonData);

            LOGGER.info("submitOrder OUT");
            return "common/ajaxResult.ftl";
        }

        // 预定成功
        data.put("retCode", Constant.SUCCESS);
        data.put("orderNo", bookOrderResp.getOrderNo());

        String jsonData = gson.toJson(data);
        LOGGER.debug("jsonData=" + jsonData);

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("submitOrder OUT");
        return "common/ajaxResult.ftl";
    }

    private void initBookOrderReq(BookOrderReq bookOrderReq, HttpServletRequest request) {
        // TODO Auto-generated method stub

    }

    /**
     * 
     * 功能描述: <br>
     * 跳转到预订结果页面
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/bookResult")
    public String bookResult(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("bookResult IN");

        String orderNo = getParam("orderNo", request);
        LOGGER.debug("orderNo=" + orderNo);

        // 当前会员
        Member member = (Member) request.getSession().getAttribute(Constant.LOGIN_MEMBER);

        // 根据订单号查询订单详情
        OrderInfoReq orderInfoReq = new OrderInfoReq(orderNo, true, member.getMemberNo());
        OrderInfoResp orderInfoResp = orderInfoService.findOrderInfo(orderInfoReq);

        // 查询失败
        if (orderInfoResp == null || RetCode.FAILED.equals(orderInfoResp.getRetCode())) {
            LOGGER.warn("findOrderInfo failed");

            LOGGER.info("bookResult OUT");
            return "exception/error-exception.ftl";
        }

        // 初始化订单信息
        Order order = initOrder(orderInfoResp);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        // 获取从购物车里面选择的的商品信息，包括各类商品的数量，展示在页面上。
        for (int commodities_i = 0; commodities_i < 10; commodities_i++) {

            // 商品
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new BigDecimal(9.50), new BigDecimal(0.50));

            OrderItem orderItem = new OrderItem();

            orderItem.setCommodity(commodity);

            // 预订份数
            orderItem.setCount(1);

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);

        model.addAttribute("order", order);

        LOGGER.info("bookResult OUT");
        return "order/bookResult.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 初始化订单信息
     * 
     * @param orderInfoResp
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Order initOrder(OrderInfoResp orderInfoResp) {
        Order order = new Order();

        // 订单信息
        order.setOrderNo(orderInfoResp.getOrderNo());
        order.setMemberNo(orderInfoResp.getMemberNo());
        order.setContact(orderInfoResp.getContact());
        order.setMobile(orderInfoResp.getMobile());
        order.setAddress(orderInfoResp.getAddress());

        // 商品列表
        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        if (orderInfoResp.getOrderItems() != null) {

            for (int i = 0; i < orderInfoResp.getOrderItems().size(); i++) {
                OrderInfoRespItem orderInfoRespItem = orderInfoResp.getOrderItems().get(i);

                OrderItem orderItem = new OrderItem();

                // 商品
                Commodity commodity = new Commodity();
                commodity.setComCode(orderInfoRespItem.getComCode());
                commodity.setComName(orderInfoRespItem.getCommName());
                commodity.setPrice(orderInfoRespItem.getPrice());

                orderItem.setCommodity(commodity);
                orderItem.setCount(orderInfoRespItem.getCount());
                orderItem.setSubTotal(orderInfoRespItem.getSubTotal());
            }
            order.setOrderItems(orderItems);
        }

        return order;
    }

    /**
     * 
     * 功能描述: <br>
     * 跳转到订单中心页面
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/orderCenter")
    public String orderCenter(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("orderCenter IN");

        LOGGER.info("orderCenter IN");
        return "order/orderCenter.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 查询订单列
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("list IN");

        List<Order> orders = new ArrayList<Order>();

        // TODO 演示数据
        for (int i = 0; i < 10; i++) {

            Order order = new Order();

            order.setOrderNo("2013092500" + i);

            order.setMemberNo("001");
            order.setContact("张三");
            order.setMobile("18612398476");
            order.setAddress("徐庄软件园动漫11栋104室");

            List<OrderItem> orderItems = new ArrayList<OrderItem>();

            // 获取从购物车里面选择的的商品信息，包括各类商品的数量，展示在页面上。
            for (int commodities_i = 0; commodities_i < 3; commodities_i++) {

                // 商品
                Commodity commodity = new Commodity("1", "盖浇饭" + commodities_i, "img/logo.jpg", new BigDecimal(9.50),
                        new BigDecimal(0.50));

                OrderItem orderItem = new OrderItem();

                orderItem.setCommodity(commodity);

                // 预订份数
                orderItem.setCount(1);

                orderItems.add(orderItem);
            }
            order.setOrderItems(orderItems);

            orders.add(order);
        }

        // PageQueryResult<Order> pageQueryResult=new PageQueryResult<Order>();

        model.addAttribute("pageNo", 3);
        model.addAttribute("pageCount", 16);

        model.addAttribute("orders", orders);

        LOGGER.info("list IN");
        return "order/list.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 取消订单
     * 
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/cancel")
    public String cancel(Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("cancel IN");

        // String orderNo=getParam("orderNo", request);

        Map<String, Object> cancelResult = new HashMap<String, Object>();

        cancelResult.put("retCode", "0");

        Gson gson = new Gson();
        String jsonData = gson.toJson(cancelResult);

        model.addAttribute("jsonData", jsonData);

        LOGGER.info("cancel IN");
        return "common/ajaxResult.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 跳转到订单详情页面
     * 
     * @param orderNo
     * @param model
     * @param request
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping(value = "/orderDetail/{orderNo}")
    public String orderDetail(@PathVariable String orderNo, Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("orderDetail IN");

        // TODO 演示数据
        Order order = new Order();

        order.setOrderNo(orderNo);

        order.setMemberNo("001");
        order.setContact("张三");
        order.setMobile("18612398476");
        order.setAddress("徐庄软件园动漫11栋104室");

        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        for (int commodities_i = 0; commodities_i < 10; commodities_i++) {

            // 商品
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new BigDecimal(9.50), new BigDecimal(0.50));

            OrderItem orderItem = new OrderItem();

            orderItem.setCommodity(commodity);

            // 预订份数
            orderItem.setCount(1);

            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);

        model.addAttribute("order", order);

        LOGGER.info("orderDetail OUT");
        return "order/orderDetail.ftl";
    }

}
