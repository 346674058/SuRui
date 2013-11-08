package com.myit.server.model.baseData;

import java.io.Serializable;
import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 代码快照实体类<br>
 * 
 * @author created by LiuCongwen at 2012-5-24
 * @version 1.0.0
 */
public class CodeGen extends BaseModel implements Serializable {
    /**
     * generate sid
     */
    private static final long serialVersionUID = -6838676106112859700L;
    /**
     * 代码类型
     */
    private String codeType;

    /**
     * 格式模板
     */
    private String genTpl;

    /**
     * 当前值
     */
    private int curValue;

    /**
     * 描述
     */
    private String codeDescribe;

    public CodeGen() {
    }

    /**
     * 初始化代码快照实体
     * 
     * @param id
     * @param codeType
     * @param curValue
     * @param genTpl
     * @param codeDescribe
     */
    public CodeGen(Long id, String codeType, int curValue, String genTpl, String codeDescribe, Date createTime,
            Date updateTime, String statu) {
        this.setId(id);
        this.setStatus(statu);
        this.setCreateTime(createTime);
        this.setLastModified(updateTime);

        this.codeType = codeType;
        this.curValue = curValue;
        this.genTpl = genTpl;
        this.codeDescribe = codeDescribe;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public int getCurValue() {
        return curValue;
    }

    public void setCurValue(int curValue) {
        this.curValue = curValue;
    }

    public String getGenTpl() {
        return genTpl;
    }

    public void setGenTpl(String genTpl) {
        this.genTpl = genTpl;
    }

    public String getCodeDescribe() {
        return codeDescribe;
    }

    public void setCodeDescribe(String codeDescribe) {
        this.codeDescribe = codeDescribe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.getId() ^ (this.getId() >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CodeGen other = (CodeGen) obj;
        if (this.getId() != other.getId())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CodeSnapshot [id=" + this.getId() + ", codeType='" + codeType + "', genTpl='" + genTpl
                + "', curValue=" + curValue + ", codeDescribe='" + codeDescribe + "']";
    }
}
