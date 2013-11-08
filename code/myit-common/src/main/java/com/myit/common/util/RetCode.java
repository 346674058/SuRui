package com.myit.common.util;

public class RetCode {

    // 成功
    public static final String SUCCESS = "000000000";

    // 失败
    public static final String FAILED = "-1";

    // 用户不存在
    public static final String USER_NOT_EXSIT = "000000001";
    
    // 会员不存在
    public static final String MEMBER_NOT_EXSIT = "000001001";

    // 密码错误
    public static final String PASSWORD_INCRECT = "000000002";

    // 用户禁用
    public static final String USER_INACTIVE = "000000003";
    
    // 会员禁用
    public static final String MEMBER_INACTIVE = "000001003";
    
    // 参数检查失败
    public static final String PARAM_UNVALIDE = "-2";
    
    // 鉴权失败
    public static final String AUTH_UNVALIDE = "-3";
    
    

}
