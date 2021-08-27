/**
 * 
 */
package com.changing1.zhihuijujia.entity;

/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class Doctor {
	private String dId;
	private String dName;
	private String dGender;
	private String dPhoneNum;
	private String dContent;
	private String dOId;
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdGender() {
		return dGender;
	}
	public void setdGender(String dGender) {
		this.dGender = dGender;
	}
	public String getdPhoneNum() {
		return dPhoneNum;
	}
	public void setdPhoneNum(String dPhoneNum) {
		this.dPhoneNum = dPhoneNum;
	}
	public String getdContent() {
		return dContent;
	}
	public void setdContent(String dContent) {
		this.dContent = dContent;
	}
	public String getdOId() {
		return dOId;
	}
	public void setdOId(String dOId) {
		this.dOId = dOId;
	}
	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", dName=" + dName + ", dGender=" + dGender + ", dPhoneNum=" + dPhoneNum
				+ ", dContent=" + dContent + ", dOId=" + dOId + "]";
	}
	
}
