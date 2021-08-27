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
public class Volunteer {
	private String vId;
	private String vName;
	private String vGender;
	private String vPhone;
	private String vPassword;
	private String vJob;
	private Integer vHour;
	private String vVsId;
	private String vVsName;
	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvGender() {
		return vGender;
	}
	public void setvGender(String vGender) {
		this.vGender = vGender;
	}
	public String getvPhone() {
		return vPhone;
	}
	public void setvPhone(String vPhone) {
		this.vPhone = vPhone;
	}
	public String getvPassword() {
		return vPassword;
	}
	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	public String getvJob() {
		return vJob;
	}
	public void setvJob(String vJob) {
		this.vJob = vJob;
	}
	public Integer getvHour() {
		return vHour;
	}
	public void setvHour(Integer vHour) {
		this.vHour = vHour;
	}
	public String getvVsId() {
		return vVsId;
	}
	public void setvVsId(String vVsId) {
		this.vVsId = vVsId;
	}
	public String getvVsName() {
		return vVsName;
	}
	public void setvVsName(String vVsName) {
		this.vVsName = vVsName;
	}
	@Override
	public String toString() {
		return "Volunteer [vId=" + vId + ", vName=" + vName + ", vGender=" + vGender + ", vPhone=" + vPhone
				+ ", vPassword=" + vPassword + ", vJob=" + vJob + ", vHour=" + vHour + ", vVsId=" + vVsId + ", vVsName="
				+ vVsName + "]";
	}
	
}
