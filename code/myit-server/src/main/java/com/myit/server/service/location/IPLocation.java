package com.myit.server.service.location;

/**
 * 
 * IP地址类<br>
 * 用来封装ip相关信息，目前只有两个字段，ip所在的国家和地区
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IPLocation {
    private String country;
    private String area;

    public IPLocation() {
        country = area = "";
    }

    public IPLocation getCopy() {
        IPLocation ret = new IPLocation();
        ret.country = country;
        ret.area = area;
        return ret;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        // 如果为局域网，纯真IP地址库的地区会显示CZ88.NET,这里把它去掉
        if (area.trim().equals("CZ88.NET")) {
            this.area = "本机或本网络";
        } else {
            this.area = area;
        }
    }
}
