package com.chen.entities;

import java.util.List;

public class PageInfo<T> {
	private Integer count;// 总记录数
	private List<T> pageList;// 当前页的记录集合
	private Integer pageIndex;// 当前记录位置
	private Integer currentPage;//当前页码
	private Integer pageSize;//每页记录数
	private Integer totalPages;// 总页数
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PageInfo [count=" + count + ", pageList=" + pageList + ", pageIndex=" + pageIndex + ", currentPage="
				+ currentPage + ", pageSize=" + pageSize + ", totalPages=" + totalPages + "]";
	}
	
	
	

}
