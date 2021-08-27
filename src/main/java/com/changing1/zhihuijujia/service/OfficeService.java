/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Doctor;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.Office;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.DoctorMapper;
import com.changing1.zhihuijujia.mapper.HospitalMapper;
import com.changing1.zhihuijujia.mapper.OfficeMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class OfficeService implements OfficeMapper {
	@Autowired
	OfficeMapper officeMapper;

	/**
	 * @param office
	 * @return
	 */
	public List<Office> getOfficesListByHId(Office office) {
		// TODO Auto-generated method stub
		return officeMapper.getOfficesListByHId(office);
	}

	/**
	 * @param office
	 * @return
	 */
	public Integer addOffice(Office office) {
		// TODO Auto-generated method stub
		return officeMapper.addOffice(office);
	}

	/**
	 * @param office
	 * @return
	 */
	public Integer deleteOffice(Office office) {
		// TODO Auto-generated method stub
		return officeMapper.deleteOffice(office);
	}

	/**
	 * @param office
	 * @return
	 */
	public Integer updateOffice(Office office) {
		// TODO Auto-generated method stub
		return officeMapper.updateOffice(office);
	}

}
