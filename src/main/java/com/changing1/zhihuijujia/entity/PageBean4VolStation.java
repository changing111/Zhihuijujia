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
public class PageBean4VolStation {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private VolStation volStation;
	private List<VolStation> volStationsList;
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
	public VolStation getVolStation() {
		return volStation;
	}
	public void setVolStation(VolStation volStation) {
		this.volStation = volStation;
	}
	public List<VolStation> getVolStationsList() {
		return volStationsList;
	}
	public void setVolStationsList(List<VolStation> volStationsList) {
		this.volStationsList = volStationsList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	

	
}
