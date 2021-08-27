/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Office;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface OfficeMapper {

	/**
	 * @param office
	 * @return
	 */
	List<Office> getOfficesListByHId(Office office);

	/**
	 * @param office
	 * @return
	 */
	Integer addOffice(Office office);

	/**
	 * @param office
	 * @return
	 */
	Integer deleteOffice(Office office);

	/**
	 * @param office
	 * @return
	 */
	Integer updateOffice(Office office);

	
}
