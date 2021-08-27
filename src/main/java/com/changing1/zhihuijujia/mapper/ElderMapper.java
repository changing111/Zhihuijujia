/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Elder;




/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface ElderMapper {

	/**
	 * @param elder
	 * @return
	 */
	Elder loginElder(Elder elder);

	/**
	 * @param elder 
	 * @return
	 */
	List<Elder> getEldersListByCondition(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Elder nameExists(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Integer addElder(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Integer deleteElder(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Integer updateElder(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Integer getEBalanceByEPhoneNum(Elder elder);

	/**
	 * @param elder
	 * @return
	 */
	Integer updateEBalance(Elder elder);

	/**
	 * @param likeString
	 * @return
	 */
	List<Elder> getEldersListByInputLike(@Param ("inputLike") String inputLike);

	/**
	 * @return
	 */
	List<Elder> getEldersList();

}
