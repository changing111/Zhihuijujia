/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolActivity;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
import com.changing1.zhihuijujia.mapper.VolActivityMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolActivityService implements VolActivityMapper {
	@Autowired
	VolActivityMapper volActivityMapper;

	/**
	 * @param volActivity
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByVsId(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByVsId(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public Integer addVolActivity(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.addVolActivity(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public Integer deleteVolActivity(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.deleteVolActivity(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public Integer updateVolActivityVaRemNum(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.updateVolActivityVaRemNum(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public Integer updateVolActivityVaState(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.updateVolActivityVaState(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByVaEPhoneNum(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByVaEPhoneNum(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public VolActivity getVolActivityByVaId(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivityByVaId(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByCondition(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByCondition(volActivity);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByInputLike(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByInputLike(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByEPhoneAndCondition(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByEPhoneAndCondition(volActivity);
	}

	/**
	 * @param volActivity
	 * @return
	 */
	public List<VolActivity> getVolActivitysListByEPhoneAndInputLike(VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityMapper.getVolActivitysListByEPhoneAndInputLike(volActivity);
	}

}
