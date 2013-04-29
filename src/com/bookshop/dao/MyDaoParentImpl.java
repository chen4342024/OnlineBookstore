package com.bookshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class MyDaoParentImpl implements MyDaoParent{
	public void dele(Object obj,Session session){
		session.delete(obj);
	}
	public void save(Object obj,Session session){
		session.save(obj);
	}
	public void update(Object obj,Session session){
		session.update(obj);
	}
	public void saveOrUpdate(Object obj,Session session){
		session.saveOrUpdate(obj);
	}
	public Object find(String hql ,Session session){
		Query quary = session.createQuery(hql);
		if(quary.list().size()!=0){
			return quary.list().get(0);
		}else{
			return null;
		} 
	}
	public Long findCount_all(Session session, String hql) {
		// TODO Auto-generated method stub
		Query q = session.createQuery(hql);
		Long num1 = (Long)q.list().get(0);
		return num1;
	}
	
	public List<?> show_by_page_all(int page, int perFolioAmount,
			Session session, String hql) {
		Query q = session.createQuery(hql);
		q.setFirstResult((page-1)*perFolioAmount);
		q.setMaxResults(perFolioAmount);
		return (List<?>)q.list();
	} 
	 
	
	public List<?> findAll(String hql,Session session){
		Query q = session.createQuery(hql);
		return (List<?>)q.list();
	}

}
