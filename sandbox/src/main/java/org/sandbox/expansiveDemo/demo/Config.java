package org.sandbox.expansiveDemo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;

@Configuration
@ComponentScan({"org.sandbox", "com.dapper.engine"})
public class Config {
	@Bean public DefaultGraphicsEngine graphicsEngine() {
		DefaultGraphicsEngine engine = new DefaultGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(1000);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Test Engine");
		return engine;
	}
	
	@Bean DapperGameEngineInterface gameEngine() { return new GameEngine();	}
	
}
