package org.sandbox.psychadelic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.dapper.engine.DapperEngine;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PsychadelicTestConfig.class,
	loader=AnnotationConfigContextLoader.class)
public class PsychadelicTest {
	@Autowired
	DapperEngine dEngine;

	@Test
	public void newObjectTest() {
		dEngine.start();
		while (true) { }
		
	}
}
