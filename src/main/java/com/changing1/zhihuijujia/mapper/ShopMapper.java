/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface ShopMapper {

	/**登录验证
	 * @param shop
	 * @return
	 */
	Shop loginShop(Shop shop);

	/**查询所有商户服务
	 * @return
	 */
	List<Shop> getShopsList();

	/**新增商户时查询是否已存在
	 * @param shop
	 * @return
	 */
	Shop nameExists(Shop shop);

	/**新增商户
	 * @param shop
	 * @return
	 */
	Integer addShop(Shop shop);

	/**删除商户
	 * @param shop
	 * @return
	 */
	Integer deleteShop(Shop shop);

	/**更新商户信息
	 * @param shop
	 * @return
	 */
	Integer updateShop(Shop shop);

	/**
	 * @param shop
	 * @return
	 */
	Integer getSBalanceBySPhoneNum(Shop shop);

	/**
	 * @param shop
	 * @return
	 */
	Integer updateSBalance(Shop shop);

	/**
	 * @param shop
	 * @return
	 */
	List<Shop> getShopsListByCondition(Shop shop);

	/**
	 * @param shop
	 * @return
	 */
	List<Shop> getShopsListByInputLike(@Param ("inputLike") String inputLike);

}
