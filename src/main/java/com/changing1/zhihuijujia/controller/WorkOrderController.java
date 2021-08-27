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

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.BalanceRecord;
import com.changing1.zhihuijujia.entity.Elder;
import com.changing1.zhihuijujia.entity.PageBean4Elder;
import com.changing1.zhihuijujia.entity.PageBean4WorkOrder;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.entity.WorkOrder;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.BalanceRecordService;
import com.changing1.zhihuijujia.service.ElderService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.changing1.zhihuijujia.service.WorkOrderService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class WorkOrderController {
	@Autowired
	private WorkOrderService workOrderService;
	@Autowired
	private BalanceRecordService balanceRecordService;
	@Autowired
	private ElderService elderService;
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/getWorkOrdersListByCondition")
	public PageBean4WorkOrder getWorkOrdersListByCondition(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListByCondition(pageBean4WorkOrder.getWorkOrder()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListByCondition(pageBean4WorkOrder.getWorkOrder());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	@RequestMapping("/getWorkOrdersListByInputLike")
	public PageBean4WorkOrder getWorkOrdersListByInputLike(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListByInputLike(pageBean4WorkOrder.getInputLike()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());	
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListByInputLike(pageBean4WorkOrder.getInputLike());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	
	@RequestMapping("/getWorkOrdersListBySPhoneAndCondition")
	public PageBean4WorkOrder getWorkOrdersListBySPhoneAndCondition(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListBySPhoneAndCondition(pageBean4WorkOrder.getWorkOrder()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListBySPhoneAndCondition(pageBean4WorkOrder.getWorkOrder());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	@RequestMapping("/getWorkOrdersListBySPhoneAndInputLike")//用wEName代替关键字
	public PageBean4WorkOrder getWorkOrdersListBySPhoneAndInputLike(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListBySPhoneAndInputLike(pageBean4WorkOrder.getWorkOrder()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());	
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListBySPhoneAndInputLike(pageBean4WorkOrder.getWorkOrder());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	@RequestMapping("/getWorkOrdersListByEPhoneAndCondition")
	public PageBean4WorkOrder getWorkOrdersListByEPhoneAndCondition(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListByEPhoneAndCondition(pageBean4WorkOrder.getWorkOrder()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListByEPhoneAndCondition(pageBean4WorkOrder.getWorkOrder());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	@RequestMapping("/getWorkOrdersListByEPhoneAndInputLike")//用wEName代替关键字
	public PageBean4WorkOrder getWorkOrdersListByEPhoneAndInputLike(@RequestBody PageBean4WorkOrder pageBean4WorkOrder) {
		// TODO Auto-generated method stub
		Integer totalCount = workOrderService.getWorkOrdersListByEPhoneAndInputLike(pageBean4WorkOrder.getWorkOrder()).size();
		PageHelper.startPage(pageBean4WorkOrder.getCurrentPage(),pageBean4WorkOrder.getPageSize());	
		List<WorkOrder> workOrdersList = workOrderService.getWorkOrdersListByEPhoneAndInputLike(pageBean4WorkOrder.getWorkOrder());
		pageBean4WorkOrder.setWorkOrdersList(workOrdersList);
		pageBean4WorkOrder.setTotalCount(totalCount);
		return pageBean4WorkOrder;
	}
	
	@RequestMapping("/addWorkOrder")//下单 需要同时添加一条服务币纪录
	public Integer addWorkOrder(@RequestBody WorkOrder workOrder) {		
		Elder elder=new Elder();
		elder.setePhoneNum(workOrder.getwEPhoneNum());
		Integer eBalance=elderService.getEBalanceByEPhoneNum(elder);
		Integer sumPrice=workOrder.getwSgPrice()*workOrder.getwAmount();
		if (eBalance>=sumPrice) {
			BalanceRecord balanceRecord=new BalanceRecord();
			balanceRecord.setbName(workOrder.getwEName());
			balanceRecord.setbPhoneNum(workOrder.getwEPhoneNum());
			balanceRecord.setbState("已完成");
			balanceRecord.setbReason("扣款-下单服务");
			balanceRecord.setbTime(new Date());
			balanceRecord.setbBeforeBal(eBalance);
			balanceRecord.setbAfterBal(eBalance-sumPrice);		
			Integer integer=balanceRecordService.addBalanceRecord(balanceRecord);//加一条服务币纪录
			elder.seteBalance(eBalance-sumPrice);
			Integer integer2=elderService.updateEBalance(elder);            //更新长者用户余额
			
			workOrder.setwSpend(sumPrice);
			workOrder.setwState("已下单");//状态1为已下单
			return workOrderService.addWorkOrder(workOrder);
		} else {//不够余额下单
			return 2;
		}	
	}
	
	@RequestMapping("/updateWorkOrderState1")//更新订单状态为完成
	public Integer updateWorkOrderState1(@RequestBody WorkOrder workOrder) {
		Shop shop=new Shop();
		shop.setsPhoneNum(workOrder.getwSPhoneNum());
		Integer sBalance=shopService.getSBalanceBySPhoneNum(shop);
		Integer sumPrice=workOrder.getwSgPrice()*workOrder.getwAmount();
		BalanceRecord balanceRecord=new BalanceRecord();
		balanceRecord.setbName(workOrder.getwSName());
		balanceRecord.setbPhoneNum(workOrder.getwSPhoneNum());
		balanceRecord.setbState("已完成");
		balanceRecord.setbReason("入账-完成订单");
		balanceRecord.setbTime(new Date());
		balanceRecord.setbBeforeBal(sBalance);
		balanceRecord.setbAfterBal(sBalance+sumPrice);		
		Integer integer=balanceRecordService.addBalanceRecord(balanceRecord);//加一条服务币纪录
		shop.setsBalance(sBalance+sumPrice);
		Integer integer2=shopService.updateSBalance(shop);            //更新商户服务币余额
		workOrder.setwState("已完成");//状态2为已完成
		return workOrderService.updateWorkOrderState(workOrder);		
	}
	
	@RequestMapping("/updateWorkOrderState2")//更新订单状态为取消
	public Integer updateWorkOrderState2(@RequestBody WorkOrder workOrder) {
		Elder elder=new Elder();
		elder.setePhoneNum(workOrder.getwEPhoneNum());
		Integer eBalance=elderService.getEBalanceByEPhoneNum(elder);
		Integer sumPrice=workOrder.getwSgPrice()*workOrder.getwAmount();
		BalanceRecord balanceRecord=new BalanceRecord();
		balanceRecord.setbName(workOrder.getwEName());
		balanceRecord.setbPhoneNum(workOrder.getwEPhoneNum());
		balanceRecord.setbState("已完成");
		balanceRecord.setbReason("退款-取消订单");
		balanceRecord.setbTime(new Date());
		balanceRecord.setbBeforeBal(eBalance);
		balanceRecord.setbAfterBal(eBalance+sumPrice);		
		Integer integer=balanceRecordService.addBalanceRecord(balanceRecord);//加一条服务币纪录
		elder.seteBalance(eBalance+sumPrice);
		Integer integer2=elderService.updateEBalance(elder);            //更新长者用户余额
		workOrder.setwState("已取消");
		return workOrderService.updateWorkOrderState(workOrder);		
	}
	
	@RequestMapping("/getWorkOrderByEPhoneNum")
	public List<WorkOrder> getWorkOrderByEPhoneNum(@RequestBody WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderService.getWorkOrderByEPhoneNum(workOrder);		
	}
	
	@RequestMapping("/getWorkOrderBySPhoneNum")
	public List<WorkOrder> getWorkOrderBySPhoneNum(@RequestBody WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderService.getWorkOrderBySPhoneNum(workOrder);		
	}
	
}
