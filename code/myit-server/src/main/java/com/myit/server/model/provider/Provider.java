package com.myit.server.model.provider;

import java.io.Serializable;

import com.myit.common.beans.BaseModel;

/**
 * 供应商实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class Provider extends BaseModel implements Serializable {
    /** generate sid **/
    private static final long serialVersionUID = -6838676106112859700L;

    // 商户编码
    private String providerCode;
    // 商户名称',
    private String providerName;
    // 商户描述',
    private String providerDescribe;
    // 联系人',
    private String contactor;
    // 联系电话',
    private String mobile;
    // 商户地址',
    private String address;

    public Provider() {
    }

    /**
     * 供应商实体初始化
     * 
     * @param providerCode
     * @param providerName
     * @param providerDescribe
     * @param contactor
     * @param mobile
     * @param address
     */
    public Provider(String providerCode, String providerName, String providerDescribe, String contactor, String mobile,
            String address) {
        super();
        this.providerCode = providerCode;
        this.providerName = providerName;
        this.providerDescribe = providerDescribe;
        this.contactor = contactor;
        this.mobile = mobile;
        this.address = address;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDescribe() {
        return providerDescribe;
    }

    public void setProviderDescribe(String providerDescribe) {
        this.providerDescribe = providerDescribe;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
