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
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.PageBean4Shop;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.github.pagehelper.PageHelper;

import sun.net.www.content.text.plain;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ShopController {
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopGoodsService shopGoodsService;
	@RequestMapping("/loginShop")
	public Integer loginShop(@RequestBody Shop shop) {
		// TODO Auto-generated method stub
		if(shopService.loginShop(shop)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}
		
	}
	@RequestMapping("/getShopsListByCondition")
	public PageBean4Shop getShopsListByCondition(@RequestBody PageBean4Shop pageBean4Shop) {
		Integer totalCount = shopService.getShopsListByCondition(pageBean4Shop.getShop()).size();
		PageHelper.startPage(pageBean4Shop.getCurrentPage(),pageBean4Shop.getPageSize());
		List<Shop> shopsList = shopService.getShopsListByCondition(pageBean4Shop.getShop());
		pageBean4Shop.setShopsList(shopsList);
		pageBean4Shop.setTotalCount(totalCount);
		return pageBean4Shop;		
	}
	
	@RequestMapping("/getShopsListByInputLike")
	public PageBean4Shop getShopsListByInputLike(@RequestBody PageBean4Shop pageBean4Shop) {
		Integer totalCount = shopService.getShopsListByInputLike(pageBean4Shop.getInputLike()).size();
		PageHelper.startPage(pageBean4Shop.getCurrentPage(),pageBean4Shop.getPageSize());
		List<Shop> shopsList = shopService.getShopsListByInputLike(pageBean4Shop.getInputLike());
		pageBean4Shop.setShopsList(shopsList);
		pageBean4Shop.setTotalCount(totalCount);
		return pageBean4Shop;	
	}
	@RequestMapping("/addShop")
	public Integer addShop(@RequestBody Shop shop) {
		// TODO Auto-generated method stub
		shop.setsId(String.valueOf(System.currentTimeMillis()));
		shop.setsBalance(0);
		if (shopService.nameExists(shop)!=null) {
			return 2;//用户名id已存在
		}else{
			return shopService.addShop(shop);
		}
	}
	
	@RequestMapping("/getShopBySPhoneNum")
	public Shop getShopBySPhoneNum(@RequestBody Shop shop) {
		// TODO Auto-generated method stub
		return shopService.nameExists(shop);

	}
	
	
	@RequestMapping("/deleteShop")
	public Integer deleteShop(@RequestBody Shop shop) {
		// TODO Auto-generated method stub
		ShopGoods shopGoods = new ShopGoods();
		shopGoods.setsId(shop.getsId());
		Integer deleteNum=shopGoodsService.deleteAllShopGoodsBySId(shopGoods);
		return shopService.deleteShop(shop);		
	}
	
	@RequestMapping("/updateShop")
	public Integer updateShop(@RequestBody Shop shop) {
		// TODO Auto-generated method stub
		return shopService.updateShop(shop);		
	}
	
}
