/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Elder;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ElderMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ElderService implements ElderMapper {
	@Autowired
	ElderMapper elderMapper;

	/**
	 * @param elder
	 * @return
	 */
	public Elder loginElder(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.loginElder(elder);
	}

	/**
	 * @param elder 
	 * @return
	 */
	public List<Elder> getEldersListByCondition(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.getEldersListByCondition(elder);
	}

	/**
	 * @param elder
	 * @return
	 */
	public Elder nameExists(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.nameExists(elder);
	}

	/**
	 * @param elder
	 * @return
	 */
	public Integer addElder(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.addElder(elder);
	}

	/**
	 * @param elder
	 * @return
	 */
	public Integer deleteElder(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.deleteElder(elder);
	}

	/**
	 * @param elder
	 * @return
	 */
	public Integer updateElder(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.updateElder(elder);
	}
	/**
	 * @param elder
	 * @return
	 */
	public Integer getEBalanceByEPhoneNum(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.getEBalanceByEPhoneNum(elder);
	}

	/**
	 * @param elder
	 * @return
	 */
	public Integer updateEBalance(Elder elder) {
		// TODO Auto-generated method stub
		return elderMapper.updateEBalance(elder);
	}

	/**
	 * @param likeString
	 * @return
	 */
	public List<Elder> getEldersListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return elderMapper.getEldersListByInputLike(inputLike);
	}

	/**
	 * @return
	 */
	public List<Elder> getEldersList() {
		// TODO Auto-generated method stub
		return elderMapper.getEldersList();
	}



}
