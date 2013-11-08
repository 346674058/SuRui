package com.myit.server.model.admin;

import java.io.Serializable;
import java.util.Date;

import com.myit.common.beans.BaseModel;

/**
 * 用户联系人实体类<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public class LinkMan extends BaseModel implements Serializable {
	/**
	 * generate sid
	 */
	private static final long serialVersionUID = -6838676106112859700L;

	/**
	 * 联系人姓名
	 */
	private String name;

	/**
	 * 联系人所属用户
	 */
	private User user;

	/**
	 * 联系人地址
	 */
	private String address;
	/**
	 * 联系人email
	 */
	private String email;

	/**
	 * 联系人电话
	 */
	private String telephone;

	/**
	 * 联系人手机
	 */
	private String mobile;

	public LinkMan() {
	}

	/**
	 * 用户联系人对象初始化
	 * 
	 * @param userName
	 * @param email
	 * @param address
	 * @param telephone
	 * @param mobile
	 */
	public LinkMan(Long id, String name, String address, String email,
			String telephone, String mobile, Date createTime, Date updateTime, String statu) {
		this.setId(id);
		this.setStatus(statu);
		this.setCreateTime(createTime);
		this.setLastModified(updateTime);
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LinkMan [id=" + this.getId() + ", name='" + name + "', address='" + address + "', telephone='" + telephone
				+ "', mobile='" + mobile + "']";
	}

}
