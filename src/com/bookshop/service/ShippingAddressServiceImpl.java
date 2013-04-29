package com.bookshop.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;

import com.bookshop.dao.ShippingAddressDao;
import com.bookshop.entity.Customer;
import com.bookshop.entity.ShippingAddress;
import com.common.util.CommonUtil;
/**
 * 收货地址Service层实现类
 * @author Winds
 *
 */
public class ShippingAddressServiceImpl extends MyServiceParentImpl implements
		ShippingAddressService {
	@Resource
	private ShippingAddressDao shippingAddressDao;
	@Resource
	private CustomerService customerService;
	private Session session ;
	private String hql;
	public Set<ShippingAddress> getShippingAddressByEmail(String customer_email) {
		this.session = getSession();
		Customer customer = customerService.find(customer_email);
		Set<ShippingAddress> addresses = new HashSet<ShippingAddress>();
		if (CommonUtil.isNotNullObject(customer)) {
			addresses = customer.getAddresses();
		}
		return addresses;
	}

	public ShippingAddress addOrUpdateShippingAddress(ShippingAddress shippingAddress,Customer customer) {
		try {
			this.session = getSession();
			ShippingAddress s = null;
			if(shippingAddress.getShipping_address_id() == 0){
			  s = new ShippingAddress();
        s.setCustomer(customer);
        customer.getAddresses().add(s);
			}else {
			  s = find(shippingAddress.getShipping_address_id());
      }
			s.setConsignee(shippingAddress.getConsignee());
			s.setShipping_country(shippingAddress.getShipping_country());
			s.setShipping_province(shippingAddress.getShipping_province());
			if(shippingAddress.getShipping_country()==null){
			  shippingAddress.setShipping_country("中国 ");
			}
			s.setShipping_county(shippingAddress.getShipping_county());
			s.setShipping_city(shippingAddress.getShipping_city());
			s.setStreet_address(shippingAddress.getStreet_address());
			s.setPostcode(shippingAddress.getPostcode());
			s.setMobile_phone(shippingAddress.getMobile_phone());
			s.setFixed_phone(shippingAddress.getFixed_phone());
			shippingAddressDao.saveOrUpdate(s, session);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ShippingAddress find(long shipping_address_id){
		this.session = getSession();
		hql = "from ShippingAddress as s where s.shipping_address_id = '"+shipping_address_id + "'";
		return (ShippingAddress)shippingAddressDao.find(hql, session);
	}
	
	
}
