package com.dapper.engine;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DapperEngineTest {

	DapperEngine dEngine;
	
	@Test
	public void testStart() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("testSpring.xml");
		dEngine = (DapperEngine) ctx.getBean("testEngine");
		System.out.println("Starting test");
		dEngine.start();
		while (true) { }
		
	}

	@Test
	public void squareTest() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("squareTest.xml");
		dEngine = (DapperEngine) ctx.getBean("testEngine");
		System.out.println("Starting test");
		dEngine.start();
		while (true) { }
		
	}

}
