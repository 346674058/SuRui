package com.myit.server.model.provider;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class ProvidDispatch extends BaseModel implements Serializable {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    /** 会员账户 **/
    private String account;

    /** 密码 **/
    private String password;

    /** 昵称 **/
    private String nick;

    /** 性别 **/
    private String sex;

    /** 生日 **/
    private Date birthday;

    /** 省 **/
    private String province;
    /** 市 **/
    private String city;
    /** 区县 **/
    private String area;

    /** 地址 **/
    private String address;

    /** 电子邮件 **/
    private String email;

    /** 手机 **/
    private String mobile;

    /** 上次登录时间 **/
    private Timestamp lastLoginTime;

    /** 手机 **/
    private String lastLoginIp;

    public ProvidDispatch() {
    }

    public ProvidDispatch(Long id, String account, String nick, String sex, Timestamp birthday, String province,
            String city, String area, String address, String email, String telephone, String mobile) {
        this.setId(id);
        this.account = account;
        this.nick = nick;
        this.sex = sex;
        this.birthday = birthday;
        this.province = province;
        this.city = city;
        this.area = area;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
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
        result = prime * result + (int) (this.getId() ^ (this.getId() >>> 32));
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
        ProvidDispatch other = (ProvidDispatch) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Custom [id=" + this.getId() + ", account=" + account + ", nick=" + nick + ", sex=" + sex
                + ", birthday=" + birthday + ", province=" + province + ", city=" + city + ", area=" + area
                + ", address=" + address + ", email=" + email + ", mobile=" + mobile + "]";
    }

}
