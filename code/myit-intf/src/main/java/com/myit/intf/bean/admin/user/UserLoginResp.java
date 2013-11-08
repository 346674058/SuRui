package com.myit.intf.bean.admin.user;

import java.io.Serializable;
import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 用户登录返回实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class UserLoginResp extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 客户姓名 **/
    private String realName;

    /** 性别 **/
    private String sex;

    /** 生日 **/
    private Date birthday;

    /** 电子邮件 **/
    private String email;

    /** 手机 **/
    private String mobile;

    /** 上次登录时间 **/
    private Date lastLoginTime;

    /** 上次登录ip **/
    private String lastLoginIp;

    public UserLoginResp() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserLoginResp other = (UserLoginResp) obj;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserLoginResp [retCode=" + this.getRetCode() + ", userName=" + userName + ", password=" + password
                + ", realName=" + realName + ", sex=" + sex + ", birthday=" + birthday + ", email=" + email
                + ", mobile=" + mobile + ", lastLoginTime=" + lastLoginTime + ", lastLoginIp=" + lastLoginIp + "]";
    }

}
