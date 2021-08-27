/**
 * 
 */
package com.changing1.zhihuijujia.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class Elder {
	private String eId;
	private String eName;
	private String ePhoneNum;
	private String ePassword;
	private String eGender;
	private String eCity;
	private String eResidence;
	private String eMarriage;
	private String eAddress;
	@JsonProperty("eBirth")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date eBirth;
	private Integer eAge;
	private String eFamilyName;
	private String eFamilyPhone;
	private String eFamilyRelation;
	private String eBloodType;
	private String eDisable;
	private Integer eBalance;
	private Integer eIncome;
	private String eIdCard;
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getePhoneNum() {
		return ePhoneNum;
	}
	public void setePhoneNum(String ePhoneNum) {
		this.ePhoneNum = ePhoneNum;
	}
	public String getePassword() {
		return ePassword;
	}
	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	public String geteGender() {
		return eGender;
	}
	public void seteGender(String eGender) {
		this.eGender = eGender;
	}
	public String geteCity() {
		return eCity;
	}
	public void seteCity(String eCity) {
		this.eCity = eCity;
	}
	public String geteResidence() {
		return eResidence;
	}
	public void seteResidence(String eResidence) {
		this.eResidence = eResidence;
	}
	public String geteMarriage() {
		return eMarriage;
	}
	public void seteMarriage(String eMarriage) {
		this.eMarriage = eMarriage;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	public Date geteBirth() {
		return eBirth;
	}
	public void seteBirth(Date eBirth) {
		this.eBirth = eBirth;
	}
	public Integer geteAge() {
		return eAge;
	}
	public void seteAge(Integer eAge) {
		this.eAge = eAge;
	}
	public String geteFamilyName() {
		return eFamilyName;
	}
	public void seteFamilyName(String eFamilyName) {
		this.eFamilyName = eFamilyName;
	}
	public String geteFamilyPhone() {
		return eFamilyPhone;
	}
	public void seteFamilyPhone(String eFamilyPhone) {
		this.eFamilyPhone = eFamilyPhone;
	}
	public String geteFamilyRelation() {
		return eFamilyRelation;
	}
	public void seteFamilyRelation(String eFamilyRelation) {
		this.eFamilyRelation = eFamilyRelation;
	}
	public String geteBloodType() {
		return eBloodType;
	}
	public void seteBloodType(String eBloodType) {
		this.eBloodType = eBloodType;
	}
	public String geteDisable() {
		return eDisable;
	}
	public void seteDisable(String eDisable) {
		this.eDisable = eDisable;
	}
	public Integer geteBalance() {
		return eBalance;
	}
	public void seteBalance(Integer eBalance) {
		this.eBalance = eBalance;
	}
	public Integer geteIncome() {
		return eIncome;
	}
	public void seteIncome(Integer eIncome) {
		this.eIncome = eIncome;
	}
	public String geteIdCard() {
		return eIdCard;
	}
	public void seteIdCard(String eIdCard) {
		this.eIdCard = eIdCard;
	}
	
}
