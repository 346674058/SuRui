package com.myit.intf.bean.admin;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 菜单实体类<br>
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Role extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 菜单代码
     */
    private String roleCode;

    /**
     * 菜单名称
     */
    private String roleName;

    /**
     * 说明
     */
    private String annotation;

    public Role() {
    }

    public Role(Long id, String roleName, String roleCode) {
        this.setId(id);
        this.roleName = roleName;
        this.roleCode = roleCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

}
