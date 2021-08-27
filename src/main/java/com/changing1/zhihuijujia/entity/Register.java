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
public class Register {
	private String regId;
	private String regDName;
	private String regDPhoneNum;
	@JsonProperty("regDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date regDate;
	private String regEName;
	private String regEPhoneNum;
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegDName() {
		return regDName;
	}
	public void setRegDName(String regDName) {
		this.regDName = regDName;
	}
	public String getRegDPhoneNum() {
		return regDPhoneNum;
	}
	public void setRegDPhoneNum(String regDPhoneNum) {
		this.regDPhoneNum = regDPhoneNum;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRegEName() {
		return regEName;
	}
	public void setRegEName(String regEName) {
		this.regEName = regEName;
	}
	public String getRegEPhoneNum() {
		return regEPhoneNum;
	}
	public void setRegEPhoneNum(String regEPhoneNum) {
		this.regEPhoneNum = regEPhoneNum;
	}
	@Override
	public String toString() {
		return "Register [regId=" + regId + ", regDName=" + regDName + ", regDPhoneNum=" + regDPhoneNum + ", regDate="
				+ regDate + ", regEName=" + regEName + ", regEPhoneNum=" + regEPhoneNum + "]";
	}
	
}
