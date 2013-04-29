package com.bookshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 收藏信息Dao层实现类
 * @author Winds
 *
 */
public class CollectionDaoImpl extends MyDaoParentImpl implements CollectionDao {

	public List<?> findHotCollection(String hql, Session session, int maxLength) {
		// TODO Auto-generated method stub
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
