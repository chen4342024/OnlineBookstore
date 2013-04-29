package com.bookshop.action;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bookshop.entity.Customer;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.service.CustomerService;
import com.bookshop.service.ShippingAddressService;
import com.bookshop.util.BookStoreConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 收货地址Action层
 * @author Winds
 *
 */
@SuppressWarnings("serial")
public class ShippingAddressAction extends BaseAction {
	@Resource 
	private ShippingAddressService shippingAddressService;
	@Resource 
	private CustomerService customerService;
	private Set<ShippingAddress> shippingAddressSet;
	private ShippingAddress shippingAddress;
	private Map<String,Object> session;
	
	public void getShippingAddressByEmail(){
		shippingAddressSet = new HashSet<ShippingAddress>();
		shippingAddressSet = shippingAddressService.getShippingAddressByEmail(getCurrentCustomer().getEmail());
	}
	
	public void updateShippingAddress(){
	  session = ActionContext.getContext().getSession();
		PrintWriter out = null;
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			if(session.containsKey(BookStoreConstant.SESSION_CUSTOMER)){
				Customer customer =(Customer) session.get(BookStoreConstant.SESSION_CUSTOMER);
				long shippingAddressId = ((ShippingAddress)shippingAddressService.addOrUpdateShippingAddress(shippingAddress,customer)).getShipping_address_id();
				out = response.getWriter();
				out.print(shippingAddressId);
			}
		}catch(Exception e){
			out.print("input");
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}

	public ShippingAddressService getShippingAddressService() {
		return shippingAddressService;
	}

	public void setShippingAddressService(
			ShippingAddressService shippingAddressService) {
		this.shippingAddressService = shippingAddressService;
	}

	
	public Set<ShippingAddress> getShippingAddressSet() {
		return shippingAddressSet;
	}
	public void setShippingAddressSet(Set<ShippingAddress> shippingAddressSet) {
		this.shippingAddressSet = shippingAddressSet;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
