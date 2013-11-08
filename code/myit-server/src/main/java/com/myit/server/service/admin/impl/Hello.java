package com.myit.server.service.admin.impl;

import org.springframework.stereotype.Service;

import com.myit.intf.service.IHello;

@Service("helloService")
public class Hello implements IHello {

    public String sayHello() {
        return "Hello world";
    }

    public String sayHello(String userName) {
        return "Hello world, " + userName;
    }

}
