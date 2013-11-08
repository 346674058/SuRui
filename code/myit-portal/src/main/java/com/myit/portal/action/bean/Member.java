package com.myit.portal.action.bean;

import java.io.Serializable;

public class Member implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8491761251624784266L;

    /** 会员编号 **/
    private String memberNo;

    // 会员昵称
    String nick;

    // 性别
    String gender;

    // 生日
    String birthday;

    // 手机
    String mobile;

    // 地址
    String address;

    public Member() {
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
