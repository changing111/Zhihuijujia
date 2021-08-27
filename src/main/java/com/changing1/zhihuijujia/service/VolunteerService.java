/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.Volunteer;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
import com.changing1.zhihuijujia.mapper.VolunteerMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolunteerService implements VolunteerMapper {
	@Autowired
	VolunteerMapper volunteerMapper;

	/**
	 * @param volunteer
	 * @return
	 */
	public Volunteer loginVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.loginVolunteer(volunteer);
	}

	/**
	 * @param volunteer 
	 * @return
	 */
	public List<Volunteer> getVolunteersListByVsId(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.getVolunteersListByVsId(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public Volunteer nameExists(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.nameExists(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public Integer addVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.addVolunteer(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public Integer deleteVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.deleteVolunteer(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public Integer updateVolunteer(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.updateVolunteer(volunteer);
	}

	/**
	 * @param volunteer
	 */
	public Integer updateVolunteerVHour(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.updateVolunteerVHour(volunteer);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<Volunteer> getVolunteersListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return volunteerMapper.getVolunteersListByInputLike(inputLike);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public List<Volunteer> getVolunteersListByCondition(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.getVolunteersListByCondition(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */
	public List<Volunteer> getVolunteersListByVsIdAndLike(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerMapper.getVolunteersListByVsIdAndLike(volunteer);
	}

	/**
	 * @param volunteer
	 * @return
	 */


}
