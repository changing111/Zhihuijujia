/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface DoctorMapper {

	/**
	 * @param doctor
	 * @return
	 */
	List<Doctor> getDoctorsListByOId(Doctor doctor);

	/**
	 * @param doctor
	 * @return
	 */
	Integer addDoctor(Doctor doctor);

	/**
	 * @param doctor
	 * @return
	 */
	Integer deleteDoctor(Doctor doctor);

	/**
	 * @param doctor
	 * @return
	 */
	Integer updateDoctor(Doctor doctor);

	
}
