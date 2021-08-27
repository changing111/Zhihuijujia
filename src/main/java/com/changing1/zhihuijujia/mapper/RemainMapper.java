/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Remain;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface RemainMapper {

	/**
	 * @param remain
	 * @return
	 */
	List<Remain> getRemainsListByDPhoneNum(Remain remain);

	/**
	 * @param remain
	 * @return
	 */
	Integer addRemain(Remain remain);

	/**
	 * @param remain
	 * @return
	 */
	Integer deleteRemain(Remain remain);

	/**
	 * @param remain
	 * @return
	 */
	Remain nameExists(Remain remain);


	/**
	 * @param remain
	 * @return
	 */
	Integer updateRemain(Remain remain);

	
}
