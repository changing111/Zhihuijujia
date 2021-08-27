/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.WorkOrder;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface WorkOrderMapper {

	/**
	 * @return
	 */
	List<WorkOrder> getWorkOrdersList();

	/**
	 * @param workOrder
	 * @return
	 */
	Integer addWorkOrder(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	Integer updateWorkOrderState(WorkOrder workOrder);

	/**
	 * @return
	 */
	List<WorkOrder> getWorkOrderByEPhoneNum(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrderBySPhoneNum(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListByCondition(WorkOrder workOrder);

	/**
	 * @param inputLike
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListByInputLike(@Param("inputLike")String inputLike);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListBySPhoneAndCondition(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListBySPhoneAndInputLike(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListByEPhoneAndCondition(WorkOrder workOrder);

	/**
	 * @param workOrder
	 * @return
	 */
	List<WorkOrder> getWorkOrdersListByEPhoneAndInputLike(WorkOrder workOrder);

}
