package com.myit.common.beans;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 分页查询参数基类<br>
 * 
 * @author created by LiuCongwen at 2012-7-5
 * @version 1.0.0
 * @param <T>
 *            查询对象模版
 */
public class PageQueryParam<T> implements Serializable {

	private static final long serialVersionUID = 4998689924860477205L;

	/**
	 * 页面号，默认第1页
	 */
	private int pageNo = 1;

	/**
	 * 页面大小，默认10条记录
	 */
	private int pageSize = 10;

	/**
	 * 排序字段，格式{{"id","asc"},{"name","asc"}}
	 */
	private String[][] orderBy;

	/**
	 * 查询参数模版
	 */
	private T queryParam;

	/**
	 * 无参构造函数
	 */
	public PageQueryParam() {
	}

	/**
	 * 分页查询参数初始化
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param orderBy
	 * @param queryParam
	 */
	public PageQueryParam(int pageNo, int pageSize, String[][] orderBy,
			T queryParam) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.orderBy = orderBy;
		this.queryParam = queryParam;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String[][] getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String[][] orderBy) {
		this.orderBy = orderBy;
	}

	public T getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(T queryParam) {
		this.queryParam = queryParam;
	}

	@Override
	public String toString() {
		return "PageQueryParam [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", orderBy=" + Arrays.toString(orderBy) + ", queryParam="
				+ queryParam + "]";
	}

}
