/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface ShopGoodsMapper {



	/**
	 * @param shopGoods
	 * @return
	 */
	Integer addShopGoods(ShopGoods shopGoods);

	/**
	 * @param shopGoods
	 * @return
	 */
	Integer deleteShopGoods(ShopGoods shopGoods);

	/**
	 * @param shopGoods
	 * @return
	 */
	Integer updateShopGoods(ShopGoods shopGoods);

	/**
	 * @param shopGoods
	 * @return
	 */
	List<ShopGoods> getShopGoodsListBySId(ShopGoods shopGoods);

	/**
	 * @param shopGoods
	 * @return
	 */
	Integer deleteAllShopGoodsBySId(ShopGoods shopGoods);

	
}
