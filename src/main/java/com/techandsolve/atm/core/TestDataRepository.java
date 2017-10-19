package com.techandsolve.atm.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDataRepository {
	
	private static TestDataRepository instance;
	
	private ApplicationContext context = null;
	private TestData testData;
	
	private TestDataRepository() {
		init();
	}

	public static TestDataRepository getInstance() {
		if (instance == null) {
			instance = new TestDataRepository();
		}
		return instance;
	}
	
	public void init() {
		this.context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		this.testData = (TestData) this.context.getBean("testData");
	}

	public TestData getTestData() {
		return this.testData;
	}

}
