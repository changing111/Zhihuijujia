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

import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.PageBean4Hospital;
import com.changing1.zhihuijujia.entity.PageBean4VolStation;
import com.changing1.zhihuijujia.entity.VolActivity;
import com.changing1.zhihuijujia.entity.VolBook;
import com.changing1.zhihuijujia.entity.VolStation;
import com.changing1.zhihuijujia.entity.Volunteer;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.changing1.zhihuijujia.service.VolActivityService;
import com.changing1.zhihuijujia.service.VolBookService;
import com.changing1.zhihuijujia.service.VolStationService;
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
public class VolStationController {
	@Autowired
	private VolStationService volStationService;
	@Autowired
	private VolActivityService volActivityService;
	@Autowired
	private VolunteerService volunteerService;
	@Autowired
	private VolBookService volBookService;

	@RequestMapping("/loginVolStation")
	public Integer loginVolStation(@RequestBody VolStation volStation) {
		// TODO Auto-generated method stub
		if(volStationService.loginVolStation(volStation)!=null) {
			return 1;//登录成功
		}else {
			return 0;//登录失败
		}
		
	}
	@RequestMapping("/getVolStationsListByCondition")
	public PageBean4VolStation getVolStationsListByCondition(@RequestBody PageBean4VolStation pageBean4VolStation) {
		// TODO Auto-generated method stub
		Integer totalCount = volStationService.getVolStationsListByCondition(pageBean4VolStation.getVolStation()).size();
		PageHelper.startPage(pageBean4VolStation.getCurrentPage(),pageBean4VolStation.getPageSize());
		List<VolStation> volStationsList = volStationService.getVolStationsListByCondition(pageBean4VolStation.getVolStation());
		pageBean4VolStation.setVolStationsList(volStationsList);
		pageBean4VolStation.setTotalCount(totalCount);
		return pageBean4VolStation;
	}
	@RequestMapping("/getVolStationsListByInputLike")
	public PageBean4VolStation getVolStationsListByInputLike(@RequestBody PageBean4VolStation pageBean4VolStation) {
		// TODO Auto-generated method stub
		Integer totalCount = volStationService.getVolStationsListByInputLike(pageBean4VolStation.getInputLike()).size();
		PageHelper.startPage(pageBean4VolStation.getCurrentPage(),pageBean4VolStation.getPageSize());	
		List<VolStation> volStationsList = volStationService.getVolStationsListByInputLike(pageBean4VolStation.getInputLike());
		pageBean4VolStation.setVolStationsList(volStationsList);
		pageBean4VolStation.setTotalCount(totalCount);
		return pageBean4VolStation;
	}
	@RequestMapping("/addVolStation")
	public Integer addVolStation(@RequestBody VolStation volStation) {
		// TODO Auto-generated method stub
		volStation.setVsId(String.valueOf(System.currentTimeMillis()));
		if (volStationService.nameExists(volStation)!=null) {
			return 2;//用户名id已存在
		}else{
			return volStationService.addVolStation(volStation);
		}
	}
	
	@RequestMapping("/deleteVolStation")//传入vsId
	public Integer deleteVolStation(@RequestBody VolStation volStation) {
		// 需要迭代删除所有其有关义工和活动和报名信息-------------------
		Volunteer volunteer = new Volunteer();
		volunteer.setvVsId(volStation.getVsId());
		List<Volunteer> volunteerList= volunteerService.getVolunteersListByVsId(volunteer);
		for (Volunteer volunteer2 : volunteerList) {
			VolBook volBook =new VolBook();
			volBook.setVbVPhoneNum(volunteer2.getvPhone());
			List<VolBook> bookList= volBookService.getVolBooksListByVPhoneNum(volBook);
			for (VolBook volBook2 : bookList) {
				volBookService.deleteVolBook(volBook2);
			}
			volunteerService.deleteVolunteer(volunteer2);
			
			VolActivity volActivity=new VolActivity();
			volActivity.setVaVsId(volStation.getVsId());
			List<VolActivity> volActivitieList= volActivityService.getVolActivitysListByVsId(volActivity);
			for (VolActivity volActivity2 : volActivitieList) {
				volActivityService.deleteVolActivity(volActivity2);
			}
			volActivityService.deleteVolActivity(volActivity);
		}
		return volStationService.deleteVolStation(volStation);		
	}
	
	@RequestMapping("/updateVolStation")
	public Integer updateVolStation(@RequestBody VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationService.updateVolStation(volStation);		
	}
	@RequestMapping("/getVolStationByVsAdminPhone")
	public VolStation getVolStationByVsAdminPhone(@RequestBody VolStation volStation) {
		// TODO Auto-generated method stub
		return volStationService.getVolStationByVsAdminPhone(volStation);		
	}
	
}
