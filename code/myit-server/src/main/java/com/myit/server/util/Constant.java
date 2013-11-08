package com.myit.server.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    /**
     * 登录用户session标识符
     */
    public static final String LOGIN_USER = "loginUser";

    /**
     * 常用数字、字符常量
     */
    public static final int NUM_MINUS_ONE = -1;
    public static final int NUM_ZERO = 0;
    public static final int NUM_ONE = 1;
    public static final int NUM_THREE_NINE = 999;

    public static final String STR_MINUS_ONE = "-1";
    public static final String STR_ZERO = "0";
    public static final String STR_ONE = "1";
    public static final String STR_THREE_NINE = "999";

    /**
     * 常用状态码
     */
    public static final String SUCCESS = "0";
    public static final String FAILED = "-1";
    public static final String ACTIVE = "0";
    public static final String INACTIVE = "-1";

    /**
     * 订单代码标识符
     */
    public static final String orderCode = "orderCode";

    /**
     * 操作日志类型
     */
    public static final Map<String, String> opType;

    /**
     * 订单状态
     */
    public static final Map<String, String> orderStatus;

    /**
     * 基础数据状态
     */
    public static final Map<String, String> baseDataStatu;

    /**
     * 订单物品分类状态
     */
    public static final Map<String, String> goodsCatalog;

    static {
        baseDataStatu = new HashMap<String, String>();
        baseDataStatu.put("-1", "禁用");
        baseDataStatu.put("0", "启用");

        opType = new HashMap<String, String>();
        opType.put("0", "登录/退出");
        opType.put("1", "新增");
        opType.put("2", "修改");
        opType.put("3", "删除");

        orderStatus = new HashMap<String, String>();
        orderStatus.put("0", "保存");
        orderStatus.put("1", "提交");
        orderStatus.put("2", "驳回");
        orderStatus.put("3", "受理");
        orderStatus.put("4", "发运");
        orderStatus.put("5", "签收");
        orderStatus.put("6", "结算");

        goodsCatalog = new HashMap<String, String>();
        goodsCatalog.put("0", "普通");
        goodsCatalog.put("1", "高单价");
        goodsCatalog.put("2", "高质量");

    }

}
