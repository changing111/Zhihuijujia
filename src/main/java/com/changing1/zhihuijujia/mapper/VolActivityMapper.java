/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolActivity;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface VolActivityMapper {

	/**
	 * @param volActivity
	 * @return
	 */
	List<VolActivity> getVolActivitysListByVsId(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	Integer addVolActivity(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	Integer deleteVolActivity(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	Integer updateVolActivityVaRemNum(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	Integer updateVolActivityVaState(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	List<VolActivity> getVolActivitysListByVaEPhoneNum(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	VolActivity getVolActivityByVaId(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	List<VolActivity> getVolActivitysListByCondition(VolActivity volActivity);

	/**
	 * @param inputLike
	 * @return
	 */
	List<VolActivity> getVolActivitysListByInputLike(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	List<VolActivity> getVolActivitysListByEPhoneAndCondition(VolActivity volActivity);

	/**
	 * @param volActivity
	 * @return
	 */
	List<VolActivity> getVolActivitysListByEPhoneAndInputLike(VolActivity volActivity);

}
