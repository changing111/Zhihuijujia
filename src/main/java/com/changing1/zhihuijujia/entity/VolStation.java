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
public class VolStation {
	private String vsId;
	private String vsName;
	private String vsCity;
	private String vsAdminName;
	private String vsAdminPhone;
	private String vsAdminPass;
	private String vsAddress;
	public String getVsAddress() {
		return vsAddress;
	}
	public void setVsAddress(String vsAddress) {
		this.vsAddress = vsAddress;
	}
	public String getVsId() {
		return vsId;
	}
	public void setVsId(String vsId) {
		this.vsId = vsId;
	}
	public String getVsName() {
		return vsName;
	}
	public void setVsName(String vsName) {
		this.vsName = vsName;
	}
	public String getVsCity() {
		return vsCity;
	}
	public void setVsCity(String vsCity) {
		this.vsCity = vsCity;
	}
	public String getVsAdminName() {
		return vsAdminName;
	}
	public void setVsAdminName(String vsAdminName) {
		this.vsAdminName = vsAdminName;
	}
	public String getVsAdminPhone() {
		return vsAdminPhone;
	}
	public void setVsAdminPhone(String vsAdminPhone) {
		this.vsAdminPhone = vsAdminPhone;
	}
	public String getVsAdminPass() {
		return vsAdminPass;
	}
	public void setVsAdminPass(String vsAdminPass) {
		this.vsAdminPass = vsAdminPass;
	}
	@Override
	public String toString() {
		return "VolStation [vsId=" + vsId + ", vsName=" + vsName + ", vsCity=" + vsCity + ", vsAdminName=" + vsAdminName
				+ ", vsAdminPhone=" + vsAdminPhone + ", vsAdminPass=" + vsAdminPass + "]";
	}

}
