package com.bookshop.unittest;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class BaseTest extends AbstractTransactionalDataSourceSpringContextTests{

	protected String[] getConfigLocations() {    
		  String[] configLocations = {"bean.xml"};
          return configLocations; 
	}
	public BaseTest() {
		setDependencyCheck(false);//不去检查 
	}
	
}
