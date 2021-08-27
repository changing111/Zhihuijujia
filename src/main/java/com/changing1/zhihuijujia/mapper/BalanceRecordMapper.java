/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.BalanceRecord;
import com.changing1.zhihuijujia.entity.Shop;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface BalanceRecordMapper {

	/**
	 * @param balanceRecord
	 * @return
	 */
	Integer addBalanceRecord(BalanceRecord balanceRecord);

	/**
	 * @param balanceRecord
	 * @return
	 */
	Integer updateWithdrawState(BalanceRecord balanceRecord);

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getAllBalanceRecord();

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getElderBalanceRecord(BalanceRecord balanceRecord);

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getShopBalanceRecord(BalanceRecord balanceRecord);

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getBalanceRecordsListByCondition(BalanceRecord balanceRecord);

	/**
	 * @param inputLike
	 * @return
	 */
	List<BalanceRecord> getBalanceRecordsListByInputLike(@Param("inputLike") String inputLike);

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getBalanceRecordsListByPhoneAndCondition(BalanceRecord balanceRecord);

	/**
	 * @param balanceRecord
	 * @return
	 */
	List<BalanceRecord> getBalanceRecordsListByPhoneAndInputLike(BalanceRecord balanceRecord);

}
