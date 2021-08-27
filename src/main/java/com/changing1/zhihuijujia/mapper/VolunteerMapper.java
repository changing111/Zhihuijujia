/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PatchMapping;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.Volunteer;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface VolunteerMapper {

	/**
	 * @param volunteer
	 * @return
	 */
	Volunteer loginVolunteer(Volunteer volunteer);

	/**
	 * @param volunteer 
	 * @return
	 */
	List<Volunteer> getVolunteersListByVsId(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	Volunteer nameExists(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	Integer addVolunteer(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	Integer deleteVolunteer(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	Integer updateVolunteer(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	Integer updateVolunteerVHour(Volunteer volunteer);

	/**
	 * @param inputLike
	 * @return
	 */
	List<Volunteer> getVolunteersListByInputLike(@Param("inputLike") String inputLike);

	/**
	 * @param volunteer
	 * @return
	 */
	List<Volunteer> getVolunteersListByCondition(Volunteer volunteer);

	/**
	 * @param volunteer
	 * @return
	 */
	List<Volunteer> getVolunteersListByVsIdAndLike(Volunteer volunteer);




}
