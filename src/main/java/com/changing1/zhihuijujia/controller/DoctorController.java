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
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.DoctorService;
import com.changing1.zhihuijujia.service.HospitalService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/getDoctorsListByOId")
	public List<Doctor> getDoctorsListByOId(@RequestBody Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorService.getDoctorsListByOId(doctor);		
	}
	@RequestMapping("/addDoctor")
	public Integer addDoctor(@RequestBody Doctor doctor) {
		// TODO Auto-generated method stub
		doctor.setdId(String.valueOf(System.currentTimeMillis()));
		return doctorService.addDoctor(doctor);

	}
	
	@RequestMapping("/deleteDoctor")
	public Integer deleteDoctor(@RequestBody Doctor doctor) {
		// TODO Auto-generated method stub
		//删除医生
		return doctorService.deleteDoctor(doctor);		
	}
	
	@RequestMapping("/updateDoctor")
	public Integer updateDoctor(@RequestBody Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorService.updateDoctor(doctor);		
	}
	
}
