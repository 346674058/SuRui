package com.myit.portal.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.myit.common.unionpay.QuickPayConf;
import com.myit.common.unionpay.QuickPayUtils;
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
    // 商品预订页面
    private static final String BOOK_RESULT_URL = "/order/bookResult.htm";

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

        //获取选择的商品
        List<OrderItem> orderItems = getCheckedItems(request);

        // 没有选择商品，跳转到商品搜索页面
        if (orderItems == null || orderItems.size() == 0) {
            LOGGER.warn("ordreItems is empty");

            LOGGER.info("bookOrder OUT");
            return "redirect:" + request.getContextPath() + SEARCH_URL;
        }

        LOGGER.debug("checked orderItems,size=" + orderItems.size());

        //商品列表
        order.setOrderItems(orderItems);
        
        //计算商品总价
        Double totalPrice=getTotalPrice(orderItems);
        order.setTotalPrice(totalPrice);
        
        model.addAttribute("order", order);

        LOGGER.info("bookOrder OUT");
        return "order/bookOrder.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 计算订单总价
     *
     * @param orderItems
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private Double getTotalPrice(List<OrderItem> orderItems) {
        LOGGER.info("getTotalPrice IN");

        Double totalPrice = new Double(0);

        if (orderItems == null) {
            LOGGER.warn("orderItems is null");

            LOGGER.info("getTotalPrice IN");
            return totalPrice;
        }

        // 循环累加小计金额得到总计金额
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getSubTotal();
        }

        LOGGER.info("getTotalPrice IN");
        return totalPrice;
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

        // 从购物车中取出商品列表
        @SuppressWarnings("unchecked")
        List<Commodity> commodities = (List<Commodity>) request.getSession().getAttribute(Constant.SHOPPING_CART);

        // 获取从购物车里面选择的的商品信息，包括各类商品的数量，展示在页面上。
        for (Commodity commodity:commodities) {

            // 订单商品
            OrderItem orderItem = new OrderItem();
            orderItem.setCommodity(commodity);

            // 预订份数
            orderItem.setCount(commodity.getBookCount());
            
            //小计
            orderItem.setSubTotal(commodity.getSubTotalPrice());

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
    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
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
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new Double(9.50), new Double(0.50));

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
                Commodity commodity = new Commodity("1", "盖浇饭" + commodities_i, "img/logo.jpg", new Double(9.50),
                        new Double(0.50));

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
            Commodity commodity = new Commodity("1", "盖浇饭", "img/logo.jpg", new Double(9.50), new Double(0.50));

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

    @RequestMapping(value = "/pay/{orderNo}")
    public String pay(@PathVariable String orderNo, Model model, HttpServletRequest request) throws Exception {
        LOGGER.info("pay OUT");

        LOGGER.debug("orderNo=" + orderNo);

        // TODO 调用接口查询订单支付信息
        Order order = new Order();

        // 商户需要组装如下对象的数据

        // 当前会员
        Member member = (Member) request.getSession().getAttribute(Constant.LOGIN_MEMBER);
        String ip = request.getRemoteAddr();

        String[] valueVo = getPayparam(order, member, ip);

        String signType = QuickPayConf.SIGNTYPE_MD5;

        String payHtml = new QuickPayUtils().createPayHtml(valueVo, signType);// 跳转到银联页面支付

        LOGGER.debug("payHtml=\n" + payHtml);

        // 返回到页面
        model.addAttribute("jsonData", payHtml);

        LOGGER.info("pay OUT");
        return "common/ajaxResult.ftl";
    }

    /**
     * 
     * 功能描述: <br>
     * 获取支付请求参数数组
     * 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private String[] getPayparam(Order order, Member member, String ip) {

        // 商品数量
        int commSize = order.getOrderItems().size();

        String retParam[] = new String[] { QuickPayConf.version,// 协议版本
                QuickPayConf.charset,// 字符编码
                QuickPayConf.TRADETYPE_PAY,// 交易类型
                "",// 原始交易流水号
                QuickPayConf.merCode,// 商户代码
                QuickPayConf.merName,// 商户简称
                "",// 收单机构代码（仅收单机构接入需要填写）
                "",// 商户类别（收单机构接入需要填写）
                "",// 商品URL
                "",// 商品名称
                "0",// 商品单价 单位：分
                String.valueOf(commSize),// 商品数量
                "0",// 折扣 单位：分
                "0",// 运费 单位：分
                order.getOrderNo(),// 订单号（需要商户自己生成）
                String.valueOf(order.getTotalPrice()),// 交易金额 单位：分
                QuickPayConf.CURRENCY_CODE,// 交易币种.156-RMB
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),// 交易时间
                ip,// 用户IP
                member.getNick(),// 用户真实姓名
                "",// 默认支付方式
                "",// 默认银行编号
                QuickPayConf.TIMEOUT,// 交易超时时间
                QuickPayConf.merFrontEndUrl,// 前台回调商户URL
                QuickPayConf.merBackEndUrl,// 后台回调商户URL
                ""// 商户保留域
        };

        return retParam;
    }

    @RequestMapping(value = "/payResult")
    public void payResult(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("payResult OUT");

        String orderNo = "V000000001";

        // TODO 调用接口查询订单支付信息
        // Order order = new Order();

        LOGGER.info("payResult OUT");
        response.sendRedirect(request.getContextPath());
    }

}
