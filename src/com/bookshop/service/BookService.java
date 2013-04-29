package com.bookshop.service;

import com.bookshop.entity.Book;

/**
 * 图书信息Service层接口
 * @author Winds
 *
 */
public interface BookService extends MyServiceParent{
	public int findInventory(long book_id);
	public Book find(long book_id);
	public boolean updateStatus(long book_id,int status);
	public boolean updateDiscount(Book book);
	public boolean increaseStorageNum(long bookId,int storageNum);
	/**
	 * 减少库存
	 * @param book_id 图书ID
	 * @param decrement 减少的数量 eg：1
	 */
	public void decrementStorageNum(long book_id,int decrement);
	public boolean update(Book book,int catagory_id);
	public boolean add(Book book,int catagory_id);
	
}
