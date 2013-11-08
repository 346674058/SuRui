package com.myit.server.model.admin;

import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class User extends BaseModel {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 真实姓名 **/
    private String realName;

    /** 联系电话 **/
    private String telephone;

    /** 上次登录时间 **/
    private Date lastLoginTime;

    /** 上次登录ip **/
    private String lastLoginIp;

    /** 性别 **/
    private String sex;

    /** 生日 **/
    private Date birthday;

    public User() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public String toString() {
        return "User [id=" + this.getId() + ", userName='" + userName + "', password='" + password + "', realName='"
                + realName + "', sex='" + sex + "', birthday='" + birthday + "']";
    }
}
