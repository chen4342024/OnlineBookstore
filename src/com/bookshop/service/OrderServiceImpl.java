	package com.bookshop.service;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;


import com.bookshop.dao.OrderDao;
import com.bookshop.entity.Book;
import com.bookshop.entity.BookItem;
import com.bookshop.entity.Customer;
import com.bookshop.entity.Order;
import com.bookshop.entity.OrderStatus;
import com.bookshop.entity.PaymentMethod;
import com.bookshop.entity.ShippingAddress;
import com.bookshop.entity.ShoppingCart;
import com.common.service.DateService;
import com.common.util.CommonUtil;
import com.common.util.StringUtil;
/**
 * 订单信息Service层实现类
 * @author Winds
 *
 */
public class OrderServiceImpl extends MyServiceParentImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private StaffHandleRecordService staffHandleRecordService;
	@Resource
	private ShoppingRecordService shoppingRecordService;
	@Resource 
	private PaymentMethodService paymentMethodService;
	@Resource
	private ShippingAddressService shippingAddressService;
	@Resource
	private ShoppingCartService shoppingCartService;
	@Resource
  private BookService bookService;
	private Session session ;
	private String hql;
	/*
	 * 审核订单 
	 */
	public void audit_order(String staff_id,String order_id,int isPass) {
		this.session = getSession();
		hql = "from Order as order where order.order_id='"+order_id+"'";
		Order order = (Order)orderDao.find(hql, session);
		int before_handle_status =  order.getStatus();
		if(isPass == 1)
			order.setStatus(OrderStatus.AUDIT_SUCCESS);
		else if(isPass == 0)
			order.setStatus(OrderStatus.AUDIT_FAIL);
		orderDao.update(order, session);
		int after_handle_status = order.getStatus();
		staffHandleRecordService.addStaffHandleRecord(1, staff_id,order_id , before_handle_status, after_handle_status);
	}
	/*
	 * 发货
	 */
	public void deliver_goods(String staff_id,String order_id){
		this.session = getSession();
		hql = "from Order as order where order.order_id='"+order_id+"'";
		Order order = (Order)orderDao.find(hql, session);
		int before_handle_status =  order.getStatus();
		order.setStatus(OrderStatus.DELIVERY_SUCCESS);
		orderDao.update(order, session);
		int after_handle_status = order.getStatus();
		staffHandleRecordService.addStaffHandleRecord(1, staff_id,order_id , before_handle_status, after_handle_status);
	}
	
	public void changeOrderStatus(String order_id,int status){
	  this.session = getSession();
    Order order = this.find(order_id);
    order.setStatus(status);
    orderDao.update(order, session);
	}
	
	public Order find(String order_id){
		this.session = getSession();
		hql = "from Order as o where o.order_id = '"+order_id+"'";
		Order order = (Order)orderDao.find(hql, session);
		return order;
	}

	@Transactional
	public boolean commitOrder(Order order, Customer currentCustomer,ShoppingCart shoppingCart) {
		this.session = getSession();
		List <BookItem> bookItems = shoppingCartService.getBookFromCart(shoppingCart);
		try{
		  Order dbOrder = constructOrder(order, bookItems, currentCustomer);
			orderDao.save(dbOrder, session);
			shoppingRecordService.addShoppingRecord(order, currentCustomer,bookItems);
			for(BookItem bookItem :bookItems){
			  bookService.decrementStorageNum(bookItem.getBook().getBook_id(),bookItem.getAmount());
	    }
			shoppingCartService.clearShoppingCart(shoppingCart);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	private Order constructOrder(Order order,List <BookItem> bookItems,Customer currentCustomer){
	  PaymentMethod paymentMethod= paymentMethodService.findById(order.getPaymentMethod().getPayment_method_id());
    ShippingAddress shippingAddress = null;
    if (order.getShippingAddress().getShipping_address_id() == 0) {
      shippingAddress = shippingAddressService.addOrUpdateShippingAddress(order.getShippingAddress(),currentCustomer);
    }else {
      shippingAddress = shippingAddressService.find(order.getShippingAddress().getShipping_address_id());
    }
    String book_ids="";
    for(BookItem b :bookItems){
      book_ids = book_ids +  b.getBook().getBook_id()+"," ;
    }
    order.setBook_ids(book_ids);
    order.setOrder_date(DateService.getInstance().now());
    order.setStatus(0);
    order.setCustomer(currentCustomer);
    order.setPaymentMethodName(paymentMethod.getName());
    setOrderShippingAddress(shippingAddress,order);
    return order;
	}
	
	private void setOrderShippingAddress(ShippingAddress shippingAddress,Order order){
	  order.setConsignee(shippingAddress.getConsignee());
    order.setShipping_country(shippingAddress.getShipping_country());
    order.setShipping_province( shippingAddress.getShipping_province());
    order.setShipping_city( shippingAddress.getShipping_city());
    order.setShipping_county(shippingAddress.getShipping_county());
    order.setStreet_address(shippingAddress.getStreet_address());
    order.setPostcode(shippingAddress.getPostcode());
    order.setMobile_phone(shippingAddress.getMobile_phone());
    order.setFixed_phone(shippingAddress.getFixed_phone());
	}

	/**
	 * 查找订单的图书
	 */
	public List<Book> findBooks(String order_id) {
		// TODO Auto-generated method stub
		this.session = getSession();
		List<Book> book_l = new ArrayList<Book>();
		hql = "from Order as o where o.order_id = '"+order_id+"'";
		Order order = (Order)orderDao.find(hql, session);
		String book_idString = order.getBook_ids();
		String[] book_ids = book_idString.split(",");
		for (String s : book_ids) {
			hql = "from Book as b where b.book_id = '"+s+"'";
			Book book = (Book)orderDao.find(hql, session);
			if(book!=null)
				book_l.add(book);			
		}
		return book_l;
	}
	/**
	 * 查找分页显示订单所需要的图书
	 */
	public List<List<Book>> findBook_l(List<Order> order_l) {
		// TODO Auto-generated method stub
		List<List<Book>> book_l_l=new ArrayList<List<Book>>();
		if(order_l!=null){
			for(Order o:order_l){
				book_l_l.add(findBooks(o.getOrder_id()));
			}
		}		
		return book_l_l;
	}
	/**
	 * 删除订单
	 */
	public boolean delete(String orderId) {
		// TODO Auto-generated method stub
		this.session = getSession();
		hql = "from Order as o where o.order_id = '"+orderId+"'";
		Order order = (Order)orderDao.find(hql, session);
		orderDao.dele(order, session);
		return true;
	}
	

}
