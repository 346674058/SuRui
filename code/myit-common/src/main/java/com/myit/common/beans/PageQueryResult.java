package com.myit.common.beans;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果基类<br>
 * @author created by LiuCongwen at 2012-7-5
 * @version 1.0.0
 * @param <T>  查询结果对象模版
 */
public class PageQueryResult<T> implements Serializable {

	private static final long serialVersionUID = 5917514755243948015L;

	/**
	 * 结果集
	 */
	private List<T> Rows;
	
	/**
	 * 总记录数
	 */
	private int total;
	
	/**
	 * 页面号，默认第1页
	 */
	private int pageNo = 1;
	
	/**
	 * 页面大小，默认10条记录
	 */
	private int pageSize = 10;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 起始记录数
	 */
	private int start;
	
	/**
	 * 截至记录数
	 */
	private int end;

	/**
	 * 无参构造函数
	 */
	public PageQueryResult() {
	}

	public PageQueryResult(int total, int pageNo, int pageSize) {
		this.total = total;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		
		//计算其他分页信息
		if (this.pageNo < 1) {
            this.pageNo = 1;
        }
		
        // 如果查询页数大于总页数，则取最后一页
        if (this.total <= (this.pageNo - 1) * this.pageSize) {
            this.pageNo = (this.total + this.pageSize - 1) / this.pageSize;
        }
        
        //起始记录数
        this.start = (this.pageNo - 1) * this.pageSize;
        
        //截至记录数
        this.end = this.start + this.pageSize;
        
        // 总页数
        this.totalPage = (this.total + this.pageSize - 1) / this.pageSize;
	}

	public List<T> getRows() {
		return Rows;
	}

	public void setRows(List<T> Rows) {
		this.Rows = Rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
