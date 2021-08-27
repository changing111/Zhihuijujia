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
public class PageBean4Elder {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private Elder elder;
	private List<Elder> eldersList;
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
	public Elder getElder() {
		return elder;
	}
	public void setElder(Elder elder) {
		this.elder = elder;
	}
	public List<Elder> getEldersList() {
		return eldersList;
	}
	public void setEldersList(List<Elder> eldersList) {
		this.eldersList = eldersList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	

	
}
