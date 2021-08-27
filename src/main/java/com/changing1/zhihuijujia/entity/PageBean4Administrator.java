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
public class PageBean4Administrator {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private Administrator administrator;
	private List<Administrator> administratorsList;
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
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	public List<Administrator> getAdministratorsList() {
		return administratorsList;
	}
	public void setAdministratorsList(List<Administrator> administratorsList) {
		this.administratorsList = administratorsList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	

	
}
