/**
 * 
 */
package com.changing1.zhihuijujia.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.changing1.zhihuijujia.entity.BalanceRecord;
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.Hospital;
import com.changing1.zhihuijujia.entity.PageBean4BalanceRecord;
import com.changing1.zhihuijujia.entity.PageBean4Hospital;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.service.BalanceRecordService;
import com.changing1.zhihuijujia.service.ElderService;
import com.changing1.zhihuijujia.service.ShopService;
import com.github.pagehelper.PageHelper;


@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class BalanceRecordController {
	@Autowired
	private BalanceRecordService balanceRecordService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private ElderService elderService;
	
	@RequestMapping("/Invest")
	public Integer Invest(@RequestBody BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		Elder elder =new Elder();
		elder.setePhoneNum(balanceRecord.getbPhoneNum());
		elder.seteBalance(balanceRecord.getbAfterBal());
		elderService.updateEBalance(elder);
		balanceRecord.setbTime(new Date());
		balanceRecord.setbState("已完成");
		return balanceRecordService.addBalanceRecord(balanceRecord);
	}
	
	@RequestMapping("/Withdraw")
	public Integer Withdraw(@RequestBody BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		Shop shop =new Shop();
		shop.setsPhoneNum(balanceRecord.getbPhoneNum());
		shop.setsBalance(balanceRecord.getbAfterBal());
		shopService.updateSBalance(shop);
		balanceRecord.setbTime(new Date());
		balanceRecord.setbState("未完成");
		balanceRecord.setbReason("商户提现");
		return balanceRecordService.addBalanceRecord(balanceRecord);
	}
	
	@RequestMapping("/updateWithdrawState")
	public Integer updateWithdrawState(@RequestBody BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		balanceRecord.setbState("已完成");
		return balanceRecordService.updateWithdrawState(balanceRecord);
	}

	@RequestMapping("/getBalanceRecordsListByCondition")
	public PageBean4BalanceRecord getBalanceRecordsListByCondition(@RequestBody PageBean4BalanceRecord pageBean4BalanceRecord) {
		// TODO Auto-generated method stub
		Integer totalCount = balanceRecordService.getBalanceRecordsListByCondition(pageBean4BalanceRecord.getBalanceRecord()).size();
		PageHelper.startPage(pageBean4BalanceRecord.getCurrentPage(),pageBean4BalanceRecord.getPageSize());
		List<BalanceRecord> balanceRecordsList = balanceRecordService.getBalanceRecordsListByCondition(pageBean4BalanceRecord.getBalanceRecord());
		pageBean4BalanceRecord.setBalanceRecordsList(balanceRecordsList);
		pageBean4BalanceRecord.setTotalCount(totalCount);
		return pageBean4BalanceRecord;
	}
	@RequestMapping("/getBalanceRecordsListByInputLike")
	public PageBean4BalanceRecord getBalanceRecordsListByInputLike(@RequestBody PageBean4BalanceRecord pageBean4BalanceRecord) {
		// TODO Auto-generated method stub
		Integer totalCount = balanceRecordService.getBalanceRecordsListByInputLike(pageBean4BalanceRecord.getInputLike()).size();
		PageHelper.startPage(pageBean4BalanceRecord.getCurrentPage(),pageBean4BalanceRecord.getPageSize());	
		List<BalanceRecord> balanceRecordsList = balanceRecordService.getBalanceRecordsListByInputLike(pageBean4BalanceRecord.getInputLike());
		pageBean4BalanceRecord.setBalanceRecordsList(balanceRecordsList);
		pageBean4BalanceRecord.setTotalCount(totalCount);
		return pageBean4BalanceRecord;
	}
	
	@RequestMapping("/getBalanceRecordsListByPhoneAndCondition")
	public PageBean4BalanceRecord getBalanceRecordsListByPhoneAndCondition(@RequestBody PageBean4BalanceRecord pageBean4BalanceRecord) {
		// TODO Auto-generated method stub
		Integer totalCount = balanceRecordService.getBalanceRecordsListByPhoneAndCondition(pageBean4BalanceRecord.getBalanceRecord()).size();
		PageHelper.startPage(pageBean4BalanceRecord.getCurrentPage(),pageBean4BalanceRecord.getPageSize());
		List<BalanceRecord> balanceRecordsList = balanceRecordService.getBalanceRecordsListByPhoneAndCondition(pageBean4BalanceRecord.getBalanceRecord());
		pageBean4BalanceRecord.setBalanceRecordsList(balanceRecordsList);
		pageBean4BalanceRecord.setTotalCount(totalCount);
		return pageBean4BalanceRecord;
	}
	@RequestMapping("/getBalanceRecordsListByPhoneAndInputLike")//用bName代替关键字
	public PageBean4BalanceRecord getBalanceRecordsListByPhoneAndInputLike(@RequestBody PageBean4BalanceRecord pageBean4BalanceRecord) {
		// TODO Auto-generated method stub
		Integer totalCount = balanceRecordService.getBalanceRecordsListByPhoneAndInputLike(pageBean4BalanceRecord.getBalanceRecord()).size();
		PageHelper.startPage(pageBean4BalanceRecord.getCurrentPage(),pageBean4BalanceRecord.getPageSize());	
		List<BalanceRecord> balanceRecordsList = balanceRecordService.getBalanceRecordsListByPhoneAndInputLike(pageBean4BalanceRecord.getBalanceRecord());
		pageBean4BalanceRecord.setBalanceRecordsList(balanceRecordsList);
		pageBean4BalanceRecord.setTotalCount(totalCount);
		return pageBean4BalanceRecord;
	}
	
	
	
	@RequestMapping("/getElderBalanceRecord")
	public List<BalanceRecord> getElderBalanceRecord(@RequestBody BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordService.getElderBalanceRecord(balanceRecord);
	}
	
	@RequestMapping("/getShopBalanceRecord")
	public List<BalanceRecord> getShopBalanceRecord(@RequestBody BalanceRecord balanceRecord) {
		// TODO Auto-generated method stub
		return balanceRecordService.getShopBalanceRecord(balanceRecord);
	}
	
}
