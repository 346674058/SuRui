package com.myit.intf.service.member;

import com.myit.intf.bean.member.CloseAccountReq;
import com.myit.intf.bean.member.CloseAccountResp;
import com.myit.intf.bean.member.LoginReq;
import com.myit.intf.bean.member.LoginResp;
import com.myit.intf.bean.member.RegistReq;
import com.myit.intf.bean.member.RegistResp;

/**
 * 客户管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface MemberService {

    /**
     * 
     * 功能描述: <br>
     * 会员注册
     * 
     * @param evt 注册信息
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    RegistResp regist(RegistReq registReq) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 会员销户
     * 
     * @param evt 会员销户信息
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    CloseAccountResp closeAccount(CloseAccountReq closeAccountReq) throws Exception;

    LoginResp login(LoginReq loginReq) throws Exception;

}
