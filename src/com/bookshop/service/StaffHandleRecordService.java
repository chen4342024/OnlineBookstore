package com.bookshop.service;

import java.util.List;

/**
 * 员工处理会员订单和退货申请记录信息Service层接口
 * @author Winds
 *
 */
public interface StaffHandleRecordService extends MyServiceParent{
	//增加员工处理记录
	public void addStaffHandleRecord(int handle_type,String staff_id,String orderOrRejectedApply_id,int before_handle_status,int after_handle_status );
	
	public Long hasNumbers(String staffId);

//	//根据员工id显示
	public List<?> show_by_page(int page, int perFolioAmount, String staffId);
	
	
	
}
