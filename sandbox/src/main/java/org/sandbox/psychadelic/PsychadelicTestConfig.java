package org.sandbox.psychadelic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class PsychadelicTestConfig {
	@Bean
	public DapperGraphicsEngineInterface graphicsEngine() {
		DefaultGraphicsEngine engine = new DefaultGraphicsEngine();	
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Psychadelic Test");
		return engine;
		

		
	}
	
	@Bean
	public DapperGameEngineInterface gameEngine() { 
		return new PsychadelicEngine();
	}


}
