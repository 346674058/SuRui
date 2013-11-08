package com.myit.intf.bean.admin;

import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class UserEvt extends BaseModel {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    /** 用户名 **/
    private String userName;

    /** 密码 **/
    private String password;

    /** 真实姓名 **/
    private String realName;

    /** 性别 **/
    private String sex;

    /** 生日 **/
    private Date birthday;

    public UserEvt() {
    }

    /**
     * 初始化用户实体
     * 
     * @param id
     * @param userName
     * @param password
     * @param realName
     * @param sex
     * @param birthday
     */
    public UserEvt(Long id, String userName, String password, String realName, String sex, Date birthday, Date createTime,
            Date updateTime, String statu) {
        this.setId(id);
        this.setStatus(statu);
        this.setCreateTime(createTime);
        this.setLastModified(updateTime);

        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "UserEvt [id=" + this.getId() + ", userName='" + userName + "', password='" + password + "', realName='"
                + realName + "', sex='" + sex + "', birthday='" + birthday + "']";
    }
}
