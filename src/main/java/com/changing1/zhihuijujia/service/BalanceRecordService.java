/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.BalanceRecord;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.BalanceRecordMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class BalanceRecordService implements BalanceRecordMapper {
	@Autowired
	BalanceRecordMapper balanceRecordMapper;

	/**
	 * @param balanceRecord
	 * @return
	 */
	public Integer addBalanceRecord(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.addBalanceRecord(balanceRecord);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public Integer updateWithdrawState(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.updateWithdrawState(balanceRecord);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getAllBalanceRecord() {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getAllBalanceRecord();
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getElderBalanceRecord(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getElderBalanceRecord(balanceRecord);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getShopBalanceRecord(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getShopBalanceRecord(balanceRecord);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getBalanceRecordsListByCondition(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getBalanceRecordsListByCondition(balanceRecord);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<BalanceRecord> getBalanceRecordsListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getBalanceRecordsListByInputLike(inputLike);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getBalanceRecordsListByPhoneAndCondition(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getBalanceRecordsListByPhoneAndCondition(balanceRecord);
	}

	/**
	 * @param balanceRecord
	 * @return
	 */
	public List<BalanceRecord> getBalanceRecordsListByPhoneAndInputLike(BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordMapper.getBalanceRecordsListByPhoneAndInputLike(balanceRecord);
	}

}
