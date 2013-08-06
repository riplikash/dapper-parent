package com.dapper.engine;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;
import com.dapper.engine.testImplementations.DapperEngineTestGameEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class DapperEngineTestConfiguration {
	@Bean
	public DapperGraphicsEngineInterface dapperGraphicsEngine() {
		DefaultGraphicsEngine engine = new DefaultGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Simple Title");
		return engine;
		

		
	}
	
	@Bean
	public DapperEngineTestGameEngine gameEngine() { 
		return new DapperEngineTestGameEngine();
	}

}
