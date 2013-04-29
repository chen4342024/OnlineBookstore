package com.bookshop.dao;

import java.util.List;

import org.hibernate.Session;
/**
 * 收藏信息Dao层接口
 * @author Winds
 *
 */
public interface CollectionDao extends MyDaoParent{
	
	/**
	 * 查找热门收藏
	 * @param hql
	 * @param session
	 * @param maxLength
	 * @return
	 */
	public List<?> findHotCollection(String hql,Session session,int maxLength);
}
