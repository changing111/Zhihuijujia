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
public class Hospital {
	private String hId;
	private String hName;
	private String hCity;
	private String hAddress;
	private String hPhoneNum;
	private String hBus;
	private String hContent;
	private String hAdminPhone;
	private String hAdminPassword;
	public String gethId() {
		return hId;
	}
	public void sethId(String hId) {
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public String gethCity() {
		return hCity;
	}
	public void sethCity(String hCity) {
		this.hCity = hCity;
	}
	public String gethAddress() {
		return hAddress;
	}
	public void sethAddress(String hAddress) {
		this.hAddress = hAddress;
	}
	public String gethPhoneNum() {
		return hPhoneNum;
	}
	public void sethPhoneNum(String hPhoneNum) {
		this.hPhoneNum = hPhoneNum;
	}
	public String gethBus() {
		return hBus;
	}
	public void sethBus(String hBus) {
		this.hBus = hBus;
	}
	public String gethContent() {
		return hContent;
	}
	public void sethContent(String hContent) {
		this.hContent = hContent;
	}
	public String gethAdminPhone() {
		return hAdminPhone;
	}
	public void sethAdminPhone(String hAdminPhone) {
		this.hAdminPhone = hAdminPhone;
	}
	public String gethAdminPassword() {
		return hAdminPassword;
	}
	public void sethAdminPassword(String hAdminPassword) {
		this.hAdminPassword = hAdminPassword;
	}
	@Override
	public String toString() {
		return "Hospital [hId=" + hId + ", hName=" + hName + ", hCity=" + hCity + ", hAddress=" + hAddress
				+ ", hPhoneNum=" + hPhoneNum + ", hBus=" + hBus + ", hContent=" + hContent + ", hAdminPhone="
				+ hAdminPhone + ", hAdminPassword=" + hAdminPassword + "]";
	}
	
}
