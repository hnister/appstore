package com.grizzly.utils;

import java.util.List;

public class PageInfo<T> {

	private int pageNow = 1; 
	private int pageSize = 5; 
	private int totalePage; 
	private int count; 
	private List<T> list; 

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalePage() {
		return totalePage;
	}

	public void setTotalePage(int totalePage) {
		this.totalePage = totalePage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		if (count > 0) {
			this.totalePage = count % this.pageSize == 0 ? count / this.pageSize : count / this.pageSize + 1;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
