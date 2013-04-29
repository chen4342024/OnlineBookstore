package com.bookshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bookshop.entity.Customer;

/**
 * 会员信息Service层接口
 * @author Winds
 *
 */
public interface CustomerService extends MyServiceParent{
	/**
	 * 激活会员账号
	 */
	public boolean activityCustomer(String email);
	/**
	 * 发送激活地址到用户注册邮箱
	 */
	public void sendEmail(String email,HttpSession httpSession);
	/**
	 * 用户登录
	 * @param email
	 * @param pw
	 * @return
	 */
	public boolean login(String email,String pw);
	/**
	 * 新增会员
	 * @param customer
	 * @return
	 */
	public boolean save(Customer customer);
	/**
	 * 验证邮箱有效性
	 * @param email
	 * @return
	 */
	public boolean check_email(String email);
	
	/**
	 * 更新用户状态
	 * @param email
	 * @return
	 */
	public int updateState(String email);
	public Customer find(String email);
	
	
}
