package com.myit.intf.bean.member;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class LoginReq extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 会员编号 **/
    private String account;

    /** 密码 **/
    private String password;

    public LoginReq() {
    }

    public LoginReq(Long id, String account, String password) {
        this.setId(id);
        this.account = account;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
        LoginReq other = (LoginReq) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LoginReq [id=" + this.getId() + ", account=" + account + ", password=***, appCode=" + this.getAppCode()
                + "]";
    }

}
