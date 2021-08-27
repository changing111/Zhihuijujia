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
public class VolActivity {
	private String vaId;
	private String vaName;
	private String vaVsId;
	private String vaVsName;
	private String vaEName;
	private String vaEPhoneNum;
	@JsonProperty("vaTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+0")
	private Date vaTime;
	private Integer vaHourNum;
	private Integer vaRemSum;
	private Integer vaRemNum;
	private String vaState;
	public String getVaId() {
		return vaId;
	}
	public void setVaId(String vaId) {
		this.vaId = vaId;
	}
	public String getVaName() {
		return vaName;
	}
	public void setVaName(String vaName) {
		this.vaName = vaName;
	}
	public String getVaVsId() {
		return vaVsId;
	}
	public void setVaVsId(String vaVsId) {
		this.vaVsId = vaVsId;
	}
	public String getVaVsName() {
		return vaVsName;
	}
	public void setVaVsName(String vaVsName) {
		this.vaVsName = vaVsName;
	}
	public String getVaEName() {
		return vaEName;
	}
	public void setVaEName(String vaEName) {
		this.vaEName = vaEName;
	}
	public String getVaEPhoneNum() {
		return vaEPhoneNum;
	}
	public void setVaEPhoneNum(String vaEPhoneNum) {
		this.vaEPhoneNum = vaEPhoneNum;
	}
	public Date getVaTime() {
		return vaTime;
	}
	public void setVaTime(Date vaTime) {
		this.vaTime = vaTime;
	}
	public Integer getVaHourNum() {
		return vaHourNum;
	}
	public void setVaHourNum(Integer vaHourNum) {
		this.vaHourNum = vaHourNum;
	}
	public Integer getVaRemSum() {
		return vaRemSum;
	}
	public void setVaRemSum(Integer vaRemSum) {
		this.vaRemSum = vaRemSum;
	}
	public Integer getVaRemNum() {
		return vaRemNum;
	}
	public void setVaRemNum(Integer vaRemNum) {
		this.vaRemNum = vaRemNum;
	}
	public String getVaState() {
		return vaState;
	}
	public void setVaState(String vaState) {
		this.vaState = vaState;
	}
	
	
}
