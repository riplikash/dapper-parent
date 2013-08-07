package com.dapper.engine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SceneGraphTestConfiguration.class,
	loader=AnnotationConfigContextLoader.class)
public class SceneGraphTest {
	@Autowired
	DapperEngine dEngine;

	@Test
	public void simpleInteractiveTest() {
		dEngine.start();
		while (true) { }
		
	}
}
