package com.dapper.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.data.objects.DapperSceneGraph;
import com.dapper.engine.testImplementations.SceneGraphGameEngine;
import com.dapper.engine.testImplementations.SceneGraphGraphicsEngine;

@Configuration
@ComponentScan({"com.dapper.engine"})
public class SceneGraphTestConfiguration {
	@Bean
	public DapperGraphicsEngineInterface dapperGraphicsEngine() {
		SceneGraphGraphicsEngine engine = new SceneGraphGraphicsEngine();	
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("SceneGraph Test");
		return engine;	
	}
	
	@Bean
	public DapperGameEngineInterface gameEngine() { 
		return new SceneGraphGameEngine();
	}
	
	@Bean
	public DapperSceneGraph sceneGraph() {
		return new DapperSceneGraph();
	}

}
