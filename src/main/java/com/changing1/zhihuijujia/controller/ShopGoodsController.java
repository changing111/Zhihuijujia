/**
 * 
 */
package com.changing1.zhihuijujia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.PageBean4ShopGoods;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.entity.VolActivity;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ShopGoodsController {
	@Autowired
	private ShopGoodsService shopGoodsService;
	@RequestMapping("/getShopGoodsListBySId")
	public List<ShopGoods> getShopGoodsListBySId(@RequestBody ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsService.getShopGoodsListBySId(shopGoods);		
	}
	
	@RequestMapping("/addShopGoods")
	public Integer addShopGoods(@RequestBody ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		shopGoods.setSgId(String.valueOf(System.currentTimeMillis()));
		return shopGoodsService.addShopGoods(shopGoods);	
	}
	
	@RequestMapping("/deleteShopGoods")
	public Integer deleteShopGoods(@RequestBody ShopGoods ShopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsService.deleteShopGoods(ShopGoods);		
	}
	
	@RequestMapping("/updateShopGoods")
	public Integer updateShopGoods(@RequestBody ShopGoods ShopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsService.updateShopGoods(ShopGoods);		
	}
	
	@RequestMapping("/deleteAllShopGoodsBySId")
	public Integer deleteAllShopGoodsBySId(@RequestBody ShopGoods ShopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsService.deleteAllShopGoodsBySId(ShopGoods);//返回数字是删除条数		
	}
	
}
