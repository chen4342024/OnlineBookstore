package com.bookshop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
/**
 * 图书
 */
@SuppressWarnings("serial")
@Entity
@Table(name="tb_book_in_order")
public class BookInOrder implements Serializable {
	/**
	 * 图书编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long book_id; 
	@Column(length=60,nullable=false)
	private String name;
	/**
	 * 图书封面图片名称
	 * book_id+.jpg
	 */
	@Column(length=100,nullable=false)
	private String book_image;
	
	/**
	 * 图书简介
	 */
	@Column(length=1000,nullable=false)
	private String content_summary;
	/**
	 * 图书ISBN编号
	 */
	@Column(length=30,nullable=false)
	private String isbn;
	/**
	 * 图书作者
	 */
	@Column(length=40,nullable=false)
	private String author;
	/**
	 * 是否是进口书
	 * 1：进口书
	 * 0：非进口书
	 */
	@Column(nullable=false)
	private Integer is_import;
	/**
	 * 是否是外语书
	 * 1：外语书
	 * 0：中文书
	 */
	@Column(nullable=false)
	private Integer is_foreign;
	/**
	 * 译者
	 */
	@Column(length=20,nullable=true)
	private String translator;
	/**
	 * 出版社
	 */
	@Column(length=40,nullable=false)
	private String publish_company;
	/**
	 * 出版时间
	 */
	@Column(nullable=false)
	private Date publish_date;
	
	/**
	 * 图书分类
	 */
	
	@Column(name="catagory_name",nullable=false)
	private String catagoryName;
	/**
	 * 图书销售折扣
	 * 大于0小于1的小数
	 * 初始值为1
	 */
	@Column(nullable=false)
	private float discount;

	/**
	 * 图书原价
	 */
	@Column(nullable=false)
	private float price;
	
	/**
   * 图书购买数量
   */
  @Column(nullable=false)
  private int amount;
	
  public BookInOrder(){
    
  }
  public BookInOrder(BookItem bookItem){
    this.book_id  = bookItem.getBook().getBook_id();       
    this.name  = bookItem.getBook().getName();
    this.book_image  = bookItem.getBook().getBook_image();
    this.content_summary  = bookItem.getBook().getContent_summary();
    this.isbn  = bookItem.getBook().getIsbn();
    this.author  = bookItem.getBook().getAuthor();
    this.is_import  = bookItem.getBook().getIs_import();
    this.is_foreign  = bookItem.getBook().getIs_foreign();
    this.translator  = bookItem.getBook().getTranslator();
    this.publish_company  = bookItem.getBook().getPublish_company();
    this.publish_date  = bookItem.getBook().getPublish_date();
    this.catagoryName  = bookItem.getBook().getCatagory().getCatagory_name();
    this.discount  = bookItem.getBook().getDiscount();
    this.price  = bookItem.getBook().getPrice();
    this.amount  = bookItem.getAmount();
  }
	public long getBook_id() {
    return book_id;
  }
  public void setBook_id(long bookId) {
    book_id = bookId;
  }
  public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBook_image() {
		return book_image;
	}
	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getContent_summary() {
		return content_summary;
	}
	public void setContent_summary(String content_summary) {
		this.content_summary = content_summary;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getIs_import() {
		return is_import;
	}
	public void setIs_import(Integer is_import) {
		this.is_import = is_import;
	}
	public Integer getIs_foreign() {
		return is_foreign;
	}
	public void setIs_foreign(Integer is_foreign) {
		this.is_foreign = is_foreign;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getPublish_company() {
		return publish_company;
	}
	public void setPublish_company(String publish_company) {
		this.publish_company = publish_company;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	
  public String getCatagoryName() {
    return catagoryName;
  }
  public void setCatagoryName(String catagoryName) {
    this.catagoryName = catagoryName;
  }
  public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
	
}
