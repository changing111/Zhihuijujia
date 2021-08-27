/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolStation;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
import com.changing1.zhihuijujia.mapper.VolStationMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolStationService implements VolStationMapper {
	@Autowired
	VolStationMapper volStationMapper;

	/**
	 * @param volStation
	 * @return
	 */
	public VolStation loginVolStation(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.loginVolStation(volStation);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public VolStation nameExists(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.nameExists(volStation);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public Integer addVolStation(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.addVolStation(volStation);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public Integer deleteVolStation(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.deleteVolStation(volStation);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public Integer updateVolStation(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.updateVolStation(volStation);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public List<VolStation> getVolStationsListByCondition(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.getVolStationsListByCondition(volStation);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<VolStation> getVolStationsListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return volStationMapper.getVolStationsListByInputLike(inputLike);
	}

	/**
	 * @param volStation
	 * @return
	 */
	public VolStation getVolStationByVsAdminPhone(VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationMapper.getVolStationByVsAdminPhone(volStation);
	}

}
