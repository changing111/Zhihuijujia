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
import com.changing1.zhihuijujia.entity.Office;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.DoctorService;
import com.changing1.zhihuijujia.service.HospitalService;
import com.changing1.zhihuijujia.service.OfficeService;
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
public class OfficeController {
	@Autowired
	private OfficeService officeService;
	@Autowired
	private DoctorService doctorService;

	@RequestMapping("/getOfficesListByHId")
	public List<Office> getOfficesListByHId(@RequestBody Office office) {
		// TODO Auto-generated method stub
		return officeService.getOfficesListByHId(office);		
	}
	@RequestMapping("/addOffice")
	public Integer addOffice(@RequestBody Office office) {
		// TODO Auto-generated method stub
		office.setoId(String.valueOf(System.currentTimeMillis()));
		return officeService.addOffice(office);

	}
	
	@RequestMapping("/deleteOffice")
	public Integer deleteOffice(@RequestBody Office office) {
		// TODO Auto-generated method stub
		//删除医生
		Doctor doctor =new Doctor();
		doctor.setdOId(office.getoId());
		List<Doctor> doctorsList=doctorService.getDoctorsListByOId(doctor);
		for (Doctor doctor2: doctorsList) {
			Integer integer=doctorService.deleteDoctor(doctor2);
		}	
		return officeService.deleteOffice(office);		
	}
	
	@RequestMapping("/updateOffice")
	public Integer updateOffice(@RequestBody Office office) {
		// TODO Auto-generated method stub
		return officeService.updateOffice(office);		
	}
	
}
