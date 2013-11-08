package com.myit.common.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体对象<br>
 * 
 * @author created by LiuCongwen at 2012-4-28
 * @version 1.0.0
 */
public class BaseModel implements Serializable {
    /** sid **/
    private static final long serialVersionUID = 8299237382951704365L;

    /** 主键id **/
    private Long id;

    /** action标识符 **/
    private String action;

    /** 其他标识符 **/
    private String tag;

    /** 起始时间 **/
    private Date startTime;

    /** 截至时间 **/
    private Date endTime;

    /** 创建时间 **/
    private Date createTime;

    /** 最后修改时间 **/
    private Date lastModified;

    /** 最后修改人员 **/
    private String lastModifier;

    /** 状态，（-1：禁用，0：启用） **/
    private String status;
    
    /** 返回码 **/
    private String retCode;

    /** 应用代码 **/
    private String appCode;

    public BaseModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

}
