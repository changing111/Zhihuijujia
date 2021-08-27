/**
 * 
 */
package com.changing1.zhihuijujia.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class BalanceRecord {
	private Integer bId;
	private String bName;
	private String bPhoneNum;
	private String bReason;
	private Integer bBeforeBal;
	private Integer bAfterBal;
	private String bCardNum;
	private String bCardName;
	@JsonProperty("bTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date bTime;
	private String bState;
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbPhoneNum() {
		return bPhoneNum;
	}
	public void setbPhoneNum(String bPhoneNum) {
		this.bPhoneNum = bPhoneNum;
	}
	public String getbReason() {
		return bReason;
	}
	public void setbReason(String bReason) {
		this.bReason = bReason;
	}
	public Integer getbBeforeBal() {
		return bBeforeBal;
	}
	public void setbBeforeBal(Integer bBeforeBal) {
		this.bBeforeBal = bBeforeBal;
	}
	public Integer getbAfterBal() {
		return bAfterBal;
	}
	public void setbAfterBal(Integer bAfterBal) {
		this.bAfterBal = bAfterBal;
	}
	public String getbCardNum() {
		return bCardNum;
	}
	public void setbCardNum(String bCardNum) {
		this.bCardNum = bCardNum;
	}
	public String getbCardName() {
		return bCardName;
	}
	public void setbCardName(String bCardName) {
		this.bCardName = bCardName;
	}
	public Date getbTime() {
		return bTime;
	}
	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}
	public String getbState() {
		return bState;
	}
	public void setbState(String bState) {
		this.bState = bState;
	}
	
	
}
