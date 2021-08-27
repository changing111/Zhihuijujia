/**
 * 
 */
package com.changing1.zhihuijujia.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Register;
import com.changing1.zhihuijujia.entity.Remain;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.DoctorService;
import com.changing1.zhihuijujia.service.HospitalService;
import com.changing1.zhihuijujia.service.RegisterService;
import com.changing1.zhihuijujia.service.RemainService;
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
public class RemainController {
	@Autowired
	private RemainService remainService;
	@Autowired
	private RegisterService registerService;

	@RequestMapping("/getRemainsListByDPhoneNum")
	public List<Remain> getRemainsListByDPhoneNum(@RequestBody Remain remain) {
		// TODO Auto-generated method stub
		return remainService.getRemainsListByDPhoneNum(remain);		
	}
	@RequestMapping("/addRemain")
	public Integer addRemain(@RequestBody Remain remain) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println(remain.getRemDate());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date stationTime = dateFormat.parse(dateFormat.format(remain.getRemDate()));
		System.out.println(stationTime);
		
		remain.setRemId(String.valueOf(System.currentTimeMillis()));		
		if (remainService.nameExists(remain)==null) {
			return remainService.addRemain(remain);
		}else{
			return 2;
		}

	}
	
	@RequestMapping("/deleteRemain")//通过日期和医生号码删除余号表同时删除预约纪录
	public Integer deleteRemain(@RequestBody Remain remain) {
		// TODO Auto-generated method stub
		Register register =new Register();
		register.setRegDate(remain.getRemDate());
		register.setRegDPhoneNum(remain.getRemDPhoneNum());
		List<Register> registerList=registerService.getRegistersListByDPhoneAndDate(register);
		for (Register register2 : registerList) {
			Integer integer=registerService.deleteRegister(register2);
		}
		return remainService.deleteRemain(remain);		
	}
	

	
}
