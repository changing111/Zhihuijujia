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
public class Remain {
	private String remId;
	private String remDPhoneNum;
	private String remDName;
	@JsonProperty("remDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date remDate;
	private Integer remSum;
	private Integer remNum;
	public String getRemId() {
		return remId;
	}
	public void setRemId(String remId) {
		this.remId = remId;
	}
	public String getRemDPhoneNum() {
		return remDPhoneNum;
	}
	public void setRemDPhoneNum(String remDPhoneNum) {
		this.remDPhoneNum = remDPhoneNum;
	}
	public String getRemDName() {
		return remDName;
	}
	public void setRemDName(String remDName) {
		this.remDName = remDName;
	}
	public Date getRemDate() {
		return remDate;
	}
	public void setRemDate(Date remDate) {
		this.remDate = remDate;
	}
	public Integer getRemSum() {
		return remSum;
	}
	public void setRemSum(Integer remSum) {
		this.remSum = remSum;
	}
	public Integer getRemNum() {
		return remNum;
	}
	public void setRemNum(Integer remNum) {
		this.remNum = remNum;
	}
	@Override
	public String toString() {
		return "Remain [remId=" + remId + ", remDPhoneNum=" + remDPhoneNum + ", remDName=" + remDName + ", remDate="
				+ remDate + ", remSum=" + remSum + ", remNum=" + remNum + "]";
	}
	
	
	
}
