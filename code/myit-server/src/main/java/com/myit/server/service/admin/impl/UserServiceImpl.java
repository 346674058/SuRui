package com.myit.server.service.admin.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myit.common.CfgMgr;
import com.myit.common.util.Constant;
import com.myit.common.util.RetCode;
import com.myit.common.util.StringConvert;
import com.myit.intf.bean.admin.user.CloseUserAccountReq;
import com.myit.intf.bean.admin.user.CloseUserAccountResp;
import com.myit.intf.bean.admin.user.UserLoginReq;
import com.myit.intf.bean.admin.user.UserLoginResp;
import com.myit.intf.bean.admin.user.UserRegistReq;
import com.myit.intf.bean.admin.user.UserRegistResp;
import com.myit.intf.service.admin.UserService;
import com.myit.server.dao.admin.UserDao;
import com.myit.server.model.admin.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserRegistResp regist(UserRegistReq req) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public CloseUserAccountResp closeAccount(CloseUserAccountReq req) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public UserLoginResp login(UserLoginReq loginReq) throws Exception {
        LOGGER.info("login IN");

        // 调用dao接口查询用户
        UserLoginResp loginResp = new UserLoginResp();

        LOGGER.debug("loginReq=" + loginReq);

        if (loginReq == null || StringConvert.isEmpty(loginReq.getUserName())
                || StringConvert.isEmpty(loginReq.getPassword())) {
            LOGGER.error("userName or password is null");

            loginResp.setRetCode(RetCode.FAILED);

            LOGGER.debug("loginResp=" + loginResp);

            LOGGER.info("login OUT");
            return loginResp;
        }

        User user = null;
        try {
            // 调用dao查询用户是否存在
            user = userDao.findUserByUserName(loginReq.getUserName());
        } catch (Exception e) {
            LOGGER.warn("findUserByUserName failed", e);
        }

        // 用户不存在
        if (user == null) {
            LOGGER.error("user not exsit");

            loginResp.setRetCode(RetCode.USER_NOT_EXSIT);

            LOGGER.debug("loginResp=" + loginResp);

            LOGGER.info("login OUT");
            return loginResp;
        }

        // 判断密码是否正确，取出密码MD5加密后比较结果是否相等
        String key = CfgMgr.sysCfg.getProperty(Constant.KEY_PASSWORD);
        String passwordReq = StringConvert.passwordMD5(loginReq.getPassword(),key);

        // 密码错误
        if (!passwordReq.equals(user.getPassword())) {
            LOGGER.error("password is increct");
            loginResp.setRetCode(RetCode.PASSWORD_INCRECT);
        } else if (Constant.ACTIVE.equals(loginResp.getStatus())) {// 判断用户状态是否禁用
            LOGGER.error("password is inactive");
            loginResp.setRetCode(RetCode.USER_INACTIVE);
        } else {

            // 登录成功
            loginResp.setRetCode(RetCode.SUCCESS);

            // 返回登录信息
            loginResp.setUserName(user.getUserName());
            loginResp.setPassword(user.getPassword());
            loginResp.setRealName(user.getRealName());
        }

        LOGGER.debug("loginResp=" + loginResp);

        LOGGER.info("login OUT");
        return loginResp;
    }
}
