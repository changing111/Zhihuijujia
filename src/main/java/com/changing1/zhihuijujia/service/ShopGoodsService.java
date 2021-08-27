/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopGoodsMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ShopGoodsService implements ShopGoodsMapper {
	@Autowired
	ShopGoodsMapper shopGoodsMapper;



	/**
	 * @param shopGoods
	 * @return
	 */
	public Integer addShopGoods(ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsMapper.addShopGoods(shopGoods);
	}

	/**
	 * @param shopGoods
	 * @return
	 */
	public Integer deleteShopGoods(ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsMapper.deleteShopGoods(shopGoods);
	}

	/**
	 * @param shopGoods
	 * @return
	 */
	public Integer updateShopGoods(ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsMapper.updateShopGoods(shopGoods);
	}

	/**
	 * @param shopGoods
	 * @return
	 */
	public List<ShopGoods> getShopGoodsListBySId(ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsMapper.getShopGoodsListBySId(shopGoods);
	}

	/**删除一个商户所有商品
	 * @param shopGoods
	 * @return 
	 */
	public Integer deleteAllShopGoodsBySId(ShopGoods shopGoods) {
		// TODO Auto-generated method stub
		return shopGoodsMapper.deleteAllShopGoodsBySId(shopGoods);
	}

	


}
