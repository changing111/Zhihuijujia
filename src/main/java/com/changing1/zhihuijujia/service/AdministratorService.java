/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class AdministratorService implements AdministratorMapper {
	@Autowired
	AdministratorMapper administratorMapper;
	/**
	 * @param administrator
	 * @return
	 */
	public Administrator loginAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.loginAdministrator(administrator);
	}
	
	@Override
	public Administrator getAuthorityById(String aId) {
		// TODO Auto-generated method stub
		return administratorMapper.getAuthorityById(aId);
	}
	/**
	 * @param administrator
	 * @return
	 */
	public Integer addAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.addAdministrator(administrator);
	}
	/**
	 * @param administrator
	 * @return
	 */
	public Integer deleteAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.deleteAdministrator(administrator);
	}
	/**
	 * @param administrator
	 * @return
	 */
	public Integer updateAdministrator(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.updateAdministrator(administrator);
	}
	/**
	 * @param administrator
	 * @return
	 */
	public Administrator nameExists(Administrator administrator) {
		// TODO Auto-generated method stub
		return administratorMapper.nameExists(administrator);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<Administrator> getAdministratorsListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return administratorMapper.getAdministratorsListByInputLike(inputLike);
	}


}
