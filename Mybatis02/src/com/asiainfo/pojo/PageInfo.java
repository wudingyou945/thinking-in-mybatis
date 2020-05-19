package com.asiainfo.pojo;

import java.util.List;

public class PageInfo {
	private int pageNumber;
	private int pageSize;
	private int pageStart;
	private long total;
	private List<?> list;
	
	public PageInfo(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	public int getPageStart() {
		return pageSize*(pageNumber-1);
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}


	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
}
