package com.bookshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 * 会员购物记录信息Dao层实现类
 * @author Winds
 *
 */
public class ShoppingRecordDaoImpl extends MyDaoParentImpl implements ShoppingRecordDao{

	public List<?> findHotAuthorBooks(String hql, Session session, int maxLength) {
		Query q = session.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(maxLength);
		return (List<?>)q.list();
	}

}
