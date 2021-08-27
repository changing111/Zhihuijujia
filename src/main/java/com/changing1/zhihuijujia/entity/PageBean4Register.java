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
public class PageBean4Register {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private Register register;
	private List<Register> registersList;
	private String inputLike;
	private String hId;
	
	public String gethId() {
		return hId;
	}
	public void sethId(String hId) {
		this.hId = hId;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	public List<Register> getRegistersList() {
		return registersList;
	}
	public void setRegistersList(List<Register> registersList) {
		this.registersList = registersList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	
	

	
}
