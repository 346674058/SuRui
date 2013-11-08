package com.myit.intf.bean.admin;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 角色菜单关联实体类<br>
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserRole extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 用户id
     */
    private Long uId;

    /**
     * 角色id
     */
    private Long rId;

    public UserRole() {
    }

    public UserRole(Long id, Long uId, Long rId) {
        this.setId(id);
        this.uId = uId;
        this.rId = rId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

}
