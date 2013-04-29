package com.bookshop.service;

import com.bookshop.entity.Staff;

/**
 * 员工信息Service层接口
 * @author Winds
 *
 */
public interface StaffService extends MyServiceParent{
	public Staff find(String staff_id);
	public boolean save(Staff staff);
	public Integer updateState(String staff_id);
	public boolean update(Staff staff);
	public Staff login(String staff_id,String pw);//员工登录
	/**
	 * 修改员工密码
	 * @param staff_id
	 * @param oldPassword
	 * @param newPassword
	 * @return "oldPasswordWrong" "success" "error"
	 */
	public String changePassword(String staff_id,String oldPassword,String newPassword);
	


}
