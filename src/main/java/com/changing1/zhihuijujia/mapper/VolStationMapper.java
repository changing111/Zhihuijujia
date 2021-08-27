/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolStation;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface VolStationMapper {

	/**
	 * @param volStation
	 * @return
	 */
	VolStation loginVolStation(VolStation volStation);

	/**
	 * @param volStation
	 * @return
	 */
	VolStation nameExists(VolStation volStation);

	/**
	 * @param volStation
	 * @return
	 */
	Integer deleteVolStation(VolStation volStation);

	/**
	 * @param volStation
	 * @return
	 */
	Integer addVolStation(VolStation volStation);

	/**
	 * @param volStation
	 * @return
	 */
	Integer updateVolStation(VolStation volStation);

	/**
	 * @param volStation
	 * @return
	 */
	List<VolStation> getVolStationsListByCondition(VolStation volStation);

	/**
	 * @param inputLike
	 * @return
	 */
	List<VolStation> getVolStationsListByInputLike(String inputLike);

	/**
	 * @param volStation
	 * @return
	 */
	VolStation getVolStationByVsAdminPhone(VolStation volStation);

}
