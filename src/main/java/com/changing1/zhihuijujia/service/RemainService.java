/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Remain;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.DoctorMapper;
import com.changing1.zhihuijujia.mapper.HospitalMapper;
import com.changing1.zhihuijujia.mapper.RemainMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class RemainService implements RemainMapper {
	@Autowired
	RemainMapper remainMapper;

	/**
	 * @param remain
	 * @return
	 */
	public List<Remain> getRemainsListByDPhoneNum(Remain remain) {
		// TODO Auto-generated method stub
		return remainMapper.getRemainsListByDPhoneNum(remain);
	}

	/**
	 * @param remain
	 * @return
	 */
	public Integer addRemain(Remain remain) {
		// TODO Auto-generated method stub
		return remainMapper.addRemain(remain);
	}

	/**
	 * @param remain
	 * @return
	 */
	public Integer deleteRemain(Remain remain) {
		// TODO Auto-generated method stub
		return remainMapper.deleteRemain(remain);
	}

	/**
	 * @param remain
	 * @return
	 */
	public Remain nameExists(Remain remain) {
		// TODO Auto-generated method stub
		return remainMapper.nameExists(remain);
	}


	/**
	 * @param remain2
	 * @return
	 */
	public Integer updateRemain(Remain remain) {
		// TODO Auto-generated method stub
		return remainMapper.updateRemain(remain);
	}

	
}
