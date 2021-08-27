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
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.DoctorMapper;
import com.changing1.zhihuijujia.mapper.HospitalMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class DoctorService implements DoctorMapper {
	@Autowired
	DoctorMapper doctorMapper;

	/**
	 * @param doctor
	 * @return
	 */
	public List<Doctor> getDoctorsListByOId(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorMapper.getDoctorsListByOId(doctor);
	}

	/**
	 * @param doctor
	 * @return
	 */
	public Integer addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorMapper.addDoctor(doctor);
	}

	/**
	 * @param doctor
	 * @return
	 */
	public Integer deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorMapper.deleteDoctor(doctor);
	}

	/**
	 * @param doctor
	 * @return
	 */
	public Integer updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorMapper.updateDoctor(doctor);
	}

}
