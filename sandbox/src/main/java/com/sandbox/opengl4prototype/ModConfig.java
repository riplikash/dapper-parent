package com.sandbox.opengl4prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class ModConfig {
	@Bean
	public DapperGraphicsEngineInterface graphicsEngine() {
		ModGraphicsEngine engine = new ModGraphicsEngine();	
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Modern Graphics Test");
		return engine;
	
	}
	
	@Bean
	public DapperGameEngineInterface gameEngine() { 
		return new ModGameEngine();
	}
}