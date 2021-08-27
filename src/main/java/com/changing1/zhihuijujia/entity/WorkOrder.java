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
public class WorkOrder {
	private String wId;
	private String wEName;
	private String wEPhoneNum;
	private String wEAddress;
	private String wSgContent;
	private Integer wSgPrice;
	private String wSName;
	private String wSPhoneNum;
	private String wSCity;
	@JsonProperty("wServiceTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+0")
	private Date wServiceTime;
	private Integer wAmount;
	private Integer wSpend;
	private String wState;
	public String getwId() {
		return wId;
	}
	public void setwId(String wId) {
		this.wId = wId;
	}
	public String getwEName() {
		return wEName;
	}
	public void setwEName(String wEName) {
		this.wEName = wEName;
	}
	public String getwEPhoneNum() {
		return wEPhoneNum;
	}
	public void setwEPhoneNum(String wEPhoneNum) {
		this.wEPhoneNum = wEPhoneNum;
	}
	public String getwEAddress() {
		return wEAddress;
	}
	public void setwEAddress(String wEAddress) {
		this.wEAddress = wEAddress;
	}
	public String getwSgContent() {
		return wSgContent;
	}
	public void setwSgContent(String wSgContent) {
		this.wSgContent = wSgContent;
	}
	public Integer getwSgPrice() {
		return wSgPrice;
	}
	public void setwSgPrice(Integer wSgPrice) {
		this.wSgPrice = wSgPrice;
	}
	public String getwSName() {
		return wSName;
	}
	public void setwSName(String wSName) {
		this.wSName = wSName;
	}
	public String getwSPhoneNum() {
		return wSPhoneNum;
	}
	public void setwSPhoneNum(String wSPhoneNum) {
		this.wSPhoneNum = wSPhoneNum;
	}
	public String getwSCity() {
		return wSCity;
	}
	public void setwSCity(String wSCity) {
		this.wSCity = wSCity;
	}
	public Date getwServiceTime() {
		return wServiceTime;
	}
	public void setwServiceTime(Date wServiceTime) {
		this.wServiceTime = wServiceTime;
	}
	public Integer getwAmount() {
		return wAmount;
	}
	public void setwAmount(Integer wAmount) {
		this.wAmount = wAmount;
	}
	public Integer getwSpend() {
		return wSpend;
	}
	public void setwSpend(Integer wSpend) {
		this.wSpend = wSpend;
	}
	public String getwState() {
		return wState;
	}
	public void setwState(String wState) {
		this.wState = wState;
	}
	
}
