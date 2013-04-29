package com.bookshop.dao;

import java.util.List;

import org.hibernate.Session;
/**
 * 会员购书记录信息Dao层接口
 * @author Winds
 *
 */
public interface ShoppingRecordDao extends MyDaoParent{
	
	/**
	 * 通过HQL查询语句查询热门作者与其书的总销量
	 * @param hql
	 * @param session
	 * @param maxLength
	 * @return
	 */
	public List<?> findHotAuthorBooks(String hql,Session session,int maxLength);
}
