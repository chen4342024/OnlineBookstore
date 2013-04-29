package com.bookshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.mail.imap.protocol.Status;
/**
 * 会员订单
 */
@SuppressWarnings("serial")
@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	/**
	 * 订单编号
	 * UUID
	 */
	@Id
	@Column(length=40)
	private String order_id;
	/**
	 * 下单日期
	 */
	@Column(nullable=false)
	private Date order_date;
	/**
	 * 取消订单日期
	 */
	@Column(nullable=true)
	private Date cancel_date;
	/**
	 * 订单包含的图书编号
	 * 以","隔开
	 */
	@Column(length=1000,nullable=false)
	private String book_ids;
	/**
	 * 订单总金额
	 */
	@Column(nullable=false)
	private float amount;
	/**
	 * 付款方式
	 */
	@Column(name="payment_method_name",length=20,nullable=false)
	private String paymentMethodName;
	
	/**
   * 收货人姓名
   */
  @Column(length=30,nullable=false)
  private String  consignee;
  /**
   * 收货国家
   */
  @Column(length=20,nullable=false)
  private String shipping_country;
  /**
   * 收货省份
   */
  @Column(length=10,nullable=false)
  private String shipping_province;
  /**
   * 收货城市
   */
  @Column(length=10,nullable=false)
  private String shipping_city;
  /**
   * 收货区县
   */
  @Column(length=16,nullable=false)
  private String shipping_county;
  /**
   * 收货街道地址
   */
  @Column(length=200,nullable=false)
  private String street_address;
  /**
   * 邮政编码
   */
  @Column(length=10,nullable=false)
  private String postcode;
  /**
   * 联系手机
   */
  @Column(length=20)
  private String mobile_phone;
  /**
   * 固定电话
   */
  @Column(length=20)
  private String fixed_phone;
	/**
	 * 订单状态
	 * 0：等待审核
	 * 1：审核成功，等待发货
	 * 2：审核失败
	 * 3：已发货
	 * 4：交易成功
	 * 5：已取消
	 */
	@Column(nullable=false)
	private Integer status;
	/**
	 * 下单会员
	 */
	@ManyToOne(optional=false,targetEntity=Customer.class,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_email",nullable=false)
	private Customer customer;
	
	@Transient
	private ShippingAddress shippingAddress;
	
	@Transient
  private PaymentMethod paymentMethod;
	
	public Order(){
		
	}
	@Transient
	public static String generateOrderId(){
    return UUID.randomUUID().toString();
  }
	
	public String getOrder_id() {
		return order_id.toLowerCase();
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Date getCancel_date() {
		return cancel_date;
	}
	public void setCancel_date(Date cancel_date) {
		this.cancel_date = cancel_date;
	}
	public String getBook_ids() {
		return book_ids;
	}
	public void setBook_ids(String book_ids) {
		this.book_ids = book_ids;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
  public String getPaymentMethodName() {
    return paymentMethodName;
  }
  public void setPaymentMethodName(String paymentMethodName) {
    this.paymentMethodName = paymentMethodName;
  }
 
  public ShippingAddress getShippingAddress() {
    return shippingAddress;
  }
  public void setShippingAddress(ShippingAddress shippingAddress) {
    this.shippingAddress = shippingAddress;
  }
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
  public String getConsignee() {
    return consignee;
  }
  public void setConsignee(String consignee) {
    this.consignee = consignee;
  }
  public String getShipping_country() {
    return shipping_country;
  }
  public void setShipping_country(String shippingCountry) {
    shipping_country = shippingCountry;
  }
  public String getShipping_province() {
    return shipping_province;
  }
  public void setShipping_province(String shippingProvince) {
    shipping_province = shippingProvince;
  }
  public String getShipping_city() {
    return shipping_city;
  }
  public void setShipping_city(String shippingCity) {
    shipping_city = shippingCity;
  }
  public String getShipping_county() {
    return shipping_county;
  }
  public void setShipping_county(String shippingCounty) {
    shipping_county = shippingCounty;
  }
  public String getStreet_address() {
    return street_address;
  }
  public void setStreet_address(String streetAddress) {
    street_address = streetAddress;
  }
  public String getPostcode() {
    return postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
  public String getMobile_phone() {
    return mobile_phone;
  }
  public void setMobile_phone(String mobilePhone) {
    mobile_phone = mobilePhone;
  }
  public String getFixed_phone() {
    return fixed_phone;
  }
  public void setFixed_phone(String fixedPhone) {
    fixed_phone = fixedPhone;
  }
  
  
}
