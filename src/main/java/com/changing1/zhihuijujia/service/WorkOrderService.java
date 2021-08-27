/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.WorkOrder;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
import com.changing1.zhihuijujia.mapper.WorkOrderMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class WorkOrderService implements WorkOrderMapper {
	@Autowired
	WorkOrderMapper workOrderMapper;

	/**
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersList() {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersList();
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public Integer addWorkOrder(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.addWorkOrder(workOrder);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public Integer updateWorkOrderState(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.updateWorkOrderState(workOrder);
	}

	/**
	 * @return
	 */
	public List<WorkOrder> getWorkOrderByEPhoneNum(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrderByEPhoneNum(workOrder);
	}

	/**
	 * @return
	 */
	public List<WorkOrder> getWorkOrderBySPhoneNum(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrderBySPhoneNum(workOrder);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListByCondition(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListByCondition(workOrder);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListByInputLike(inputLike);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListBySPhoneAndInputLike(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListBySPhoneAndInputLike(workOrder);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListBySPhoneAndCondition(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListBySPhoneAndCondition(workOrder);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListByEPhoneAndCondition(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListByEPhoneAndCondition(workOrder);
	}

	/**
	 * @param workOrder
	 * @return
	 */
	public List<WorkOrder> getWorkOrdersListByEPhoneAndInputLike(WorkOrder workOrder) {
		// TODO Auto-generated method stub
		return workOrderMapper.getWorkOrdersListByEPhoneAndInputLike(workOrder);
	}


}
