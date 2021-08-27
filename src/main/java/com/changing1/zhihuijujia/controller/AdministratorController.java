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
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.PageBean4Administrator;
import com.changing1.zhihuijujia.entity.PageBean4Elder;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;
	@RequestMapping("/loginAdministrator")
	public Integer loginAdministrator(@RequestBody Administrator administrator) {
		// TODO Auto-generated method stub
		if(administratorService.loginAdministrator(administrator)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}
		
	}
	
	@RequestMapping("/getAuthorityById")
	public Administrator getAuthorityById(@RequestBody Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorService.getAuthorityById(administrator.getaId());
		
				
	}
	
	@RequestMapping("/getAdministratorsListByInputLike")
	public PageBean4Administrator getAdministratorsListByInputLike(@RequestBody PageBean4Administrator pageBean4Administrator) {
		// TODO Auto-generated method stub
		Integer totalCount = administratorService.getAdministratorsListByInputLike(pageBean4Administrator.getInputLike()).size();
		PageHelper.startPage(pageBean4Administrator.getCurrentPage(),pageBean4Administrator.getPageSize());	
		List<Administrator> administratorsList = administratorService.getAdministratorsListByInputLike(pageBean4Administrator.getInputLike());
		pageBean4Administrator.setAdministratorsList(administratorsList);
		pageBean4Administrator.setTotalCount(totalCount);
		return pageBean4Administrator;
	}
	
	@RequestMapping("/addAdministrator")
	public Integer addAdministrator(@RequestBody Administrator administrator) {
		// TODO Auto-generated method stub
			
		if (administratorService.nameExists(administrator)!=null) {
			return 2;//用户名id已存在
		}else{
			administrator.setaAuthority("普通管理员");
			return administratorService.addAdministrator(administrator);
		}
	}
	
	@RequestMapping("/deleteAdministrator")
	public Integer deleteAdministrator(@RequestBody Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorService.deleteAdministrator(administrator);		
	}
	
	@RequestMapping("/updateAdministrator")
	public Integer updateAdministrator(@RequestBody Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorService.updateAdministrator(administrator);		
	}
}
