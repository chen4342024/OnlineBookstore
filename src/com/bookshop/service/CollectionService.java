package com.bookshop.service;

import java.util.List;

import com.bookshop.entity.Collection;
import com.bookshop.entity.Customer;

/**
 * 收藏信息Service层接口
 * @author Winds
 *
 */
public interface CollectionService extends MyServiceParent{
	/**
	 * 查找收藏最多的图书
	 */
	public List<Object> getHotCollection();
	/**
	 * 删除会员图书收藏记录
	 * @param collection_id 收藏记录Id
	 * @return boolean
	 */
	public boolean delete(String collection_id);
	/**
	 * 批量删除会员图书收藏记录
	 * @param collectionIdStr 收藏记录Id串
	 * @return
	 */
	public boolean deleteBatch(String collectionIdStr);
	/**
	 * 分页数据中的各图书的收藏数
	 * @param collection_l
	 * @return
	 */
	public List<Long> findColletionNum(List<Collection> collection_l);
	
	/**
	 * 添加收藏
	 * @return
	 */
	public int addToCollection(long book_id,Customer currentCustomer);
	
}
