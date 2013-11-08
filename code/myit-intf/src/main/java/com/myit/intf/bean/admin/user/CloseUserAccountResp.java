package com.myit.intf.bean.admin.user;

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
public class CloseUserAccountResp extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 会员编号 **/
    private String memberNo;

    /** 密码 **/
    private String password;

    /** 客户姓名 **/
    private String realName;

    /** 性别 **/
    private String sex;

    /** 生日 **/
    private Date birthday;

    /** 省份Id **/
    private String provinceId;

    /** 城市Id **/
    private String cityId;

    /** 区县Id **/
    private String countyId;

    /** 详细地址 **/
    private String address;

    /** 电子邮件 **/
    private String email;

    /** 手机 **/
    private String mobile;

    /** 上次登录时间 **/
    private Timestamp lastLoginTime;
    /** 手机 **/
    private String lastLoginIp;

    public CloseUserAccountResp() {
    }

    public CloseUserAccountResp(Long id, String memberNo, String realName, String sex, Timestamp birthday, String provinceId,
            String cityId, String countyId, String address, String email, String telephone, String mobile) {
        this.setId(id);
        this.memberNo = memberNo;
        this.realName = realName;
        this.sex = sex;
        this.birthday = birthday;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.countyId = countyId;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
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
        CloseUserAccountResp other = (CloseUserAccountResp) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Custom [id=" + this.getId() + ", memberNo=" + memberNo + ", realName=" + realName + ", sex=" + sex
                + ", birthday=" + birthday + ", provinceId=" + provinceId + ", cityId=" + cityId + ", countyId="
                + countyId + ", address=" + address + ", email=" + email + ", mobile=" + mobile + "]";
    }

}
