package com.dapper.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.testImplementations.FontTestGameEngine;
import com.dapper.engine.testImplementations.SimpleInteractiveGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class FontConfiguration {
	@Bean
	public SimpleInteractiveGraphicsEngine dapperGraphicsEngine() {
		SimpleInteractiveGraphicsEngine engine = new SimpleInteractiveGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Font Test");
		return engine;
		

		
	}
	
	@Bean
	public DapperGameEngineInterface gameEngine() { 
		return new FontTestGameEngine();
	}

}
