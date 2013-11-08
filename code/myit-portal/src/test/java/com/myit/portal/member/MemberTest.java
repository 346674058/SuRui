package com.myit.portal.member;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.RemoteConnectFailureException;

import com.myit.intf.bean.admin.user.UserLoginReq;
import com.myit.intf.bean.admin.user.UserLoginResp;
import com.myit.intf.service.admin.UserService;

public class MemberTest {
    private final static Logger LOGGER = Logger.getLogger(MemberTest.class);

    // 成功
    public static final String SUCCESS = "000000000";

    // 失败
    public static final String FAILED = "-1";

    // 成功
    public static final String USER_NOT_EXSIT = "000000001";

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("conf/spring/remote-client.xml");

        // IHello helloService = (IHello) context.getBean("helloService");

        UserService userService = (UserService) context.getBean("userService");

        try {
            // String sayHello = helloService.sayHello("zhang san");

            // LOGGER.info("sayHello: " + sayHello);

            UserLoginReq loginReq = new UserLoginReq("admin", "aaa", "aaa");

            UserLoginResp loginResp = userService.login(loginReq);
            LOGGER.info("loginResp=" + loginResp);

            if (loginResp == null) {
                LOGGER.error("login failed");

                return;
            }

            if (!SUCCESS.equals(loginResp.getRetCode())) {
                LOGGER.error("login failed");
            }

        } catch (RemoteConnectFailureException e) {
            LOGGER.warn("Hessian service not start up!", e);
        } catch (Exception e) {
            LOGGER.warn("findUserByUserName failed", e);
        }

    }
}
