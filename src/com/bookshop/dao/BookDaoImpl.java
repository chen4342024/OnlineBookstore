package com.bookshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 图书信息Dao层实现类
 * @author Winds
 *
 */
public class BookDaoImpl extends MyDaoParentImpl implements BookDao {

	public List<?> findAll(String hql, Session session, int maxLength) {
		List<?> l=null;
		Query q = session.createQuery(hql);
		if(q.list().size() > 0){
			q.setFirstResult(0);
			q.setMaxResults(maxLength);
			l=(List<?>)q.list();
		}		
		return l;
	}
	
}
