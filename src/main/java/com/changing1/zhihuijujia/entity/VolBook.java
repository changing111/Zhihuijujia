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
public class VolBook {
	private String vbId;
	private String vbVName;
	private String vbVPhoneNum;
	private String vbVaId;
	private String vbVaName;
	@JsonProperty("vbVaTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+0")
	private Date vbVaTime;
	private Integer vbVaHourNum;
	private String vbEName;
	private String vbEPhoneNum;
	private String vbState;
	public String getVbId() {
		return vbId;
	}
	public void setVbId(String vbId) {
		this.vbId = vbId;
	}
	public String getVbVName() {
		return vbVName;
	}
	public void setVbVName(String vbVName) {
		this.vbVName = vbVName;
	}
	public String getVbVPhoneNum() {
		return vbVPhoneNum;
	}
	public void setVbVPhoneNum(String vbVPhoneNum) {
		this.vbVPhoneNum = vbVPhoneNum;
	}
	public String getVbVaId() {
		return vbVaId;
	}
	public void setVbVaId(String vbVaId) {
		this.vbVaId = vbVaId;
	}
	public String getVbVaName() {
		return vbVaName;
	}
	public void setVbVaName(String vbVaName) {
		this.vbVaName = vbVaName;
	}
	public Date getVbVaTime() {
		return vbVaTime;
	}
	public void setVbVaTime(Date vbVaTime) {
		this.vbVaTime = vbVaTime;
	}
	public Integer getVbVaHourNum() {
		return vbVaHourNum;
	}
	public void setVbVaHourNum(Integer vbVaHourNum) {
		this.vbVaHourNum = vbVaHourNum;
	}
	public String getVbEName() {
		return vbEName;
	}
	public void setVbEName(String vbEName) {
		this.vbEName = vbEName;
	}
	public String getVbEPhoneNum() {
		return vbEPhoneNum;
	}
	public void setVbEPhoneNum(String vbEPhoneNum) {
		this.vbEPhoneNum = vbEPhoneNum;
	}
	public String getVbState() {
		return vbState;
	}
	public void setVbState(String vbState) {
		this.vbState = vbState;
	}

	
	
}
