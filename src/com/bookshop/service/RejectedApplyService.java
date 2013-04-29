package com.bookshop.service;

import com.bookshop.entity.RejectedApply;

/**
 * 会员退货申请信息Service层接口
 * @author Winds
 *
 */
public interface RejectedApplyService extends MyServiceParent{
	public void audit_rejectedApply(String staff_id,String rejected_apply_id, int isPass);//审核退货申请
	public void complete_rejectedApply(String staff_id,String rejected_apply_id);//确认收货完成交易
	public int findPages(int perFolioAmount,String entityName);  //返回总页数
	public RejectedApply find(String rejected_apply_id);
	
}
