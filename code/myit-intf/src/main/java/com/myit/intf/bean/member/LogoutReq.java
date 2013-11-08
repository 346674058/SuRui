package com.myit.intf.bean.member;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 用户实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class LogoutReq extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /** 会员编号 **/
    private String memberNo;

    public LogoutReq() {
    }

    public LogoutReq(String memberNo) {
        this.memberNo = memberNo;
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
        LogoutReq other = (LogoutReq) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LogoutReq [id=" + this.getId() + ", memberNo=" + memberNo + ", appCode="
                + this.getAppCode() + "]";
    }

}
