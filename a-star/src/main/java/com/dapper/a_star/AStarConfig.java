package com.dapper.a_star;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dapper.a_star.interfaces.GameEngine;
import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;
import com.dapper.engine.default_implementations.DefaultScene;

@Configuration
@ComponentScan({"com.dapper.a_star", "com.dapper.engine"})
public class AStarConfig {
	@Bean public DefaultGraphicsEngine graphicsEngine() {
		DefaultGraphicsEngine engine = new DefaultGraphicsEngine();		
		engine.setFPS(60);
		engine.setWindowHeight(600);
		engine.setWindowWidth(800);
		engine.setWindowTitle("A*");
		return engine;
	}
	@Bean public DefaultScene scene() { return new DefaultScene(); }
	
	@Bean DapperGameEngineInterface gameEngine() { return new GameEngine();	}
	
//	@Bean Image cursorImage() {
//		getClass().getClassLoader().getResource("com.dapper.engine.resources.cursor.png")
//		AStarConfig.class.getResource()
//		 
//	}
	@Bean BufferedImage path() {
		try {
			return ImageIO.read(getClass().getClassLoader().getResource("com/dapper/engine/resources/cursor.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
