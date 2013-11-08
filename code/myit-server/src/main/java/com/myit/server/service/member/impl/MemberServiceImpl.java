package com.myit.server.service.member.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.myit.common.util.Constant;
import com.myit.common.util.RetCode;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.member.CloseAccountReq;
import com.myit.intf.bean.member.CloseAccountResp;
import com.myit.intf.bean.member.LoginReq;
import com.myit.intf.bean.member.LoginResp;
import com.myit.intf.bean.member.LogoutReq;
import com.myit.intf.bean.member.LogoutResp;
import com.myit.intf.bean.member.RegistReq;
import com.myit.intf.bean.member.RegistResp;
import com.myit.intf.service.member.MemberService;
import com.myit.server.dao.member.MemberInfoDao;
import com.myit.server.model.member.MemberInfo;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    private static final Logger LOGGER = Logger.getLogger(MemberServiceImpl.class);

    @Resource
    private MemberInfoDao memberInfoDao;

    public RegistResp regist(RegistReq registReq) throws Exception {
        LOGGER.info("regist IN");

        RegistResp registResp = new RegistResp();

        // 验证参数是否完整
        if (registReq == null) {
            LOGGER.warn("registReq is null");
            registResp.setRetCode(RetCode.FAILED);

            return registResp;
        }

        // 构造会员实体类
        MemberInfo memberInfo = initMemberInfo(registReq);

        // 会员密码md5+key加密
        String key = Constant.KEY_PASSWORD;
        String memberPwd = StringConvert.passwordMD5(registReq.getPassword(), key);
        memberInfo.setPassword(memberPwd);

        // 持久化到数据库
        LOGGER.info("persist MemberInfo");
        memberInfoDao.persistMemberInfo(memberInfo);

        // 持久化成功
        registResp.setRetCode(RetCode.SUCCESS);
        registResp.setMemberNo(registReq.getMemberNo());

        LOGGER.info("regist OUT");
        return registResp;
    }

    private MemberInfo initMemberInfo(RegistReq registReq) {
        MemberInfo memberInfo = new MemberInfo();

        memberInfo.setAccount(registReq.getMemberNo());

        memberInfo.setMobile(registReq.getMobile());
        memberInfo.setBirthday(registReq.getBirthday());

        memberInfo.setProvince(registReq.getProvinceId());
        memberInfo.setCity(registReq.getCityId());
        memberInfo.setArea(registReq.getAreaId());

        memberInfo.setAddress(registReq.getAddress());

        // 置会员状态为正常
        memberInfo.setStatus(Constant.ACTIVE);

        return memberInfo;
    }

    public CloseAccountResp closeAccount(CloseAccountReq evt) throws Exception {
        LOGGER.info("closeAccount IN");

        LOGGER.info("closeAccount OUT");
        return null;
    }

    public LoginResp login(LoginReq loginReq) throws Exception {
        LOGGER.info("login IN");

        LOGGER.debug("loginReq=" + loginReq);

        LoginResp loginResp = new LoginResp();

        if (loginReq == null || StringConvert.isEmpty(loginReq.getAccount())
                || StringConvert.isEmpty(loginReq.getPassword())) {
            LOGGER.error("userName or password is null");

            loginResp.setRetCode(RetCode.FAILED);

            LOGGER.debug("loginResp=" + loginResp);

            LOGGER.info("login OUT");
            return loginResp;
        }

        MemberInfo memberInfo = null;

        try {
            memberInfo = memberInfoDao.findMemberInfosByAccount(loginReq.getAccount());
        } catch (Exception e) {
            LOGGER.warn("findMemberInfosByAccount failed", e);
        }

        // 会员不存在
        if (memberInfo == null) {
            LOGGER.error("member not exsit");

            loginResp.setRetCode(RetCode.MEMBER_NOT_EXSIT);

            LOGGER.debug("loginResp=" + loginResp);

            LOGGER.info("login OUT");
            return loginResp;
        }

        // 判断密码是否正确，取出密码MD5加密后比较结果是否相等
        String key = Constant.KEY_PASSWORD;
        String passwordReq = StringConvert.passwordMD5(loginReq.getPassword(), key);

        // 密码错误
        if (!passwordReq.equals(memberInfo.getPassword())) {
            LOGGER.error("password is increct");
            loginResp.setRetCode(RetCode.PASSWORD_INCRECT);
        } else if (Constant.ACTIVE.equals(loginResp.getStatus())) {// 判断会员状态是否禁用
            LOGGER.error("password is inactive");
            loginResp.setRetCode(RetCode.MEMBER_INACTIVE);
        } else {

            // 登录成功
            loginResp.setRetCode(RetCode.SUCCESS);

            // 返回登录信息
            loginResp.setMemberNo(memberInfo.getAccount());
            loginResp.setPassword(memberInfo.getPassword());
            loginResp.setRealName(memberInfo.getNick());
        }

        LOGGER.debug("loginResp=" + loginResp);

        LOGGER.info("login OUT");
        return loginResp;
    }

    public LogoutResp logout(LogoutReq req) throws Exception {
        LOGGER.info("logout IN");

        LOGGER.info("logout OUT");
        return null;
    }
}
