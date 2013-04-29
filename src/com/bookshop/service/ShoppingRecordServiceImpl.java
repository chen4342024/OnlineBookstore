package com.bookshop.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;

import com.bookshop.dao.BookDao;
import com.bookshop.dao.ShoppingRecordDao;
import com.bookshop.entity.BookItem;
import com.bookshop.entity.Customer;
import com.bookshop.entity.Order;
import com.bookshop.entity.ShoppingRecord;
import com.bookshop.util.DateUtil;
import com.common.service.DateService;
/**
 * 会员购书记录信息Service层实现类
 * @author Winds
 *
 */
public class ShoppingRecordServiceImpl extends MyServiceParentImpl implements
		ShoppingRecordService {
	@Resource
	private ShoppingRecordDao shoppingRecordDao;
	@Resource 
	private BookDao bookDao;
	private String hql;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public List<Object> getHotsale_newbook() {
		String dateString =DateUtil.dateToString(DateUtil.getDateBefore("week", 1));
		session=getSession();
		hql="select b.book_id,b.name from ShoppingRecord as sr join sr.book as b where sr.book.book_id=b.book_id " +
				"and b.sell_date>'" +dateString+
				"' group by sr.book.book_id order by count(sr.book.book_id) desc";
		return (List<Object>)shoppingRecordDao.findAll(hql, session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getHotAuthorBooks() {
		String dateString =DateUtil.dateToString(DateUtil.getDateBefore("month", 1));
		session=this.getSession();
		hql ="select b.author from ShoppingRecord as sr inner join sr.book as b where sr.book.book_id=b.book_id " +
				"and sr.record_date>'" +dateString+
				"' group by b.author order by count(*) desc";
		List<Object> l=(List<Object>)shoppingRecordDao.findHotAuthorBooks(hql, session,4);
		List<Object> hotAuthor_l =new ArrayList<Object>();
		for(Object o:l){
			String hotAuthor=(String)o;
			hql="select b.book_id,b.name,b.book_image,b.price*b.discount,b.discount*100,b.author from Book as b where b.author='"+hotAuthor+"'";
			hotAuthor_l.addAll((List<Object>)bookDao.findAll(hql, session, 4));
		}
		return hotAuthor_l;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getHotsale() {
		session=getSession();
		hql="select b.book_id,b.name,b.book_image,b.price*b.discount,b.discount*100 from ShoppingRecord as sr inner join sr.book as b " +
				"where sr.book.book_id=b.book_id group by sr.book.book_id order by count(*) desc";
		
		return (List<Object>)bookDao.findAll(hql, session, 9);
	}
	
	private void addShoppingRecord(List<ShoppingRecord> shoppingRecordList){
	  session=this.getSession();
	  for(ShoppingRecord shoppingRecord : shoppingRecordList){
	    shoppingRecordDao.save(shoppingRecord, session);
	  }
	}

  public void addShoppingRecord(Order order, Customer currentCustomer, List<BookItem> bookItems) {
    List<ShoppingRecord> shoppingRecordList = new ArrayList<ShoppingRecord>();
    for(BookItem bookItem : bookItems){
      ShoppingRecord shoppingRecord = new ShoppingRecord();
      shoppingRecord.setShopping_record_id(ShoppingRecord.getShoppingRecordUUID());
      shoppingRecord.setBook(bookItem.getBook());
      shoppingRecord.setCustomer(currentCustomer);
      shoppingRecord.setOrder(order);
      shoppingRecord.setRecord_date(DateService.getInstance().now());
      shoppingRecordList.add(shoppingRecord);
    }
    addShoppingRecord(shoppingRecordList);
  }
}











