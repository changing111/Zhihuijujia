/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.HospitalMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class HospitalService implements HospitalMapper {
	@Autowired
	HospitalMapper hospitalMapper;

	/**
	 * @param hospital
	 * @return
	 */
	public Hospital loginHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.loginHospital(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Hospital nameExists(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.nameExists(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Integer addHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.addHospital(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Integer deleteHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.deleteHospital(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Integer updateHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.updateHospital(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Integer getHospitalByHId(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.getHospitalByHId(hospital);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public List<Hospital> getHospitalsListByCondition(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.getHospitalsListByCondition(hospital);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<Hospital> getHospitalsListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return hospitalMapper.getHospitalsListByInputLike(inputLike);
	}

	/**
	 * @param hospital
	 * @return
	 */
	public Hospital getHospitalByHAdminPhone(Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalMapper.getHospitalByHAdminPhone(hospital);
	}

}
