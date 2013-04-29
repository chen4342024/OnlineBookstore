package com.bookshop.service;

import java.util.List;

import com.bookshop.entity.Book;
import com.bookshop.entity.Customer;
import com.bookshop.entity.Order;
import com.bookshop.entity.ShoppingCart;

public interface OrderService extends MyServiceParent{

	public void audit_order(String staff_id,String order_id,int isPass);//审核订单
	public void deliver_goods(String staff_id,String order_id);//发货
	public boolean delete(String orderId);//删除
	public void changeOrderStatus(String order_id,int status);
	//返回总页数
	public int findPages(int perFolioAmount,String entityName); 
	public int findPages(int perFolioAmount,String entityName,int status);
	
	//会员确认订单
	public boolean commitOrder(Order order, Customer currentCustomer,ShoppingCart shoppingCart);
	
	//	根据ID获取订单
	public Order find(String order_id);
	public List<Book> findBooks(String order_id);
	public List<List<Book>> findBook_l(List<Order> order_l);
	//返回总数据个数
	 
	
	
}
