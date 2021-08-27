/**
 * 
 */
package com.changing1.zhihuijujia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Office;
import com.changing1.zhihuijujia.entity.PageBean4Elder;
import com.changing1.zhihuijujia.entity.PageBean4Hospital;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.DoctorService;
import com.changing1.zhihuijujia.service.HospitalService;
import com.changing1.zhihuijujia.service.OfficeService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@Autowired
	private OfficeService officeService;
	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/loginHospital")
	public Integer loginHospital(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		if(hospitalService.loginHospital(hospital)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}		
	}
	@RequestMapping("/getHospitalsListByCondition")
	public PageBean4Hospital getHospitalsListByCondition(@RequestBody PageBean4Hospital pageBean4Hospital) {
		// TODO Auto-generated method stub
		Integer totalCount = hospitalService.getHospitalsListByCondition(pageBean4Hospital.getHospital()).size();
		PageHelper.startPage(pageBean4Hospital.getCurrentPage(),pageBean4Hospital.getPageSize());
		List<Hospital> hospitalsList = hospitalService.getHospitalsListByCondition(pageBean4Hospital.getHospital());
		pageBean4Hospital.setHospitalsList(hospitalsList);
		pageBean4Hospital.setTotalCount(totalCount);
		return pageBean4Hospital;
	}
	@RequestMapping("/getHospitalsListByInputLike")
	public PageBean4Hospital getHospitalsListByInputLike(@RequestBody PageBean4Hospital pageBean4Hospital) {
		// TODO Auto-generated method stub
		Integer totalCount = hospitalService.getHospitalsListByInputLike(pageBean4Hospital.getInputLike()).size();
		PageHelper.startPage(pageBean4Hospital.getCurrentPage(),pageBean4Hospital.getPageSize());	
		List<Hospital> hospitalsList = hospitalService.getHospitalsListByInputLike(pageBean4Hospital.getInputLike());
		pageBean4Hospital.setHospitalsList(hospitalsList);
		pageBean4Hospital.setTotalCount(totalCount);
		return pageBean4Hospital;
	}
	
	@RequestMapping("/addHospital")
	public Integer addHospital(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		hospital.sethId(String.valueOf(System.currentTimeMillis()));
		if (hospitalService.nameExists(hospital)!=null) {
			return 2;//医院名已存在
		}else{
			return hospitalService.addHospital(hospital);
		}
	}
	@RequestMapping("/getHospitalByHAdminPhone")
	public Hospital getHospitalByHAdminPhone(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalService.getHospitalByHAdminPhone(hospital);
	}
	
	@RequestMapping("/deleteHospital")
	public Integer deleteHospital(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		//迭代删除科室和医生
		Office office =new Office();
		office.setoHId(hospital.gethId());
		List<Office> officesList=officeService.getOfficesListByHId(office);
		for (Office office2 : officesList) {		
			Doctor doctor =new Doctor();
			doctor.setdOId(office2.getoId());
			List<Doctor> doctorsList=doctorService.getDoctorsListByOId(doctor);
			for (Doctor doctor2 : doctorsList) {
				Integer integer=doctorService.deleteDoctor(doctor2);
			}	
			Integer integer2=officeService.deleteOffice(office2);
		}
		return hospitalService.deleteHospital(hospital);		
	}
	
	@RequestMapping("/updateHospital")
	public Integer updateHospital(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalService.updateHospital(hospital);		
	}
	
	@RequestMapping("/getHospitalByHId")
	public Integer getHospitalByHId(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		return hospitalService.getHospitalByHId(hospital);		
	}
	
}
