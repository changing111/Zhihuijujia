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
public class PageBean4VolActivity {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private VolActivity volActivity;
	private List<VolActivity> volActivitysList;
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
	public VolActivity getVolActivity() {
		return volActivity;
	}
	public void setVolActivity(VolActivity volActivity) {
		this.volActivity = volActivity;
	}
	public List<VolActivity> getVolActivitysList() {
		return volActivitysList;
	}
	public void setVolActivitysList(List<VolActivity> volActivitysList) {
		this.volActivitysList = volActivitysList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	
	

	
}
