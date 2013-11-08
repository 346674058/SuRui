package com.myit.portal.action.bean;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author LiuCongwen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AdvImg implements Serializable {

    /**
     */
    private static final long serialVersionUID = 9112598295153577254L;

    // 广告图片指向的链接
    String href;

    // 广告图片的资源位置
    String src;

    public AdvImg() {
        // TODO Auto-generated constructor stub
    }

    public AdvImg(String href, String src) {
        this.href = href;
        this.src = src;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

}
