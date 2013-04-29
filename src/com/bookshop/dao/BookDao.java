package com.bookshop.dao;

import java.util.List;

import org.hibernate.Session;
/**
 * 图书信息Dao层接口
 * @author Winds
 *
 */
public interface BookDao extends MyDaoParent{
	
	public List<?> findAll(String hql,Session session,int maxLength);
}
