package org.sandbox.dapper.picking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;

@Configuration
@ComponentScan({"com.dapper", "com.dapper.engine"})
public class PickingConfig {
	@Bean public DapperGraphicsEngineInterface graphicsEngine() {
		PickingGraphicsEngine engine = new PickingGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(1000);
		engine.setWindowWidth(800);
		engine.setWindowTitle("Dapper Picking Demo");
		return engine;
	}
	
	@Bean DapperGameEngineInterface gameEngine() { return new PickingEngine();	}
	
}
