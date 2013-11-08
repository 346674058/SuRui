package com.myit.server.service.member;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.myit.common.util.RetCode;
import com.myit.intf.bean.member.RegistReq;
import com.myit.intf.bean.member.RegistResp;
import com.myit.intf.service.member.MemberService;
import com.myit.server.BaseTest;

/**
 * 客户管理业务处理接口测试类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class MemberServiceTest extends BaseTest{

    private static final Logger LOGGER = Logger.getLogger(MemberServiceTest.class);

    @Resource
    MemberService memberService;

    @Test
    public void regist() {

        RegistReq registReq = new RegistReq();

        RegistResp registResp = null;
        try {
            registResp = memberService.regist(registReq);
        } catch (Exception e) {
            LOGGER.warn("member regist failed ", e);
        }

        // 注册成功
        assert registResp != null && RetCode.SUCCESS.equals(registResp.getRetCode());
    }

    // CloseAccountResp closeAccount(CloseAccountReq evt) throws Exception;
    // LoginResp login(LoginReq req) throws Exception;

}
