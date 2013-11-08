package com.myit.portal.action.bean;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    /**
     */
    private static final long serialVersionUID = 861600681927755548L;

    String title;

    List<List<Commodity>> groups;

    public Category() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<List<Commodity>> getGroups() {
        return groups;
    }

    public void setGroups(List<List<Commodity>> groups) {
        this.groups = groups;
    }

}
