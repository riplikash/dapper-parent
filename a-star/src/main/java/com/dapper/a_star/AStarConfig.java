package com.dapper.a_star;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.a_star.interfaces.GraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class AStarConfig {
	@Bean public GraphicsEngine graphicsEngine() {
		GraphicsEngine engine = new GraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("A*");
		return engine;
	}
}
