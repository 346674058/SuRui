package com.myit.intf.bean.admin;

import java.io.Serializable;
import java.util.List;

import com.myit.common.beans.BaseModel;

/**
 * 菜单实体类<br>
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Menu extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 菜单代码
     */
    private String menuCode;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单链接
     */
    private String href;

    /**
     * 菜单层级
     */
    private Integer level;

    /**
     * 说明
     */
    private String annotation;

    /**
     * 父菜单id
     */
    private Long pId;

    /**
     * 父菜单id
     */
    private String pName;

    /**
     * 子菜单
     */
    private List<Menu> childMenus;

    /**
     * 排列顺序
     */
    private Integer orderIndex;

    public Menu() {
    }

    public Menu(Long id, String menuName, String href) {
        this.setId(id);
        this.menuName = menuName;
        this.href = href;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public boolean equals(Object obj) {
        Menu target = (Menu) obj;
        return this.getId().intValue() == target.getId().intValue();
    };

    @Override
    public String toString() {
        return "Menu [menuCode=" + menuCode + ", menuName=" + menuName + ", href=" + href + ", level=" + level
                + ", annotation=" + annotation + ", orderIndex=" + orderIndex + "]";
    }

}
