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
import com.changing1.zhihuijujia.entity.PageBean4Hospital;
import com.changing1.zhihuijujia.entity.PageBean4Register;
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
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private RemainService remainService;
	@RequestMapping("/getRegistersListByEPhoneAndCondition")//条件查询某长者的记录
	public PageBean4Register getRegistersListByEPhoneAndCondition(@RequestBody PageBean4Register pageBean4Register) {
		// TODO Auto-generated method stub
		pageBean4Register.getRegister().setRegId(pageBean4Register.gethId());
		Integer totalCount = registerService.getRegistersListByEPhoneAndCondition(pageBean4Register.getRegister()).size();
		PageHelper.startPage(pageBean4Register.getCurrentPage(),pageBean4Register.getPageSize());
		List<Register> registersList = registerService.getRegistersListByEPhoneAndCondition(pageBean4Register.getRegister());
		pageBean4Register.setRegistersList(registersList);
		pageBean4Register.setTotalCount(totalCount);
		return pageBean4Register;
	}
	@RequestMapping("/getRegistersListByEPhoneAndInputLike")//关键字查询某长者的记录
	public PageBean4Register getRegistersListByEPhoneAndInputLike(@RequestBody PageBean4Register pageBean4Register) {
		// TODO Auto-generated method stub
		Integer totalCount = registerService.getRegistersListByEPhoneAndInputLike(pageBean4Register.getRegister()).size();
		PageHelper.startPage(pageBean4Register.getCurrentPage(),pageBean4Register.getPageSize());	
		List<Register> registersList = registerService.getRegistersListByEPhoneAndInputLike(pageBean4Register.getRegister());
		pageBean4Register.setRegistersList(registersList);
		pageBean4Register.setTotalCount(totalCount);
		return pageBean4Register;
	}
	
	@RequestMapping("/getRegistersListByCondition")//条件查询某医院hid的记录，hid在PageBean4Register中定义了
	public PageBean4Register getRegistersListByCondition(@RequestBody PageBean4Register pageBean4Register) {
		// TODO Auto-generated method stub
		pageBean4Register.getRegister().setRegId(pageBean4Register.gethId());
		Integer totalCount = registerService.getRegistersListByCondition(pageBean4Register.getRegister()).size();
		PageHelper.startPage(pageBean4Register.getCurrentPage(),pageBean4Register.getPageSize());
		List<Register> registersList = registerService.getRegistersListByCondition(pageBean4Register.getRegister());
		pageBean4Register.setRegistersList(registersList);
		pageBean4Register.setTotalCount(totalCount);
		return pageBean4Register;
	}
	@RequestMapping("/getRegistersListByInputLike")//关键字查询某医院hid的记录
	public PageBean4Register getRegistersListByInputLike(@RequestBody PageBean4Register pageBean4Register) {
		// TODO Auto-generated method stub
		Integer totalCount = registerService.getRegistersListByInputLike(pageBean4Register.getInputLike(),pageBean4Register.gethId()).size();
		PageHelper.startPage(pageBean4Register.getCurrentPage(),pageBean4Register.getPageSize());	
		List<Register> registersList = registerService.getRegistersListByInputLike(pageBean4Register.getInputLike(),pageBean4Register.gethId());
		pageBean4Register.setRegistersList(registersList);
		pageBean4Register.setTotalCount(totalCount);
		return pageBean4Register;
	}
	@RequestMapping("/getRegistersListByEPhoneNum")////查某长者医院所有预约纪录
	public List<Register> getRegistersListByEPhoneNum(@RequestBody Register register) {
		// TODO Auto-generated method stub
		return registerService.getRegistersListByEPhoneNum(register);		
	}
	
	@RequestMapping("/getRegistersListByDPhoneNum")//查某医生所有预约纪录
	public List<Register> getRegistersListByDPhoneNum(@RequestBody Register register) {
		// TODO Auto-generated method stub
		return registerService.getRegistersListByDPhoneNum(register);		
	}
	
	@RequestMapping("/addRegister")//通过预约日期和医生号码添加预约同时修改余号表余号数
	public Integer addRegister(@RequestBody Register register) {
		// TODO Auto-generated method stub
		Remain remain=new Remain();
		remain.setRemDate(register.getRegDate());
		remain.setRemDPhoneNum(register.getRegDPhoneNum());
		Remain remain2=remainService.nameExists(remain);
		if (remain2.getRemNum()>=1) {
			if (registerService.ifExists(register)==null) {
				Integer newRemainNum=remain2.getRemNum()-1;
				remain2.setRemNum(newRemainNum);
				Integer integer=remainService.updateRemain(remain2);
				register.setRegId(String.valueOf(System.currentTimeMillis()));
				return registerService.addRegister(register);
			} else {
				return 3;//该长者已经预约了该医生当天的号
			}
			
		} else {//没号了
			return 2;
		}


	}
	
	@RequestMapping("/deleteRegister")//通过预约日期和医生号码取消预约同时修改余号表余号数
	public Integer deleteRegister(@RequestBody Register register) {
		Remain remain=new Remain();
		remain.setRemDate(register.getRegDate());
		remain.setRemDPhoneNum(register.getRegDPhoneNum());
		Remain remain2=remainService.nameExists(remain);
		Integer newRemainNum=remain2.getRemNum()+1;
		remain2.setRemNum(newRemainNum);
		Integer integer=remainService.updateRemain(remain2);
		return registerService.deleteRegister(register);		
	}
	
	@RequestMapping("/getRegistersListByDPhoneAndDate")//查某医生某天预约纪录
	public List<Register> getRegistersListByDPhoneAndDate(@RequestBody Register register) {
		// TODO Auto-generated method stub
		return registerService.getRegistersListByDPhoneAndDate(register);		
	}
	
	@RequestMapping("/getRegistersListByConditionAndHId")//查某医院所有预约纪录
	public List<Register> getRegistersListByHId(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		System.out.println(hospital.gethId());
		return registerService.getRegistersListByHId(hospital.gethId());	
		
	}
}
