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
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.PageBean4Elder;
import com.changing1.zhihuijujia.service.ElderService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ElderController {
	@Autowired
	private ElderService elderService;

	@RequestMapping("/loginElder")
	public Integer loginElder(@RequestBody Elder elder) {
		// TODO Auto-generated method stub
		if(elderService.loginElder(elder)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}
	}
	
	@RequestMapping("/getEldersListByCondition")
	public PageBean4Elder getEldersListByCondition(@RequestBody PageBean4Elder pageBean4Elder) {
		// TODO Auto-generated method stub
		Integer totalCount = elderService.getEldersListByCondition(pageBean4Elder.getElder()).size();
		PageHelper.startPage(pageBean4Elder.getCurrentPage(),pageBean4Elder.getPageSize());
		List<Elder> eldersList = elderService.getEldersListByCondition(pageBean4Elder.getElder());
		pageBean4Elder.setEldersList(eldersList);
		pageBean4Elder.setTotalCount(totalCount);
		return pageBean4Elder;
	}
	@RequestMapping("/getEldersListByInputLike")
	public PageBean4Elder getEldersListByInputLike(@RequestBody PageBean4Elder pageBean4Elder) {
		// TODO Auto-generated method stub
		Integer totalCount = elderService.getEldersListByInputLike(pageBean4Elder.getInputLike()).size();
		PageHelper.startPage(pageBean4Elder.getCurrentPage(),pageBean4Elder.getPageSize());	
		List<Elder> eldersList = elderService.getEldersListByInputLike(pageBean4Elder.getInputLike());
		pageBean4Elder.setEldersList(eldersList);
		pageBean4Elder.setTotalCount(totalCount);
		return pageBean4Elder;
	}
	
	@RequestMapping("/addElder")
	public Integer addElder(@RequestBody Elder elder) {
		// TODO Auto-generated method stub
		elder.seteId(String.valueOf(System.currentTimeMillis()));
		elder.seteBalance(0);
		if (elderService.nameExists(elder)!=null) {
			return 2;//用户名id已存在
		}else{
			return elderService.addElder(elder);
		}
	}
	@RequestMapping("/getElderByEPhoneNum")
	public Elder getElderByEPhoneNum(@RequestBody Elder elder) {
		// TODO Auto-generated method stub
		return elderService.nameExists(elder);
	}
	
	@RequestMapping("/deleteElder")
	public Integer deleteElder(@RequestBody Elder elder) {
		// TODO Auto-generated method stub
		return elderService.deleteElder(elder);		
	}
	@RequestMapping("/getEldersList")
	public List<Elder> getEldersList() {
		// TODO Auto-generated method stub
		return elderService.getEldersList();		
	}
	
	@RequestMapping("/updateElder")
	public Integer updateElder(@RequestBody Elder elder) {
		// TODO Auto-generated method stub
		return elderService.updateElder(elder);		
	}
	
	
}
