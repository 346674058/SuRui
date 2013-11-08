package com.myit.admin.bean;

import java.io.Serializable;

public class User implements Serializable {

    /**
     */
    private static final long serialVersionUID = 6351779149722356105L;

    // 用户名
    String userName;

    // 密码
    String password;
    
    // 密码
    String realName;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRealName() {
        return realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }

}
