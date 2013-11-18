package com.myit.portal.util;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    /** 登录会员session标识符 **/
    public static final String LOGIN_MEMBER = "loginMember";

    /** 登录回调 **/
    public static final String LOGIN_CALLBACK = "loginCallback";

    /** 随机验证码标识符 **/
    public static final String RANDOM_CODE = "randomCode";

    // 商品分类缓存key
    public static final String SHOPPING_CART = "shoppingCart";

    /** 常用变量 **/
    /** 禁用 **/
    public static final String INACTIVE = "-1";
    /** 启用 **/
    public static final String ACTIVE = "0";

    public static final String UNKOEN = "-999";
    public static final String SUCCESS = "0";
    public static final String FAILED = "-1";

    /** 操作类型-登录/退出 **/
    public static final String OP_TYPE_LOGIN = "0";

    /** 操作类型-修改密码 **/
    public static final String OP_TYPE_SECURITY = "1";

    /** 操作类型-修改会员信息 **/
    public static final String OP_TYPE_UPDINFO = "2";

    /**
     * 分隔符
     */
    public static final String splitChar = "`";

    /**
     * 订单状态
     */
    public static final Map<String, String> orderStatus;

    // 性别
    public static final Map<String, String> sex;

    static {
        orderStatus = new HashMap<String, String>();

        orderStatus.put("0", "保存");
        orderStatus.put("1", "提交");
        orderStatus.put("2", "审批");
        orderStatus.put("3", "受理");
        orderStatus.put("4", "发运");
        orderStatus.put("5", "验收");
        orderStatus.put("6", "结算");

        sex = new HashMap<String, String>();

        sex.put("M", "男");
        sex.put("F", "女");
        
    }

}
