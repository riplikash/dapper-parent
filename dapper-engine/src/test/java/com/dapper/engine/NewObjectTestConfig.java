package com.dapper.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.data.objects.SceneRoot;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;
import com.dapper.engine.testImplementations.NewObjectGameEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class NewObjectTestConfig {
	@Bean
	public DapperGraphicsEngineInterface graphicsEngine() {
		DefaultGraphicsEngine engine = new DefaultGraphicsEngine();	
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("New Object Test");
		return engine;
		

		
	}
	
	@Bean
	public DapperGameEngineInterface gameEngine() { 
		return new NewObjectGameEngine();
	}
	
	@Bean 
	public SceneRoot root() {
		return new SceneRoot();
	}

}
