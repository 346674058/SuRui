package com.myit.server.model.admin;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 角色菜单关联实体类<br>
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RoleMenu extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 菜单id
     */
    private Long mId;

    /**
     * 角色id
     */
    private Long rId;

    public RoleMenu() {
    }

    public RoleMenu(Long id, Long mId, Long rId) {
        this.setId(id);
        this.mId = mId;
        this.rId = rId;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

}
