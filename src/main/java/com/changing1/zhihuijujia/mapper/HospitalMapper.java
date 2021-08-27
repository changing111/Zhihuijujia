/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface HospitalMapper {

	/**
	 * @param hospital
	 * @return
	 */
	Hospital loginHospital(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	Hospital nameExists(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	Integer addHospital(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	Integer deleteHospital(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	Integer updateHospital(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	Integer getHospitalByHId(Hospital hospital);

	/**
	 * @param hospital
	 * @return
	 */
	List<Hospital> getHospitalsListByCondition(Hospital hospital);

	/**
	 * @param inputLike
	 * @return
	 */
	List<Hospital> getHospitalsListByInputLike(@Param("inputLike") String inputLike);

	/**
	 * @param hospital
	 * @return
	 */
	Hospital getHospitalByHAdminPhone(Hospital hospital);

	
}
