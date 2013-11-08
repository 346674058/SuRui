package com.myit.intf.bean.admin;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 用户操作日志实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class OperateLogEvt extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 操作类型
     * 
     * @see Constant
     */
    private String opType;

    /**
     * 操作描述
     */
    private String opDscribe;

    public OperateLogEvt() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOpDscribe() {
        return opDscribe;
    }

    public void setOpDscribe(String opDscribe) {
        this.opDscribe = opDscribe;
    }

}
