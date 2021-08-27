/**
 * 
 */
package com.changing1.zhihuijujia.entity;

import java.util.List;


/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class PageBean4VolBook {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private VolBook volBook;
	private List<VolBook> volBooksList;
	private String inputLike;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public VolBook getVolBook() {
		return volBook;
	}
	public void setVolBook(VolBook volBook) {
		this.volBook = volBook;
	}
	public List<VolBook> getVolBooksList() {
		return volBooksList;
	}
	public void setVolBooksList(List<VolBook> volBooksList) {
		this.volBooksList = volBooksList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	

	
}
