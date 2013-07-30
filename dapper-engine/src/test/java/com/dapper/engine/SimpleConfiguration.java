package com.dapper.engine;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.testImplementations.SimpleGraphicsEngine;
import com.dapper.engine.testImplementations.SimpleInteractiveGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class SimpleConfiguration {
	@Bean
	public SimpleInteractiveGraphicsEngine dapperGraphicsEngine() {
		SimpleInteractiveGraphicsEngine engine = new SimpleInteractiveGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Simple Title");
		return engine;
		

		
	}

}
