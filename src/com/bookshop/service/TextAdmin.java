package com.bookshop.service;

import javax.annotation.Resource;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import com.bookshop.dao.AdminDao;

import junit.framework.TestCase;

public class TextAdmin extends TestCase{
	public static BeanFactory factory = null;     
	public static SessionFactory sessionFactory = null;     
	public static Session session = null; 
	private AdminService adminService;
	private AdminDao adminDao;
	public void setUp(){
		 try{     
		        factory = new ClassPathXmlApplicationContext("bean.xml");     
		        sessionFactory = (SessionFactory) factory.getBean("sessionFactory");     
		        session = sessionFactory.openSession();     
		        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));     
		        adminDao = (AdminDao) factory.getBean("adminDao");     
		        adminService = (AdminService) factory.getBean("adminService"); 
		        System.out.println();
		    }catch(Exception e){     
		        e.printStackTrace();     
		    }       
		 
	}
	public void testLogin(){
		
		int result = adminService.login("21", "123");
		assertEquals(1, result);
	}
}
