/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ShopService implements ShopMapper {
	@Autowired
	ShopMapper shopMapper;

	/**
	 * @param shop
	 * @return
	 */
	public Shop loginShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.loginShop(shop);
	}

	/**
	 * @return
	 */
	public List<Shop> getShopsList() {
		// TODO Auto-generated method stub
		return shopMapper.getShopsList();
	}

	/**
	 * @param shop
	 * @return
	 */
	public Shop nameExists(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.nameExists(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public Integer addShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.addShop(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public Integer deleteShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.deleteShop(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public Integer updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.updateShop(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public Integer getSBalanceBySPhoneNum(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.getSBalanceBySPhoneNum(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public Integer updateSBalance(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.updateSBalance(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public List<Shop> getShopsListByCondition(Shop shop) {
		// TODO Auto-generated method stub
		return shopMapper.getShopsListByCondition(shop);
	}

	/**
	 * @param shop
	 * @return
	 */
	public List<Shop> getShopsListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return shopMapper.getShopsListByInputLike(inputLike);
	}
	


}
