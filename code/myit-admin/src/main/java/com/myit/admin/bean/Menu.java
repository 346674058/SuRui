package com.myit.admin.bean;

import java.io.Serializable;

public class Menu implements Serializable {

    /**
     */
    private static final long serialVersionUID = -9163952694472116248L;

    // 菜单名称
    String name;

    // 菜单图标
    String icon;

    // 菜单链接
    String href;

    // 菜单描述
    String title;

    public Menu() {
        // TODO Auto-generated constructor stub
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

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
