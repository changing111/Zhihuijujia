/**
 * 
 */
package com.changing1.zhihuijujia.entity;

import java.util.List;


/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class PageBean4ShopGoods {
	private Integer pageSize;
	private Integer currentPage;
	private Integer totalCount;
	private ShopGoods shopGoods;
	private List<ShopGoods> shopGoodsList;
	private String inputLike;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}
	public List<ShopGoods> getShopGoodsList() {
		return shopGoodsList;
	}
	public void setShopGoodsList(List<ShopGoods> shopGoodsList) {
		this.shopGoodsList = shopGoodsList;
	}
	public String getInputLike() {
		return inputLike;
	}
	public void setInputLike(String inputLike) {
		this.inputLike = inputLike;
	}
	
	

	
}
