package com.myit.intf.service.admin;

import com.myit.intf.bean.admin.user.CloseUserAccountReq;
import com.myit.intf.bean.admin.user.CloseUserAccountResp;
import com.myit.intf.bean.admin.user.UserLoginReq;
import com.myit.intf.bean.admin.user.UserLoginResp;
import com.myit.intf.bean.admin.user.UserRegistReq;
import com.myit.intf.bean.admin.user.UserRegistResp;

/**
 * 用户管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface UserService {
    /**
     * 
     * 功能描述: <br>
     * 用户注册
     * 
     * @param evt 注册信息
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    UserRegistResp regist(UserRegistReq req) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 禁用用户
     * 
     * @param evt 会员销户信息
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CloseUserAccountResp closeAccount(CloseUserAccountReq req) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 用户登录
     * 
     * @param req
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    UserLoginResp login(UserLoginReq req) throws Exception;

}
