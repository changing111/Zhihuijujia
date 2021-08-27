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
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.PageBean4Hospital;
import com.changing1.zhihuijujia.entity.PageBean4VolActivity;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.entity.VolActivity;
import com.changing1.zhihuijujia.entity.VolBook;
import com.changing1.zhihuijujia.entity.Volunteer;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.changing1.zhihuijujia.service.VolActivityService;
import com.changing1.zhihuijujia.service.VolBookService;
import com.changing1.zhihuijujia.service.VolunteerService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolActivityController {
	@Autowired
	private VolActivityService volActivityService;
	@Autowired
	private VolBookService volBookService;
	@Autowired
	private VolunteerService volunteerService;
	@RequestMapping("/getVolActivitysListByCondition")
	public PageBean4VolActivity getVolActivitysListByCondition(@RequestBody PageBean4VolActivity pageBean4VolActivity) {
		// TODO Auto-generated method stub
		Integer totalCount = volActivityService.getVolActivitysListByCondition(pageBean4VolActivity.getVolActivity()).size();
		PageHelper.startPage(pageBean4VolActivity.getCurrentPage(),pageBean4VolActivity.getPageSize());
		List<VolActivity> volActivitysList = volActivityService.getVolActivitysListByCondition(pageBean4VolActivity.getVolActivity());
		pageBean4VolActivity.setVolActivitysList(volActivitysList);
		pageBean4VolActivity.setTotalCount(totalCount);
		return pageBean4VolActivity;
	}
	@RequestMapping("/getVolActivitysListByInputLike")//用vaEname代替关键字
	public PageBean4VolActivity getVolActivitysListByInputLike(@RequestBody PageBean4VolActivity pageBean4VolActivity) {
		// TODO Auto-generated method stub
		Integer totalCount = volActivityService.getVolActivitysListByInputLike(pageBean4VolActivity.getVolActivity()).size();
		PageHelper.startPage(pageBean4VolActivity.getCurrentPage(),pageBean4VolActivity.getPageSize());
		List<VolActivity> volActivitysList = volActivityService.getVolActivitysListByInputLike(pageBean4VolActivity.getVolActivity());
		pageBean4VolActivity.setVolActivitysList(volActivitysList);
		pageBean4VolActivity.setTotalCount(totalCount);
		return pageBean4VolActivity;
	}
	@RequestMapping("/getVolActivitysListByEPhoneAndCondition")
	public PageBean4VolActivity getVolActivitysListByEPhoneAndCondition(@RequestBody PageBean4VolActivity pageBean4VolActivity) {
		// TODO Auto-generated method stub
		Integer totalCount = volActivityService.getVolActivitysListByEPhoneAndCondition(pageBean4VolActivity.getVolActivity()).size();
		PageHelper.startPage(pageBean4VolActivity.getCurrentPage(),pageBean4VolActivity.getPageSize());
		List<VolActivity> volActivitysList = volActivityService.getVolActivitysListByEPhoneAndCondition(pageBean4VolActivity.getVolActivity());
		pageBean4VolActivity.setVolActivitysList(volActivitysList);
		pageBean4VolActivity.setTotalCount(totalCount);
		return pageBean4VolActivity;
	}
	@RequestMapping("/getVolActivitysListByEPhoneAndInputLike")//用vaEname代替关键字
	public PageBean4VolActivity getVolActivitysListByEPhoneAndInputLike(@RequestBody PageBean4VolActivity pageBean4VolActivity) {
		// TODO Auto-generated method stub
		Integer totalCount = volActivityService.getVolActivitysListByEPhoneAndInputLike(pageBean4VolActivity.getVolActivity()).size();
		PageHelper.startPage(pageBean4VolActivity.getCurrentPage(),pageBean4VolActivity.getPageSize());
		List<VolActivity> volActivitysList = volActivityService.getVolActivitysListByEPhoneAndInputLike(pageBean4VolActivity.getVolActivity());
		pageBean4VolActivity.setVolActivitysList(volActivitysList);
		pageBean4VolActivity.setTotalCount(totalCount);
		return pageBean4VolActivity;
	}
	@RequestMapping("/getVolActivitysListByVsId")
	public List<VolActivity> getVolActivitysListByVsId(@RequestBody VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityService.getVolActivitysListByVsId(volActivity);		
	}
	@RequestMapping("/addVolActivity")
	public Integer addVolActivity(@RequestBody VolActivity volActivity) {
		// TODO Auto-generated method stub
		volActivity.setVaId(String.valueOf(System.currentTimeMillis()));
		volActivity.setVaState("未结束");
		volActivity.setVaRemNum(volActivity.getVaRemSum());
		return volActivityService.addVolActivity(volActivity);
	}
	
	@RequestMapping("/deleteVolActivity")//删除活动同时迭代删除其报名表
	public Integer deleteVolActivity(@RequestBody VolActivity volActivity) {
		// TODO Auto-generated method stub
			VolBook volBook =new VolBook();
			volBook.setVbVaId(volActivity.getVaId());
			List<VolBook> bookList=volBookService.getVolBooksListByVaId(volBook);
			for (VolBook volBook2 : bookList) {
				volBookService.deleteVolBook(volBook2);
			}
			return volActivityService.deleteVolActivity(volActivity);
		}
		

		
	@RequestMapping("/updateVolActivityVaState")//传入vaId修改为已完成状态并且添加义工时
	public Integer updateVolActivityVaState(@RequestBody VolActivity volActivity) {
		// TODO Auto-generated method stub
		volActivity.setVaState("已结束");
		VolBook volBook = new VolBook();
		volBook.setVbVaId(volActivity.getVaId());
		List<VolBook> volBookList= volBookService.getVolBooksListByVaId(volBook);
		for (VolBook volBook2 : volBookList) {
			Volunteer volunteer = new Volunteer();
			volunteer.setvPhone(volBook2.getVbVPhoneNum());
			Volunteer volunteer2=volunteerService.nameExists(volunteer);
			volunteer2.setvHour(volunteer2.getvHour()+volBook2.getVbVaHourNum());
			volunteerService.updateVolunteerVHour(volunteer2);
			volBook2.setVbState("已完成");
			volBookService.updateVolBookState(volBook2);
		}
		return volActivityService.updateVolActivityVaState(volActivity);		
	}
	
	@RequestMapping("/getVolActivitysListByVaEPhoneNum")
	public List<VolActivity> getVolActivitysListByVaEPhoneNum(@RequestBody VolActivity volActivity) {
		// TODO Auto-generated method stub
		return volActivityService.getVolActivitysListByVaEPhoneNum(volActivity);		
	}
}
