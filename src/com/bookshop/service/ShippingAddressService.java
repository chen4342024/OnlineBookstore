package com.bookshop.service;

import java.util.Set;

import com.bookshop.entity.Customer;
import com.bookshop.entity.ShippingAddress;

/**
 * 收货地址Service层接口
 * @author Winds
 *
 */
public interface ShippingAddressService extends MyServiceParent{
	/**
	 * 根据会员账号获取收货信息
	 * @param customer_email
	 * @return
	 */
	public Set<ShippingAddress> getShippingAddressByEmail(String customer_email);
	/**
	 * 修改收货信息
	 * @param shipping_address_id
	 * @return
	 */
	public ShippingAddress addOrUpdateShippingAddress(ShippingAddress shippingAddress,Customer customer) ;
	/**
	 * 根据ID查找送货地址
	 * @param shipping_address_id
	 * @return
	 */
	public ShippingAddress find(long shipping_address_id);
}
