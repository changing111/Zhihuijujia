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
import com.changing1.zhihuijujia.entity.Register;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.DoctorMapper;
import com.changing1.zhihuijujia.mapper.HospitalMapper;
import com.changing1.zhihuijujia.mapper.RegisterMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class RegisterService implements RegisterMapper {
	@Autowired
	RegisterMapper registerMapper;

	/**
	 * @param register
	 * @return
	 */
	public List<Register> getRegistersListByEPhoneNum(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByEPhoneNum(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public List<Register> getRegistersListByDPhoneNum(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByDPhoneNum(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public Integer addRegister(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.addRegister(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public Integer deleteRegister(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.deleteRegister(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public List<Register> getRegistersListByDPhoneAndDate(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByDPhoneAndDate(register);
	}

	/**
	 * @param hId
	 * @return
	 */
	public List<Register> getRegistersListByHId(String hId) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByHId(hId);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<Register> getRegistersListByInputLike(String inputLike,String hId) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByInputLike(inputLike,hId);
	}

	/**
	 * @param register 
	 * @param register
	 * @return
	 */
	public List<Register> getRegistersListByCondition(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByCondition(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public List<Register> getRegistersListByEPhoneAndCondition(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByEPhoneAndCondition(register);
	}

	/**
	 * @param inputLike
	 * @param gethId
	 * @return
	 */
	public List<Register> getRegistersListByEPhoneAndInputLike(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.getRegistersListByEPhoneAndInputLike(register);
	}

	/**
	 * @param register
	 * @return
	 */
	public Register ifExists(Register register) {
		// TODO Auto-generated method stub
		return registerMapper.ifExists(register);
	}


}
