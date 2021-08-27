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
import com.changing1.zhihuijujia.entity.PageBean4Volunteer;
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
public class VolunteerController {
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private VolBookService volBookService;
	@Autowired
	private VolActivityService volActivityService ;

	@RequestMapping("/loginVolunteer")
	public Integer loginVolunteer(@RequestBody Volunteer volunteer) {
		// TODO Auto-generated method stub
		if(volunteerService.loginVolunteer(volunteer)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}	
	}
	@RequestMapping("/getVolunteersListByCondition")
	public PageBean4Volunteer getVolunteersListByCondition(@RequestBody PageBean4Volunteer pageBean4Volunteer) {
		// TODO Auto-generated method stub
		Integer totalCount = volunteerService.getVolunteersListByCondition(pageBean4Volunteer.getVolunteer()).size();
		PageHelper.startPage(pageBean4Volunteer.getCurrentPage(),pageBean4Volunteer.getPageSize());
		List<Volunteer> volunteersList = volunteerService.getVolunteersListByCondition(pageBean4Volunteer.getVolunteer());
		pageBean4Volunteer.setVolunteersList(volunteersList);
		pageBean4Volunteer.setTotalCount(totalCount);
		return pageBean4Volunteer;
	}
	@RequestMapping("/getVolunteersListByInputLike")
	public PageBean4Volunteer getVolunteersListByInputLike(@RequestBody PageBean4Volunteer pageBean4Volunteer) {
		// TODO Auto-generated method stub
		Integer totalCount = volunteerService.getVolunteersListByInputLike(pageBean4Volunteer.getInputLike()).size();
		PageHelper.startPage(pageBean4Volunteer.getCurrentPage(),pageBean4Volunteer.getPageSize());	
		List<Volunteer> volunteersList = volunteerService.getVolunteersListByInputLike(pageBean4Volunteer.getInputLike());
		pageBean4Volunteer.setVolunteersList(volunteersList);
		pageBean4Volunteer.setTotalCount(totalCount);
		return pageBean4Volunteer;
	}
	@RequestMapping("/getVolunteersListByVsId")
	public PageBean4Volunteer getVolunteersListByVsId(@RequestBody PageBean4Volunteer pageBean4Volunteer) {
		// TODO Auto-generated method stub
		Integer totalCount = volunteerService.getVolunteersListByVsId(pageBean4Volunteer.getVolunteer()).size();
		PageHelper.startPage(pageBean4Volunteer.getCurrentPage(),pageBean4Volunteer.getPageSize());
		List<Volunteer> volunteersList = volunteerService.getVolunteersListByVsId(pageBean4Volunteer.getVolunteer());
		pageBean4Volunteer.setVolunteersList(volunteersList);
		pageBean4Volunteer.setTotalCount(totalCount);
		return pageBean4Volunteer;	
	}
	@RequestMapping("/getVolunteersListByVsIdAndLike")//把关键字放在vJob
	public PageBean4Volunteer getVolunteersListByVsIdAndLike(@RequestBody PageBean4Volunteer pageBean4Volunteer) {
		// TODO Auto-generated method stub
		Integer totalCount = volunteerService.getVolunteersListByVsIdAndLike(pageBean4Volunteer.getVolunteer()).size();
		PageHelper.startPage(pageBean4Volunteer.getCurrentPage(),pageBean4Volunteer.getPageSize());
		List<Volunteer> volunteersList = volunteerService.getVolunteersListByVsIdAndLike(pageBean4Volunteer.getVolunteer());
		pageBean4Volunteer.setVolunteersList(volunteersList);
		pageBean4Volunteer.setTotalCount(totalCount);
		return pageBean4Volunteer;	
	}
	@RequestMapping("/addVolunteer")
	public Integer addVolunteer(@RequestBody Volunteer volunteer) {
		// TODO Auto-generated method stub
		volunteer.setvId(String.valueOf(System.currentTimeMillis()));
		if (volunteerService.nameExists(volunteer)!=null) {
			return 2;//用户名id已存在
		}else{
			return volunteerService.addVolunteer(volunteer);
		}
	}
	@RequestMapping("/getVolunteerByVPhone")
	public Volunteer getVolunteerByVPhone(@RequestBody Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerService.nameExists(volunteer);
	}
	
	@RequestMapping("/deleteVolunteer")//传入vphone删除义工及其报名表，更新未结束活动表人数，已结束活动表不更新
	public Integer deleteVolunteer(@RequestBody Volunteer volunteer) {
		// TODO Auto-generated method stub
		VolBook volBook =new VolBook();
		volBook.setVbVPhoneNum(volunteer.getvPhone());
		List<VolBook> bookList= volBookService.getVolBooksListByVPhoneNum(volBook);
		for (VolBook volBook2 : bookList) {
			if (volBook2.getVbState()=="已报名") {
				VolActivity volActivity =new VolActivity();
				volActivity.setVaId(volBook2.getVbVaId());
				VolActivity volActivity2=volActivityService.getVolActivityByVaId(volActivity);
				Integer remNum =volActivity2.getVaRemNum();
				volActivity2.setVaRemNum(remNum+1);
				volActivityService.updateVolActivityVaRemNum(volActivity2);
			}		
			volBookService.deleteVolBook(volBook2);
		}
		return volunteerService.deleteVolunteer(volunteer);		
	}
	
	@RequestMapping("/updateVolunteer")
	public Integer updateVolunteer(@RequestBody Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerService.updateVolunteer(volunteer);		
	}
	
}
