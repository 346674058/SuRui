package com.myit.admin.bean;

import java.io.Serializable;
import java.util.List;

public class Modual implements Serializable {

    /**
     */
    private static final long serialVersionUID = -9163952694472116248L;

    // 模块id
    Long id;

    // 模块名称
    String name;

    // 模块图标
    String icon;

    // 扩展信息
    String extInfo;

    // 菜单列表
    List<Menu> menus;

    public Modual() {
        // TODO Auto-generated constructor stub
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}
