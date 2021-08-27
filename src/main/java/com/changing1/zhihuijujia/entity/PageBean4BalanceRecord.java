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
public class PageBean4BalanceRecord {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private BalanceRecord balanceRecord;
	private List<BalanceRecord> balanceRecordsList;
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
	public BalanceRecord getBalanceRecord() {
		return balanceRecord;
	}
	public void setBalanceRecord(BalanceRecord balanceRecord) {
		this.balanceRecord = balanceRecord;
	}
	public List<BalanceRecord> getBalanceRecordsList() {
		return balanceRecordsList;
	}
	public void setBalanceRecordsList(List<BalanceRecord> balanceRecordsList) {
		this.balanceRecordsList = balanceRecordsList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	
	

	
}
