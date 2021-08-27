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
public class Office {
	private String oId;
	private String oName;
	private String oHId;
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getoName() {
		return oName;
	}
	public void setoName(String oName) {
		this.oName = oName;
	}
	public String getoHId() {
		return oHId;
	}
	public void setoHId(String oHId) {
		this.oHId = oHId;
	}
	@Override
	public String toString() {
		return "Office [oId=" + oId + ", oName=" + oName + ", oHId=" + oHId + "]";
	}
	
	
}
