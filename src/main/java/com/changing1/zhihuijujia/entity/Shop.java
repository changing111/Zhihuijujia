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
public class Shop {
	private String sId;
	private String sName;
	private String sHostName;
	private String sHostCard;
	private String sPhoneNum;
	private String sPassword;
	private String sCity;
	private String sAddress;
	private Integer sBalance;
	public String getsHostName() {
		return sHostName;
	}
	public void setsHostName(String sHostName) {
		this.sHostName = sHostName;
	}
	public String getsHostCard() {
		return sHostCard;
	}
	public void setsHostCard(String sHostCard) {
		this.sHostCard = sHostCard;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPhoneNum() {
		return sPhoneNum;
	}
	public void setsPhoneNum(String sPhoneNum) {
		this.sPhoneNum = sPhoneNum;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public Integer getsBalance() {
		return sBalance;
	}
	public void setsBalance(Integer sBalance) {
		this.sBalance = sBalance;
	}
}
