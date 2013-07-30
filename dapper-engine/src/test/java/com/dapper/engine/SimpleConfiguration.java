package com.dapper.engine;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.testImplementations.SimpleGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class SimpleConfiguration {
	@Bean
	public SimpleGraphicsEngine dapperGraphicsEngine() {
		SimpleGraphicsEngine engine = new SimpleGraphicsEngine();
		List<Float> list = Arrays.asList((float)-.8, (float) -.8, (float) .2, (float) .8, (float) -.6, (float) -.4, (float) -.6, (float) -.4, (float) .6, (float) .8, (float) .8, (float) .2 );
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Simple Title");
		engine.setScene(list);
		return engine;
		

		
	}

}
