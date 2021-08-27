/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Register;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface RegisterMapper {

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByEPhoneNum(Register register);

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByDPhoneNum(Register register);

	/**
	 * @param register
	 * @return
	 */
	Integer addRegister(Register register);

	/**
	 * @param register
	 * @return
	 */
	Integer deleteRegister(Register register);

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByDPhoneAndDate(Register register);

	/**
	 * @param hId
	 * @return
	 */
	List<Register> getRegistersListByHId(@Param("hId") String hId);

	/**
	 * @param inputLike
	 * @return
	 */
	List<Register> getRegistersListByInputLike(@Param("inputLike") String inputLike,@Param("hId") String hId);

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByCondition(Register register);

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByEPhoneAndCondition(Register register);

	/**
	 * @param register
	 * @return
	 */
	List<Register> getRegistersListByEPhoneAndInputLike(Register register);

	/**
	 * @param register
	 * @return
	 */
	Register ifExists(Register register);

}
