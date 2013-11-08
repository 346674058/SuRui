package com.myit.server.service.location;

/**
 * 
 * ip实体类<br> 
 * 一条IP范围记录，不仅包括国家和区域，也包括起始IP和结束IP
 *
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IPEntry {
    public String beginIp;
    public String endIp;
    public String country;
    public String area;
    
    /**
     * 构造函数
     */
    public IPEntry() {
        beginIp = endIp = country = area = "";
    }
}

