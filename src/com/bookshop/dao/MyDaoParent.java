package com.bookshop.dao;

import java.util.List;

import org.hibernate.Session;


public interface MyDaoParent {
	public void dele(Object obj,Session session);
	public void save(Object obj,Session session);
	public void update(Object obj,Session session);
	public void saveOrUpdate(Object obj,Session session);
	public Object find(String hql ,Session session);
	public Long findCount_all(Session session, String hql);
	public List<?> show_by_page_all(int page, int perFolioAmount,
			Session session, String hql);
	public  List<?> findAll(String hql,Session session);
}
